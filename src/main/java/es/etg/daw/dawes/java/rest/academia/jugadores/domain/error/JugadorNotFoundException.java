package es.etg.daw.dawes.java.rest.academia.jugadores.domain.error;

public class JugadorNotFoundException extends EntityNotFoundException {
     public static final String ENTIDAD = "jugador";

    public JugadorNotFoundException(){
        super(ENTIDAD);
    }

    public JugadorNotFoundException(int id){
        super(ENTIDAD, id);
    }
}
