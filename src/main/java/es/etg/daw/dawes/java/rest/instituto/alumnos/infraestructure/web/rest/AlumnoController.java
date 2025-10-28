package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.CreateAlumnoUseService;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.DeleteAlumnoUseService;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.EditAlumnoUseService;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.FindAlumnoUseService;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.dto.AlumnoResponse;
import jakarta.validation.Valid; 
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    private final CreateAlumnoUseService createAlumnoUseService;
    private final FindAlumnoUseService findAlumnoUseService;
    private final DeleteAlumnoUseService deleteAlumnoUseService;
    private final EditAlumnoUseService editAlumnoUseService;

    @PostMapping 
    public ResponseEntity<AlumnoResponse> createAlumno(@Valid @RequestBody AlumnoRequest alumnoRequest){
        CreateAlumnoCommand comando =AlumnoMapper.tCommand(alumnoRequest);
        Alumno alumno= createAlumnoUseService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(alumno));
    }
    @GetMapping
    public List<AlumnoResponse> allAlumnos(){
        return findAlumnoUseService.findAll()
                .stream()
                .map(AlumnoMapper::toResponse)
                .toList();   
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteAlumno(@PathVariable int id) {
        deleteAlumnoUseService.delete(id);
        return ResponseEntity.noContent().build(); 
    }

    @PutMapping("/{id}")
    public AlumnoResponse editAlumno(@PathVariable int id, @RequestBody AlumnoRequest alumnoRequest){
        EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
        Alumno alumno = editAlumnoUseService.update(comando);
        return  AlumnoMapper.toResponse(alumno); //Respuesta
    }

      // Método que captura los errores y devuelve un mapa con el campo que no cumple la validación y un mensaje de error.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

