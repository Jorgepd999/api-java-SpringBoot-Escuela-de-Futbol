package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.repository.mock;

import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;

public class JugadorFactory {
    public static final Map<Integer, Jugador> getDemoData() {
        Map<Integer, Jugador> datos = new LinkedHashMap<>();
        datos.put(1, new Jugador(1, "Marce", "Perez"));
        datos.put(2, new Jugador(2, "Raquel", "Prieto"));
        datos.put(3, new Jugador(3, "Edo", "Perez"));
        datos.put(4, new Jugador(4, "Mario", "Del Rincon"));
        return datos;
    }

}
