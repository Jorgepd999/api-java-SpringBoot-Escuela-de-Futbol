package es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.jugador.DeleteJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteJugadorUseService {

    private final DeleteJugadorUseCase deleteJugadorUseCase;

    public void delete(JugadorId id){
        deleteJugadorUseCase.delete(id);
    }
}
