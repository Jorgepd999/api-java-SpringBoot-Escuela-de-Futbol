package es.etg.daw.dawes.java.rest.academia.jugadores.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.CreateJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateJugadorUseService {
    private final CreateJugadorUseCase createJugadorUseCase;
    public Jugador createJugador(CreateJugadorCommand comando){
        Jugador alumno = createJugadorUseCase.create(comando);
        return alumno;
    }
}

