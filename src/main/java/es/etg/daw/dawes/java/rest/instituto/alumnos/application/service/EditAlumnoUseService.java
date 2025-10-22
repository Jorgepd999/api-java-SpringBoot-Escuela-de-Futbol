package es.etg.daw.dawes.java.rest.instituto.alumnos.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.EditAlumnoUseCase;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EditAlumnoUseService {
    private final EditAlumnoUseCase editAlumnoUseCase;
    public Alumno update(EditAlumnoCommand command){

        return editAlumnoUseCase.update(command);
    }
}
