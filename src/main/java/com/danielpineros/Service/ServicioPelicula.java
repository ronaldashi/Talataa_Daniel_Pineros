package com.danielpineros.Service;

import com.danielpineros.Model.Pelicula;
import com.danielpineros.Repository.InterfazRepositorioPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de películas.
 */
@Service
public class ServicioPelicula implements InterfazServicioPelicula {

    @Autowired
    InterfazRepositorioPelicula movieRepository;

    /**
     * Obtiene todas las películas según la página especificada.
     *
     * @param page número de página
     * @return lista de películas
     */
    public List<Object> obtenerTodasLasPeliculas(Integer page){
        return movieRepository.obtenerTodasLasPeliculas(page);
    }

    /**
     * Obtiene los detalles de una película según su ID.
     *
     * @param id ID de la película
     * @return objeto Movie con los detalles de la película
     */
    public Pelicula obtenerDetallesDePeliculaPorId(Integer id){
        return movieRepository.obtenerTodasLasPeliculasPorId(id);
    }

    /**
     * Establece la calificación de una película.
     *
     * @param request       objeto de calificación
     * @param id            ID de la película
     * @param idInvitado ID de sesión de invitado
     * @return ResponseEntity con el resultado de la operación
     */
    public ResponseEntity establecerCalificacionDePelicula(Object request, Integer id, String idInvitado) {
        return movieRepository.enviarCalificacion(request, id, idInvitado);
    }

    /**
     * Obtiene las calificaciones de películas realizadas por un invitado.
     *
     * @param idInvitado ID de sesión de invitado
     * @param page           número de página
     * @return lista de calificaciones de películas
     */
    public List<Object> obtenerCalificacionesDeInvitado(String idInvitado, Integer page){
        return movieRepository.obtenerTodasLasCalificaciones(idInvitado, page);
    }

    /**
     * Elimina la calificación de una película.
     *
     * @param id            ID de la película
     * @param idInvitado ID de sesión de invitado
     * @return ResponseEntity con el resultado de la operación
     */
    public ResponseEntity eliminarCalificacionDePelicula(Integer id, String idInvitado) {
        return movieRepository.eliminarCalificacion(id, idInvitado);
    }
}
