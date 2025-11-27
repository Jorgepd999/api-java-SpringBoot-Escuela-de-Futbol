package es.etg.daw.dawes.java.rest.academia.jugadores.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.EditJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EditJugadorUseService {
    private final EditJugadorUseCase editJugadorUseCase;
    public Jugador update(EditJugadorCommand command){

        return editJugadorUseCase.update(command);
    }
}
