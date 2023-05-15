package com.danielpineros.Service;

import com.danielpineros.Repository.InterfazRepositorioSesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio de sesión.
 */
@Service
public class ServicioSesion implements InterfazServicioSesion {

    @Autowired
    InterfazRepositorioSesion sessionRepository;

    /**
     * Obtiene la sesión de invitado.
     *
     * @return ResponseEntity con el resultado de la operación
     */
    public ResponseEntity obtenerSesionInvitado(){
        return sessionRepository.obtenerSesionInvitado();
    }
}
