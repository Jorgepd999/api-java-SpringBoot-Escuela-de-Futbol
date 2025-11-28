package es.etg.daw.dawes.java.rest.academia.jugadores.domain.error;

public class CategoriaNotFoundException extends EntityNotFoundException{

    public static final String ENTIDAD = "categoría";

    public CategoriaNotFoundException(){
        super(ENTIDAD);
    }

    public CategoriaNotFoundException(int id){
        super(ENTIDAD, id);
    }
}
