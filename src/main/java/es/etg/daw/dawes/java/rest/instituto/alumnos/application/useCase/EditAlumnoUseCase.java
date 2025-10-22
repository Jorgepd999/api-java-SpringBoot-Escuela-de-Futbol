package es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditAlumnoUseCase {

    public Alumno update(EditAlumnoCommand comando){
         // Creamos un Alumno “falso” solo para pruebas
       Alumno alumno= Alumno.builder()
                         .nombre(comando.nombre())
                         .apellido(comando.apellido()).build();
    return alumno;
        
    }
}
