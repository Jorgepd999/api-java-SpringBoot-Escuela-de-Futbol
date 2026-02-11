package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.jugador;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation.EmailJugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation.NombradoJugador;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Schema(description = "Datos necesarios para crear o actualizar un jugador")
public record JugadorRequest(

    // ===== Nombre =====
    @Schema(
        description = "Nombre del jugador (solo letras, obligatorio)",
        example = "Francisco",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "{jugador.valid.nombre.no_vacio}")
    @NombradoJugador(message = "{jugador.valid.nombre.formato}")
    
    String nombre,

    // ===== Apellido =====
    @Schema(
        description = "Apellido del jugador (solo letras, obligatorio)",
        example = "Ojeda",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "{jugador.valid.apellido.no_vacio}")
    @NombradoJugador(message = "{jugador.valid.apellido.formato}")
   

    String apellido,

    // ===== Edad =====
    @Schema(
        description = "Edad del jugador (mínimo 5 años)",
        example = "14",
        minimum = "5"
    )
    @Min(value = 5, message = "{jugador.valid.edad.min}")
    int edad,

    // ===== Pierna hábil =====
    @Schema(
        description = "Pierna dominante del jugador",
        example = "derecha",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "{jugador.valid.pierna.no_vacia}")
    String piernaHabil,

    // ===== Email =====
    @Schema(
        description = "Correo electrónico válido del jugador",
        example = "franojeda@gmail.com",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "{jugador.valid.email.no_vacio}")
    @Email(message = "{jugador.valid.email.formato}")
    @EmailJugador(message = "{jugador.valid.email.formato}")
    String email,

    // ===== Categoría =====
    @Schema(
        description = "ID de la categoría (entre 1 y 5)",
        example = "2",
        minimum = "1",
        maximum = "5"
    )
    @Min(value = 1, message = "{jugador.valid.categoria.min}")
    @Max(value = 5, message = "{jugador.valid.categoria.max}")
    int categoriaId
) {

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
