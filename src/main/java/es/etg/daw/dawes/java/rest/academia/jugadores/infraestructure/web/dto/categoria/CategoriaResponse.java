package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria;

import java.time.LocalDateTime;

public record CategoriaResponse (int id, String nombre,LocalDateTime createdAt ) {

    
}
