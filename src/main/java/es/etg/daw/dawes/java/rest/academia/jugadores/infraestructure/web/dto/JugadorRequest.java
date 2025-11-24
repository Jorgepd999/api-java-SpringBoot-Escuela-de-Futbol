package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation.NombradoJugador;
import jakarta.validation.constraints.NotBlank;
public record JugadorRequest(
@NotBlank(message="{jugador.valid.nombre.no_vacio}")
@NombradoJugador (message="{jugador.valid.nombre.nombrado_validation}")
 String nombre, 
@NotBlank(message="{jugador.valid.apellido.no_vacio}")
@NombradoJugador (message="{jugador.valid.nombre.nombrado_validation}")
String apellido,
int edad,
String piernaHabil,
int telefono,
boolean activo){
    
}
