package es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Jugador {
    public Jugador() {
        //TODO Auto-generated constructor stub
    }

    private JugadorId id;
    private String nombre;
    private String apellido;
    private int edad;
    private String piernaHabil;
    private String email;

    //Agregamos la categoría
    private CategoriaId categoria;
}
