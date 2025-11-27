package es.etg.daw.dawes.java.rest.academia.jugadores.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.DeleteJugadorUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteJugadorUseService {

    private final DeleteJugadorUseCase deleteJugadorUseCase;

    public void delete(JugadorId id){
        deleteJugadorUseCase.delete(id);
    }
}
