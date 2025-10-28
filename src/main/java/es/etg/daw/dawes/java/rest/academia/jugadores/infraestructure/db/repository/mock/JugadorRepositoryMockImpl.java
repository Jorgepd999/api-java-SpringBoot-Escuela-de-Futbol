package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.repository.JugadorRepository;

@Repository
public class JugadorRepositoryMockImpl implements JugadorRepository {
    private final Map<Integer,Jugador> jugadores= JugadorFactory.getDemoData();

    @Override
    public Jugador save(Jugador t){
        jugadores.put(t.getId(),t); 
        return t;
    }
     @Override
    public List<Jugador> getAll() {
        return new ArrayList<>(jugadores.values());
    }

    @Override
    public Optional<Jugador> getById(Integer id) {
        //Un optional puede tener una valor o no. Si no existe el producto devuelve Optional.empty
        return Optional.ofNullable(jugadores.get(id));
    }

    @Override
    public void deteteById(Integer id) {
        jugadores.remove(id);
    }
    @Override
    public Optional<Jugador> getByName(String name) {
        // TODO Sin implementar
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
}
