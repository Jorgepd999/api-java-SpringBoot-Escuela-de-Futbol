package es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.repository.AlumnoRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CreateAlumnoUseCase {
    private AlumnoRepository alumnoRepository;

public Alumno create(CreateAlumnoCommand comando){
    Alumno alumno= Alumno.builder()
                         .nombre(comando.nombre())
                         .apellido(comando.apellido()).build();
    alumnoRepository.save(alumno);
    return alumno;
}
    
}
