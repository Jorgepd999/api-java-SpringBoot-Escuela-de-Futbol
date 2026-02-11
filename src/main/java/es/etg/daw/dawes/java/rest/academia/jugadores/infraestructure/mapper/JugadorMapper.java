package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity.CategoriaJpaEntity;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity.JugadorJpaEntity;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.JugadorRequest;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.JugadorResponse;

public class JugadorMapper {

    public static CreateJugadorCommand toCommand(JugadorRequest jugadorRequest) {
        return new CreateJugadorCommand(jugadorRequest.nombre(), jugadorRequest.apellido(), jugadorRequest.edad(),
                jugadorRequest.piernaHabil(), jugadorRequest.email(), new CategoriaId(jugadorRequest.categoriaId()));

    }

    public static JugadorResponse toResponse(Jugador jugador) {
        return new JugadorResponse(jugador.getId().getValue(),
                jugador.getNombre(),
                jugador.getApellido(),
                jugador.getEdad(),
                jugador.getPiernaHabil(),
                jugador.getEmail(),
                jugador.getCategoria().getValue());
    }

    public static EditJugadorCommand toCommand(int id, JugadorRequest jugadorRequest) {
        return new EditJugadorCommand(new JugadorId(id), jugadorRequest.nombre(), jugadorRequest.apellido(),
                jugadorRequest.edad(), jugadorRequest.piernaHabil(), jugadorRequest.email());
    }

    public static JugadorJpaEntity toEntity(Jugador p) {

        // Defino la categoría
        CategoriaJpaEntity cat = new CategoriaJpaEntity();
        cat.setId(p.getCategoria().getValue());
        JugadorId id = p.getId();
        return JugadorJpaEntity.builder().id(id != null ? id.getValue() : null)
                .nombre(p.getNombre())
                .apellido(p.getApellido())
                .edad(p.getEdad())
                .piernaHabil(p.getPiernaHabil())
                .email((p.getEmail()))
                .categoria(cat)
                .build();

    }

    public static Jugador toDomain(JugadorJpaEntity p) {
        return Jugador.builder().id(new JugadorId(p.getId()))
                .nombre(p.getNombre())
                .apellido(p.getApellido())
                .edad(p.getEdad())
                .piernaHabil(p.getPiernaHabil())
                .email((p.getEmail()))
                .categoria(new CategoriaId(p.getCategoria().getId()))
                .build();

    }

    public static List<Jugador> toDomain(List<JugadorJpaEntity> lista) {
        List<Jugador> lp = new ArrayList<>();
        for (JugadorJpaEntity pe : lista) {
            lp.add(toDomain(pe));
        }
        return lp;
    }

}
