package com.danielpineros.Repository;

import org.springframework.http.ResponseEntity;

/**
 * Interfaz del repositorio de sesiones.
 */
public interface InterfazRepositorioSesion {

    /**
     * Obtiene una sesión de invitado.
     *
     * @return ResponseEntity con la sesión de invitado
     */
    ResponseEntity obtenerSesionInvitado();
}
