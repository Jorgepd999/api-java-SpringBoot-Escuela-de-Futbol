package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.dto;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.validation.NombradoAlumno;
import jakarta.validation.constraints.NotBlank;
public record AlumnoRequest(
@NotBlank(message="{alumno.valid.nombre.no_vacio}")
@NombradoAlumno (message="{alumno.valid.nombre.nombrado_validation}")
 String nombre, 
@NotBlank(message="{alumno.valid.apellido.no_vacio}")
@NombradoAlumno (message="{alumno.valid.nombre.nombrado_validation}")
String apellido){
    
}
