package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.error.JugadorNotFoundException;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditJugadorUseCase {

    private final JugadorRepository jugadorRepository;

    public Jugador update(EditJugadorCommand comando) {
        return jugadorRepository.getById(comando.id())   // Buscar jugador por ID
            .map(jugador -> {                           // Si existe, actualizar atributos
                jugador.setNombre(comando.nombre());
                jugador.setApellido(comando.apellido());
                jugador.setEdad(comando.edad());
                jugador.setPiernaHabil(comando.piernaHabil());
                jugador.setEmail(comando.email());
                return jugadorRepository.save(jugador);  // Guardar cambios
            })
            .orElseThrow(() -> new JugadorNotFoundException(comando.id().getValue()));  // Si no existe, lanzar excepción
    }
}
