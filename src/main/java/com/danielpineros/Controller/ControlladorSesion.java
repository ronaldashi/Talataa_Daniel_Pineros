package com.danielpineros.Controller;

import com.danielpineros.Model.RespuestaAPI;
import com.danielpineros.Model.Sesion;
import com.danielpineros.Service.InterfazServicioSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para las operaciones relacionadas con las sesiones de usuarios.
 */
@RestController
@RequestMapping("/authentication")
public class ControlladorSesion {

    @Autowired
    private InterfazServicioSesion sessionService;

    /**
     * Obtiene una nueva sesión de invitado.
     *
     * @return ResponseEntity con ApiResponse que contiene la sesión de invitado o un mensaje de error.
     */
    @GetMapping(value = "/invitado/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerSesionInvitado() {

        ResponseEntity<Sesion> respuestaSesion = sessionService.obtenerSesionInvitado();

        List<Object> contenido = new ArrayList<>();
        contenido.add(respuestaSesion.getBody());

        if (respuestaSesion.getStatusCode().is2xxSuccessful()) {
            return new ResponseEntity<>(new RespuestaAPI("200", "OK", contenido), HttpStatus.OK);
        }

        return new ResponseEntity<>(new RespuestaAPI("403", "Acceso denegado", contenido), HttpStatus.FORBIDDEN);
    }
}
