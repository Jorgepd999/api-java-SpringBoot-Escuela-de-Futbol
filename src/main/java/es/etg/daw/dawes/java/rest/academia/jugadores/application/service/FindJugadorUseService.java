package es.etg.daw.dawes.java.rest.academia.jugadores.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.FindJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindJugadorUseService {
    private final FindJugadorUseCase findJugadorUseCase;
    public List<Jugador> findAll(){
        return findJugadorUseCase.findAll();
    }
    
}
