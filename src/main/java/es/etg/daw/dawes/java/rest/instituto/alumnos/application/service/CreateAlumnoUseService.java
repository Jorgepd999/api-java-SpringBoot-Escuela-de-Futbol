package es.etg.daw.dawes.java.rest.instituto.alumnos.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateAlumnoUseService {
    private final CreateAlumnoUseCase createAlumnoUseCase;
    public Alumno createAlumno(CreateAlumnoCommand comando){
        Alumno alumno = createAlumnoUseCase.create(comando);
        return alumno;
    }
}

