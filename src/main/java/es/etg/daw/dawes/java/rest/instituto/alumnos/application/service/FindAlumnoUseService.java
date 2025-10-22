package es.etg.daw.dawes.java.rest.instituto.alumnos.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAlumnoUseService {
    private final FindAlumnoUseCase findAlumnoUseCase;
    public List<Alumno> findAll(){
        return findAlumnoUseCase.findAll();
    }
    
}
