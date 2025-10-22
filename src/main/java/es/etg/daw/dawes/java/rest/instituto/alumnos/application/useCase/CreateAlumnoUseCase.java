package es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;

public class CreateAlumnoUseCase {

public Alumno create(CreateAlumnoCommand comando){
    Alumno alumno= Alumno.builder()
                         .nombre(comando.nombre())
                         .apellido(comando.apellido()).build();
    return alumno;
}
    
}
