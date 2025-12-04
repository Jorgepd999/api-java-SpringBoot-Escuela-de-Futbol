package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.repository.mock;

import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;

public class JugadorFactory {
    public static final Map<JugadorId, Jugador> getDemoData() {
        Map<JugadorId, Jugador> datos = new LinkedHashMap<>();
        datos.put(new JugadorId(1), new Jugador(new JugadorId(1), "Marce", "Perez",30,"Derecha","pruebaemail@gmail.com"));
        datos.put(new JugadorId(2), new Jugador(new JugadorId(2), "Raquel", "Prieto",29,"Derecha","pruebaemail@gmail.com"));
        datos.put(new JugadorId(3), new Jugador(new JugadorId(3), "Edo", "Perez",5,"izquierda","pruebaemail@gmail.com"));
        datos.put(new JugadorId(4), new Jugador(new JugadorId(4), "Mario", "Del Rincon",26,"derecha","pruebaemail@gmail.com"));
        return datos;
    }

}
