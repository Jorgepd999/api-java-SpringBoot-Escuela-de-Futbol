package es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository;
import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.academia.common.domain.repository.CRUDRepository;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;

public interface JugadorRepository extends CRUDRepository<Jugador, Integer>{
    
    public Optional<Jugador> getByName (String name);
    //public Optional<Jugador> getByCategoria(CategoriaId categoriaId); //lista jugadores por categoria
    List<Jugador> findByActivoTrue();       // jugadores activos
    List<Jugador> findByActivoFalse();      // jugadores inactivos (por si lo necesitas)
}
