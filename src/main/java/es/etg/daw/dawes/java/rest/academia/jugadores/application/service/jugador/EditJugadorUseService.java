package es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.jugador.EditJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EditJugadorUseService {
    private final EditJugadorUseCase editJugadorUseCase;
    public Jugador update(EditJugadorCommand command){

        return editJugadorUseCase.update(command);
    }
}
