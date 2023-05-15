package com.danielpineros.Model;

import lombok.*;

import java.util.ArrayList;

/**
 * Modelo para representar una película.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pelicula {

    Boolean adult; // Indica si la película es para adultos
    String backdrop_path; // Ruta de la imagen de fondo
    Object belongs_to_collection; // Objeto que representa la colección a la que pertenece la película
    Integer budget; // Presupuesto de la película
    ArrayList<Object> genres; // Lista de géneros de la película
    String homepage; // Página web de la película
    Integer id; // ID de la película
    String imdb_id; // ID de IMDb de la película
    String original_language; // Idioma original de la película
    String original_title; // Título original de la película
    String overview; // Sinopsis de la película
    Number popularity; // Popularidad de la película
    String poster_path; // Ruta del póster de la película
    ArrayList<Object> production_companies; // Lista de compañías de producción de la película
    ArrayList<Object> production_countries; // Lista de países de producción de la película
    String release_date; // Fecha de lanzamiento de la película
    Integer revenue; // Ingresos de la película
    Integer runtime; // Duración de la película en minutos
    ArrayList<Object> spoken_languages; // Lista de idiomas hablados en la película
    String status; // Estado de la película
    String tagline; // Lema de la película
    String title; // Título de la película
    Boolean video; // Indica si la película tiene un video asociado
    Number vote_average; // Promedio de votos de la película
    Integer vote_count; // Cantidad de votos recibidos por la película

}
