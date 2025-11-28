package es.etg.daw.dawes.java.rest.academia.jugadores.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Categoria {
    private CategoriaId id;
    private String nombre;
    private LocalDateTime createdAt;
}