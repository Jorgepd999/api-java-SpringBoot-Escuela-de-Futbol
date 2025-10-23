package es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.repository.AlumnoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditAlumnoUseCase {

    private final AlumnoRepository alumnoRepository;

    public Alumno update(EditAlumnoCommand comando) {
        return alumnoRepository.getById(comando.id())   // Buscar alumno por ID
            .map(alumno -> {                           // Si existe, actualizar atributos
                alumno.setNombre(comando.nombre());
                alumno.setApellido(comando.apellido());
                return alumnoRepository.save(alumno);  // Guardar cambios
            })
            .orElseThrow(() -> new AlumnoNotFoundException(comando.id()));  // Si no existe, lanzar excepción
    }
}
