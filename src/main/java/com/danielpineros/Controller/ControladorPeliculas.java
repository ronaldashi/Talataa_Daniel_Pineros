package com.danielpineros.Controller;

import com.danielpineros.Service.InterfazServicioPelicula;
import com.danielpineros.Model.RespuestaAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class ControladorPeliculas {

    @Autowired
    private InterfazServicioPelicula movieService;

    /**
     * Obtiene todas las películas paginadas.
     *
     * @param page Número de página para la paginación (opcional, valor predeterminado: 1)
     * @return ResponseEntity con ApiResponse que contiene la lista de películas o un mensaje de error
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerTodasLasPeliculas(@RequestParam(name = "page", defaultValue = "1", required = false) int page) {

        List<Object> listaPeliculas = movieService.obtenerTodasLasPeliculas(page);

        if (listaPeliculas.isEmpty()) {
            return new ResponseEntity<>(new RespuestaAPI("404", "No se encontraron películas", listaPeliculas), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new RespuestaAPI("200", "Éxito", listaPeliculas), HttpStatus.OK);
    }

    /**
     * Obtiene los detalles de una película según su ID.
     *
     * @param id ID de la película
     * @return ResponseEntity con ApiResponse que contiene los detalles de la película o un mensaje de error
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerDetallesDePeliculaPorId(@PathVariable("id") Integer id) {

        List<Object> contenido = new ArrayList<>();
        contenido.add(movieService.obtenerDetallesDePeliculaPorId(id));

        if (contenido.isEmpty()) {
            return new ResponseEntity<>(new RespuestaAPI("404", "No se encontró la película", contenido), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new RespuestaAPI("200", "Éxito", contenido), HttpStatus.OK);
    }

    /**
     * Establece una calificación para una película.
     *
     * @param ratingRequest  Calificación de la película
     * @param id             ID de la película
     * @param idInvitado ID de la sesión del invitado
     * @return ResponseEntity con ApiResponse que contiene la respuesta o un mensaje de error
     */
    @PostMapping(value = "/calificacion/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> establecerCalificacionDePelicula(@RequestBody Object ratingRequest,
                                                              @PathVariable("id") Integer id,
                                                              @RequestParam("id_invitado") String idInvitado) {

        ResponseEntity response = movieService.establecerCalificacionDePelicula(ratingRequest, id, idInvitado);

        List<Object> contenido = new ArrayList<>();
        contenido.add(response.getBody());

        if (response.getStatusCode().is2xxSuccessful()) {
            return new ResponseEntity<>(new RespuestaAPI("200", "Éxito", contenido), HttpStatus.OK);
        }

        return new ResponseEntity<>(new RespuestaAPI("403", "Acceso denegado", contenido), HttpStatus.FORBIDDEN);
    }

    /**
     * Obtiene las calificaciones del invitado paginadas.
     *
     * @param idInvitado ID de la sesión del invitado
     * @param page           Número de página para la paginación
     * @param idInvitado ID de la sesión del invitado
     * @param page Número de página para la paginación (opcional, valor predeterminado: 1)
     * @return ResponseEntity con ApiResponse que contiene la lista de calificaciones o un mensaje de error
     */

    @GetMapping(value = "/calificaciones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerCalificacionesDeInvitado(@RequestParam("id_invitado") String idInvitado,
                                                             @RequestParam(name = "page", defaultValue = "1", required = false) Integer page) {

        List<Object> listaCalificaciones = movieService.obtenerCalificacionesDeInvitado(idInvitado, page);

        if (listaCalificaciones.isEmpty()) {
            return new ResponseEntity<>(new RespuestaAPI("404", "No se encontraron calificaciones", listaCalificaciones), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new RespuestaAPI("200", "Éxito", listaCalificaciones), HttpStatus.OK);
    }

    /**
     * Elimina una calificación de una película.
     *
     * @param id             ID de la película
     * @param idInvitado ID de la sesión del invitado
     * @return ResponseEntity con ApiResponse que contiene la respuesta o un mensaje de error
     */
    @DeleteMapping(value = "/calificacion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarCalificacionDePelicula(@PathVariable("id") Integer id,
                                                            @RequestParam("id_invitado") String idInvitado) {

        ResponseEntity response = movieService.eliminarCalificacionDePelicula(id, idInvitado);

        List<Object> contenido = new ArrayList<>();
        contenido.add(response.getBody());

        if (!response.getStatusCode().is2xxSuccessful()) {
            return new ResponseEntity<>(new RespuestaAPI("403", "Acceso denegado", contenido), HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(new RespuestaAPI("200", "Éxito", contenido), HttpStatus.OK);
    }
}