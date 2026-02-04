package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation.EmailJugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation.NombradoJugador;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record JugadorRequest(

    // ===== Nombre =====
    @NotBlank(message = "{jugador.valid.nombre.no_vacio}")
    @NombradoJugador(message = "{jugador.valid.nombre.formato}")
    String nombre,

    // ===== Apellido =====
    @NotBlank(message = "{jugador.valid.apellido.no_vacio}")
    @NombradoJugador(message = "{jugador.valid.apellido.formato}")
    String apellido,

    // ===== Edad =====
    @Min(value = 5, message = "{jugador.valid.edad.min}")
    int edad,

    // ===== Pierna hábil =====
    @NotBlank(message = "{jugador.valid.pierna.no_vacia}")
    String piernaHabil,

    // ===== Email =====
    @NotBlank(message = "{jugador.valid.email.no_vacio}")
    @Email(message = "{jugador.valid.email.formato}")
    @EmailJugador(message = "{jugador.valid.email.formato}")
    String email,

    // ===== Categoría =====
    @Min(value = 1, message = "{jugador.valid.categoria.min}")
    @Max(value = 5, message = "{jugador.valid.categoria.max}")
    int categoriaId
) 
{

    public JugadorRequest(Jugador p) {
        this(
                p.getNombre(),
                p.getApellido(),
                p.getEdad(),
                p.getPiernaHabil(),
                p.getEmail(),
                p.getCategoria().getValue());
    }
}
