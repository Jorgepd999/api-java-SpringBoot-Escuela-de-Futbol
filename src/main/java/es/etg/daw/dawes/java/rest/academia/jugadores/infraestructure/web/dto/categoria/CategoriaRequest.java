package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(
        @NotBlank(message = "{categoria.valid.nombre.no_vacio}") String nombre) {

     public CategoriaRequest(Categoria c) {
        this(c.getNombre());
    }
}
