package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.error.JugadorNotFoundException;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteJugadorUseCase {
     private final JugadorRepository jugadorRepository;
    public void delete(int id){
    jugadorRepository.getById(id)
        .ifPresentOrElse( //Si el alumno existe (present), ejecuta la primera lambda.Si no existe (empty), ejecuta la segunda lambda.
            jugador -> jugadorRepository.deteteById(id),
            () -> { throw new JugadorNotFoundException(id); }
        );
}

}
