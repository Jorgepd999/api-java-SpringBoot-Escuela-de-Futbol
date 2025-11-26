package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.error.JugadorNotFoundException;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
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

