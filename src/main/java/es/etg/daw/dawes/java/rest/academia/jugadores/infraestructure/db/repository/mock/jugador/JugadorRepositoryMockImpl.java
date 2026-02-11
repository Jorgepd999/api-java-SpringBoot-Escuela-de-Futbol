package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.repository.mock.jugador;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;



@Profile("test")
@Repository
public class JugadorRepositoryMockImpl implements JugadorRepository {

    private final Map<JugadorId,Jugador> jugadores;

    public JugadorRepositoryMockImpl() {
        // Inicialización segura
        this.jugadores = JugadorFactory.getDemoData();
    }

    private int obtenerSiguienteId() {
        JugadorId ultimo = new JugadorId(0);
        for (Jugador j : jugadores.values()) {
            ultimo = j.getId();
        }
        return ultimo.getValue() + 1;
    }

    @Override
    public Jugador save(Jugador j) {
        if (j.getId() == null) {
            j.setId(new JugadorId(obtenerSiguienteId()));
        }
        jugadores.put(j.getId(), j); 
        return j;
    }

    @Override
    public List<Jugador> getAll() {
        return new ArrayList<>(jugadores.values());
    }

    @Override
    public Optional<Jugador> getById(JugadorId id) {
        return Optional.ofNullable(jugadores.get(id));
    }

    @Override
    public void deleteById(JugadorId id) {
        jugadores.remove(id);
    }

    @Override
    public Optional<Jugador> getByName(String name) {
        return jugadores.values()
                        .stream()
                        .filter(j -> j.getNombre().equalsIgnoreCase(name))
                        .findFirst();
    }
}

