package com.danielpineros.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Modelo para la respuesta de la API.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RespuestaAPI {

    private String status_code; // Código de estado de la respuesta
    private String description; // Descripción de la respuesta
    private List<Object> content; // Contenido de la respuesta

}
