package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase;

import org.springframework.stereotype.Service;


import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.JugadorId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteJugadorUseCase {
     private final JugadorRepository jugadorRepository;
      
    public void delete(JugadorId id){ //Lo cambiamos
        jugadorRepository.deleteById(id);
    }
}


