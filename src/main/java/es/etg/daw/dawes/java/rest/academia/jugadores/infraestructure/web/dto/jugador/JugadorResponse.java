package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.jugador;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos que devuelve la API cuando se consulta un jugador")
public record JugadorResponse(

                @Schema(description = "ID único del jugador", example = "23") int id,

                @Schema(description = "Nombre del jugador", example = "Francisco") String nombre,

                @Schema(description = "Apellido del jugador", example = "Ojeda") String apellido,

                @Schema(description = "Edad actual del jugador", example = "14") int edad,

                @Schema(description = "Pierna hábil del jugador (derecha o izquierda)", example = "derecha") String piernaHabil,

                @Schema(description = "Correo electrónico del jugador", example = "franojeda@gmail.com") String email,

                @Schema(description = "ID de la categoría a la que pertenece el jugador", example = "2") int categoria) {
}
