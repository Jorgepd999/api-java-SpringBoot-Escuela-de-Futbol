package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.repository.JugadorRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CreateJugadorUseCase {
    private final JugadorRepository jugadorRepository;

public Jugador create(CreateJugadorCommand comando){
    Jugador jugador= Jugador.builder()
                         .nombre(comando.nombre())
                         .apellido(comando.apellido()).build();
    jugadorRepository.save(jugador);
    return jugador;
}
    
}
