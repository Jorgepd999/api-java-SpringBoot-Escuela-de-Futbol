package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.dto.AlumnoResponse;

public class AlumnoMapper {

    public static CreateAlumnoCommand tCommand(AlumnoRequest alumnoRequest){
        return new CreateAlumnoCommand(alumnoRequest.nombre(), alumnoRequest.apellido());

    }

    public static AlumnoResponse toResponse(Alumno alumno){
        return new AlumnoResponse(alumno.getId(),
                                  alumno.getNombre(),
                                  alumno.getApellido());
    }

    public static EditAlumnoCommand toCommand(int id, AlumnoRequest alumnoRequest){
        return new EditAlumnoCommand(id,alumnoRequest.nombre(), alumnoRequest.apellido());
    }
   
}
