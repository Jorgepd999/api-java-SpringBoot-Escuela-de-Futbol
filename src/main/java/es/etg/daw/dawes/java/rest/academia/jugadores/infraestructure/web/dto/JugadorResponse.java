package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record JugadorResponse(
        @Schema(description = "ID único del jugador", example = "23") int id,
        @Schema(description = "Nombre  del jugador", example = "Francisco") String nombre,
        @Schema(description = "Apellido  del jugador", example = "Ojeda") String apellido,
        @Schema(description = "Edad del jugador", example = "14") int edad,
        @Schema(description = "Pierna habil jugador", example = "derecha")

        String piernaHabil,
        @Schema(description = "Email del jugador", example = "franojeda@gmail.com")

        String email,
        @Schema(description = "Categoria del jugador", example = "infantil")

        int categoria) {

}
