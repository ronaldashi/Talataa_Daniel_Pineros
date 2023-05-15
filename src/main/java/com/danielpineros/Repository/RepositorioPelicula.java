package com.danielpineros.Repository;

import com.danielpineros.Model.Pelicula;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de películas.
 */
@Repository
public class RepositorioPelicula implements InterfazRepositorioPelicula {

    @Value("cdd3ecef12c59f84875490ad9325a4c3")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Obtiene una lista de películas por página.
     *
     * @param page El número de página
     * @return Una lista de películas
     */
    public List<Object> obtenerTodasLasPeliculas(Integer page) {
        List<Object> movies = new ArrayList<>();
        String url = String.format("%s/discover/movie?api_key=%s&page=%d", apiUrl, apiKey, page);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject json = new JSONObject(response.getBody());
            JSONArray resultsArray = json.getJSONArray("results");

            movies = resultsArray.toList();
        } catch (HttpClientErrorException e) {
            System.err.println(e.getMessage());
        }

        return movies;
    }

    /**
     * Obtiene todas las películas de todas las páginas.
     *
     * @return Una lista de películas
     */
    public List<Object> obtenerTodasLasPeliculas() {
        List<Object> listMovies = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            String url = String.format("%s/discover/movie?api_key=%s&page=%d", apiUrl, apiKey, i);

            try {
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                JSONObject json = new JSONObject(response.getBody());
                JSONArray resultsArray = json.getJSONArray("results");

                List movies = resultsArray.toList();

                listMovies.addAll(movies);
            } catch (HttpClientErrorException e) {
                System.err.println(e.getMessage());
            }
        }

        return listMovies;
    }

    /**
     * Busca una película por su ID.
     *
     * @param id El ID de la película
     * @return La película encontrada o null si no se encuentra
     */
    public Pelicula obtenerTodasLasPeliculasPorId(Integer id) {
        String url = String.format("%s/movie/%d?api_key=%s", apiUrl, id, apiKey);

        try {
            return restTemplate.getForEntity(url, Pelicula.class).getBody();
        } catch (HttpClientErrorException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Envía una calificación para una película.
     *
     * @param ratingRequest   La calificación a enviar
     * @param id              El ID de la película
     * @param idInvitado  El ID de sesión del invitado
     * @return ResponseEntity con el resultado de la operación
     */
    public ResponseEntity enviarCalificacion(Object ratingRequest, Integer id, String idInvitado) {
        String url = String.format("%s/movie/%d/rating?api_key=%s&id_invitado=%s", apiUrl, id, apiKey, idInvitado);

        try {
            return restTemplate.postForEntity(url,ratingRequest, Object.class);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>("", e.getStatusCode());
        }
    }
    /**
     * Obtiene todas las calificaciones de películas de un invitado en una página específica.
     *
     * @param idInvitado El ID de sesión del invitado
     * @param page           El número de página
     * @return Una lista de calificaciones de películas
     */
    public List<Object> obtenerTodasLasCalificaciones(String idInvitado, Integer page) {
        String url = String.format("%s/ssesion_invitado/%s/rated/movies?api_key=%s&page=%d", apiUrl, idInvitado, apiKey, page);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject json = new JSONObject(response.getBody());
            JSONArray resultsArray = json.getJSONArray("results");

            return resultsArray.toList();
        } catch (HttpClientErrorException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Elimina la calificación de una película dada por un invitado.
     *
     * @param id              El ID de la película
     * @param idInvitado  El ID de sesión del invitado
     * @return ResponseEntity con el resultado de la operación
     */
    public ResponseEntity eliminarCalificacion(Integer id, String idInvitado) {
        String url = String.format("%s/movie/%d/rating?api_key=%s&id_invitado=%s", apiUrl, id, apiKey, idInvitado);

        try {
            return restTemplate.exchange(url, HttpMethod.DELETE, null, Object.class);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>("", e.getStatusCode());
        }
    }
}
