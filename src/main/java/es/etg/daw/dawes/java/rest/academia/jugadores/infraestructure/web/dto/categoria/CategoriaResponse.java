package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos devueltos por la API cuando se consulta una categoría")
public record CategoriaResponse(

        @Schema(description = "ID único de la categoría", example = "1")
        int id,

        @Schema(description = "Nombre de la categoría", example = "Infantil")
        String nombre,

        @Schema(
                description = "Fecha y hora de creación del registro",
                example = "2024-05-20T14:30:00"
        )
        LocalDateTime createdAt
) {}
