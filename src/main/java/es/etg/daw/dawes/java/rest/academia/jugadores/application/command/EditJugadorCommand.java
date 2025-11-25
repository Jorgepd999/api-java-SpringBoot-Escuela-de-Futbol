package es.etg.daw.dawes.java.rest.academia.jugadores.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditJugadorCommand {
    private final int id;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String piernaHabil;
    private final int telefono;
    private final boolean activo;
}
