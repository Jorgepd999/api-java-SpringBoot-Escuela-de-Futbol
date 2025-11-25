package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CreateJugadorUseCase {
    private final JugadorRepository jugadorRepository;

public Jugador create(CreateJugadorCommand comando){
    Jugador jugador= Jugador.builder()
                         .nombre(comando.nombre())
                         .apellido(comando.apellido())
                         .edad(comando.edad())
                         .piernaHabil(comando.piernaHabil())
                         .email(comando.email())
                         .build();
    jugadorRepository.save(jugador);
    return jugador;
}
    
}
