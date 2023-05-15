package com.danielpineros.Service;

import com.danielpineros.Model.Pelicula;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Interfaz del servicio de películas.
 */
public interface InterfazServicioPelicula {

    /**
     * Obtiene todas las películas según la página especificada.
     *
     * @param page número de página
     * @return lista de películas
     */
    List<Object> obtenerTodasLasPeliculas(Integer page);

    /**
     * Obtiene los detalles de una película por su ID.
     *
     * @param id ID de la película
     * @return objeto de película
     */
    Pelicula obtenerDetallesDePeliculaPorId(Integer id);

    /**
     * Establece la calificación de una película.
     *
     * @param ratingRequest   objeto de calificación
     * @param id              ID de la película
     * @param idInvitado  ID de sesión de invitado
     * @return ResponseEntity con el resultado de la operación
     */
    ResponseEntity establecerCalificacionDePelicula(Object ratingRequest, Integer id, String idInvitado);

    /**
     * Obtiene las calificaciones de películas de un invitado según la página especificada.
     *
     * @param idInvitado ID de sesión de invitado
     * @param page           número de página
     * @return lista de calificaciones de películas
     */
    List<Object> obtenerCalificacionesDeInvitado(String idInvitado, Integer page);

    /**
     * Elimina la calificación de una película.
     *
     * @param id             ID de la película
     * @param idInvitado ID de sesión de invitado
     * @return ResponseEntity con el resultado de la operación
     */
    ResponseEntity eliminarCalificacionDePelicula(Integer id, String idInvitado);
}
