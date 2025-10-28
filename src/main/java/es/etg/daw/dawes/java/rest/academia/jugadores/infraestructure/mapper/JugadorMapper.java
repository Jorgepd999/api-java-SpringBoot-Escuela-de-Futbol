package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.JugadorRequest;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.JugadorResponse;

public class JugadorMapper {

    public static CreateJugadorCommand tCommand(JugadorRequest jugadorRequest){
        return new CreateJugadorCommand(jugadorRequest.nombre(), jugadorRequest.apellido());

    }

    public static JugadorResponse toResponse(Jugador jugador){
        return new JugadorResponse(jugador.getId(),
                                  jugador.getNombre(),
                                  jugador.getApellido());
    }

    public static EditJugadorCommand toCommand(int id, JugadorRequest jugadorRequest){
        return new EditJugadorCommand(id,jugadorRequest.nombre(), jugadorRequest.apellido());
    }
   
}
