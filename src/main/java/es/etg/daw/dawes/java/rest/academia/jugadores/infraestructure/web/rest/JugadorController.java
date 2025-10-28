package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.rest;

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

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.DeleteJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.EditJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper.JugadorMapper;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.JugadorRequest;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.JugadorResponse;
import jakarta.validation.Valid; 
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jugadores")
@RequiredArgsConstructor
public class JugadorController {
    private final CreateJugadorUseService createJugadorUseService;
    private final FindJugadorUseService findJugadorUseService;
    private final DeleteJugadorUseService deleteJugadorUseService;
    private final EditJugadorUseService editJugadorUseService;

    @PostMapping 
    public ResponseEntity<JugadorResponse> createJugador(@Valid @RequestBody JugadorRequest juagadorRequest){
        CreateJugadorCommand comando =JugadorMapper.tCommand(juagadorRequest);
        Jugador jugador= createJugadorUseService.createJugador(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(JugadorMapper.toResponse(jugador));
    }
    @GetMapping
    public List<JugadorResponse> allAlumnos(){
        return findJugadorUseService.findAll()
                .stream()
                .map(JugadorMapper::toResponse)
                .toList();   
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteJugador(@PathVariable int id) {
        deleteJugadorUseService.delete(id);
        return ResponseEntity.noContent().build(); 
    }

    @PutMapping("/{id}")
    public JugadorResponse editJugador(@PathVariable int id, @RequestBody JugadorRequest juagadorRequest){
        EditJugadorCommand comando = JugadorMapper.toCommand(id, juagadorRequest);
        Jugador jugador = editJugadorUseService.update(comando);
        return  JugadorMapper.toResponse(jugador); //Respuesta
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

