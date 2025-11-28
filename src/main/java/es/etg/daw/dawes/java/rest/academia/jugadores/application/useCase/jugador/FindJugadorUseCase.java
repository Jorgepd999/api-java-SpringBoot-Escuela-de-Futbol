package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.jugador;

import java.util.List;



import es.etg.daw.dawes.java.rest.academia.jugadores.domain.error.JugadorNotFoundException;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindJugadorUseCase {

    private final JugadorRepository jugadorRepository;

    public List<Jugador> findAll() {
        List<Jugador> jugadores = jugadorRepository.getAll();

        if (jugadores.isEmpty()) {
            throw new JugadorNotFoundException();
        }

        return jugadores;
    }
}

