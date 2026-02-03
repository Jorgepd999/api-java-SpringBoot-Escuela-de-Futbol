package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.jugador;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
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
                         .categoria(comando.categoriaId())
                         .build();
    return  jugadorRepository.save(jugador);
}
    
}
