package es.etg.daw.dawes.java.rest.instituto.alumnos.domain.error;

public class AlumnoNotFoundException extends EntityNotFoundException {
     public static final String ENTIDAD = "alumno";

    public AlumnoNotFoundException(){
        super(ENTIDAD);
    }

    public AlumnoNotFoundException(int id){
        super(ENTIDAD, id);
    }
}
