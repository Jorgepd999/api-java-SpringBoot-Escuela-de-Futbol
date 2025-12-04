package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;

@Repository
public class JugadorRepositoryMockImpl implements JugadorRepository {
    private final Map<JugadorId,Jugador> jugadores= JugadorFactory.getDemoData();

     private int obtenerSiguienteId(){
        JugadorId ultimo = new JugadorId(0);
        if(!jugadores.isEmpty()){
            Collection<Jugador> lista = jugadores.values();
            
            for (Jugador j : lista) {
                ultimo = j.getId();
            }

        }
        return ultimo.getValue()+1;
    }

  @Override
public Jugador save(Jugador j) {
    // Si el ID de Jugador está vacío (null), se asigna un nuevo ID generado
    if (j.getId() == null) {
        j.setId(new JugadorId(obtenerSiguienteId())); // Aquí asumo que tienes un método similar para obtener el siguiente ID
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
        //Un optional puede tener una valor o no. Si no existe el producto devuelve Optional.empty
        return Optional.ofNullable(jugadores.get(id));
    }

    @Override
    public void deleteById(JugadorId id) {
        jugadores.remove(id);
    }
    @Override
    public Optional<Jugador> getByName(String name) {
        // TODO Sin implementar
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
}
