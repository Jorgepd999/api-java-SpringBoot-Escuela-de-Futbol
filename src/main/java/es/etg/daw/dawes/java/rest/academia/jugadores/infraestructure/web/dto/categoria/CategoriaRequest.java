package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Datos necesarios para crear o actualizar una categoría")
public record CategoriaRequest(

        @Schema(
                description = "Nombre de la categoría",
                example = "Infantil",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "{categoria.valid.nombre.no_vacio}")
        String nombre
) {

    public CategoriaRequest(Categoria c) {
        this(c.getNombre());
    }
}

