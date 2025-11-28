package es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent= true)
public class CreateCategoriaCommand {
    private final String nombre;

}
