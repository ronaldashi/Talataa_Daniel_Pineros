package com.danielpineros.Service;

import org.springframework.http.ResponseEntity;

/**
 * Interfaz del servicio de sesiones.
 */
public interface InterfazServicioSesion {

    /**
     * Obtiene la sesión de invitado.
     *
     * @return ResponseEntity con la sesión de invitado
     */
    ResponseEntity obtenerSesionInvitado();

}
