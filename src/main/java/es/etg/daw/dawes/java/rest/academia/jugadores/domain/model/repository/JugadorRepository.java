package es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;

public interface JugadorRepository  extends CRUDRepository<Jugador,Integer>{
    public Optional <Jugador> getByName(String name);
}


