package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.CreateAlumnoUseService;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.dto.AlumnoResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    private final CreateAlumnoUseService createAlumnoUseService;

    @PostMapping 
    public ResponseEntity<AlumnoResponse> createAlumno(@RequestBody AlumnoRequest alumnoRequest){
        CreateAlumnoCommand comando =AlumnoMapper.tCommand(alumnoRequest);
        Alumno alumno= createAlumnoUseService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(alumno));
    }

}

