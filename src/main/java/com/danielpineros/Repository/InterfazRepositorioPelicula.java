package com.danielpineros.Repository;

import com.danielpineros.Model.Pelicula;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Interfaz del repositorio de películas.
 */
public interface InterfazRepositorioPelicula {

    /**
     * Obtiene una lista de películas por página.
     *
     * @param page número de página
     * @return lista de películas
     */
    List<Object> obtenerTodasLasPeliculas(Integer page);


    /**
     * Obtiene todas las películas.
     *
     * @return lista de películas
     */
    List<Object> obtenerTodasLasPeliculas();


    /**
     * Obtiene una película por su ID.
     *
     * @param id ID de la película
     * @return película encontrada
     */
    Pelicula obtenerTodasLasPeliculasPorId(Integer id);


    /**
     * Envía una calificación de película.
     *
     * @param ratingRequest   calificación de película
     * @param id              ID de la película
     * @param idInvitado  ID de la sesión de invitado
     * @return ResponseEntity con la respuesta de la calificación
     */
    ResponseEntity enviarCalificacion(Object ratingRequest, Integer id, String idInvitado);


    /**
     * Obtiene todas las calificaciones de películas de un invitado.
     *
     * @param idInvitado  ID de la sesión de invitado
     * @param page            número de página
     * @return lista de calificaciones de películas
     */
    List<Object> obtenerTodasLasCalificaciones(String idInvitado, Integer page);


    /**
     * Elimina una calificación de película.
     *
     * @param id              ID de la película
     * @param idInvitado  ID de la sesión de invitado
     * @return ResponseEntity con la respuesta de eliminación de calificación
     */
    ResponseEntity eliminarCalificacion(Integer id, String idInvitado);

}
