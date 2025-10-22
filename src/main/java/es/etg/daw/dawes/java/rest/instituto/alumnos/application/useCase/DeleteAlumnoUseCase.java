package es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteAlumnoUseCase {
     private final AlumnoRepository alumnoRepository;
    public void delete(int id){
    alumnoRepository.getById(id)
        .ifPresentOrElse( //Si el alumno existe (present), ejecuta la primera lambda.Si no existe (empty), ejecuta la segunda lambda.
            alumno -> alumnoRepository.deteteById(id),
            () -> { throw new AlumnoNotFoundException(id); }
        );
}

}
