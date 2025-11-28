package es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent=true)
public class CreateJugadorCommand {

    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String piernaHabil;
    private final String email;
    
}
