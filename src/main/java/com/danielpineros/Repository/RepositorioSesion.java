package com.danielpineros.Repository;

import com.danielpineros.Model.Sesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Implementación del repositorio de sesiones.
 */
@Repository
public class RepositorioSesion implements InterfazRepositorioSesion {

    @Value("cdd3ecef12c59f84875490ad9325a4c3")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    /**
     * Obtiene una nueva sesión de invitado.
     *
     * @return ResponseEntity con la sesión de invitado
     */
    public ResponseEntity obtenerSesionInvitado(){

        String url = String.format("%s/authentication/sesion_invitado/new?api_key=%s", apiUrl, apiKey);

        try {

            return restTemplate.getForEntity(url, Sesion.class);

        }catch (HttpClientErrorException e) {

            return new ResponseEntity<>("", e.getStatusCode());

        }
    }
}
