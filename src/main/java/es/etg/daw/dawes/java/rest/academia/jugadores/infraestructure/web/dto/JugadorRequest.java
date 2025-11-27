package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation.EmailJugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation.NombradoJugador;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
public record JugadorRequest(
@NotBlank(message="{jugador.valid.nombre.no_vacio}")
@NombradoJugador (message="{jugador.valid.nombre.nombrado_validation}")
 String nombre, 
@NotBlank(message="{jugador.valid.apellido.no_vacio}")
@NombradoJugador (message="{jugador.valid.apellido.nombrado_validation}")
String apellido,
@Min(value = 5, message="{jugador.valid.edad.min}")
@Max (value = 19, message="{jugador.valid.edad.max}")
int edad,
String piernaHabil,
@EmailJugador(message="{jugador.valid.email.formato}")
@Email(message="{jugador.valid.email.formato}")
String email){
    
}
