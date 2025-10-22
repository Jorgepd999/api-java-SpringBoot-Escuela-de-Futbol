package es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase;

import java.util.List;

import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.repository.AlumnoRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        List<Alumno> alumnos = alumnoRepository.getAll();

        if (alumnos.isEmpty()) {
            throw new AlumnoNotFoundException();
        }

        return alumnos;
    }
}
