package es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.jugador.FindJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindJugadorUseService {

    private final FindJugadorUseCase findJugadorUseCase;

    public List<Jugador> findAll() {
        return findJugadorUseCase.findAll();
    }

    // Nuevo método para buscar un jugador por ID
    public Optional<Jugador> findById(Integer id) {
        return findJugadorUseCase.findById(new JugadorId(id));
    }
}
