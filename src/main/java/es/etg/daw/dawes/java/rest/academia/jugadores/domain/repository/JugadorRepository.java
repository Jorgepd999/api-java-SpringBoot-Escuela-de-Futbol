package es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.academia.common.domain.repository.CRUDRepository;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.JugadorId;

public interface JugadorRepository extends CRUDRepository<Jugador, JugadorId>{
    
    public Optional<Jugador> getByName (String name);
    //public Optional<Jugador> getByCategoria(CategoriaId categoriaId); //lista jugadores por categoria
   
}
