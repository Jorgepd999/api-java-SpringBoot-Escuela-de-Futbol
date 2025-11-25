package es.etg.daw.dawes.java.rest.academia.jugadores.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String piernaHabil;
    private String email;
}
