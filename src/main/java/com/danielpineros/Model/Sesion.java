package com.danielpineros.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Modelo para representar una sesión de usuario.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sesion {

    private Boolean exito; // Indica si la sesión fue creada exitosamente
    private String id_invitado; // ID de la sesión de invitado
    private String fecha_expiracion; // Fecha y hora de expiración de la sesión

}
