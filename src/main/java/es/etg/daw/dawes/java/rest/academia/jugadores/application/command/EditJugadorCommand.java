package es.etg.daw.dawes.java.rest.academia.jugadores.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditJugadorCommand {
    private int id;
    private String nombre;
    private String apellido;
}
