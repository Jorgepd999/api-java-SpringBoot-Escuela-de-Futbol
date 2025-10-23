package es.etg.daw.dawes.java.rest.instituto.alumnos.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.DeleteAlumnoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteAlumnoUseService {

    private final DeleteAlumnoUseCase deleteAlumnoUseCase;

    public void delete(int id){
        deleteAlumnoUseCase.delete(id);
    }
}
