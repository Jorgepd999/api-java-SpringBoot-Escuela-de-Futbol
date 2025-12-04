package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.server.ResponseStatusException;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.DeleteJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.EditJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.FindJugadorUseService;
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

    // Recuperamos la versión desde el properties
    @Value("${api.version}")
    private String apiVersion;
    // MÉTODO DE VALIDACIÓN, comprueba la version de la API, si es distinta da error.
    private void checkApiVersion() {
        if (!"1.0".equals(apiVersion)) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Versión del API incorrecta: " + apiVersion
            );
        }
    }

    @PostMapping 
    public ResponseEntity<JugadorResponse> createJugador(
            @Valid @RequestBody JugadorRequest jugadorRequest) {

        checkApiVersion(); // Validación interna

        CreateJugadorCommand comando = JugadorMapper.toCommand(jugadorRequest);
        Jugador jugador = createJugadorUseService.createJugador(comando);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(JugadorMapper.toResponse(jugador));
    }

    @GetMapping
    public List<JugadorResponse> allJugadores() {
        checkApiVersion(); // Validación interna

        return findJugadorUseService.findAll()
                .stream()
                .map(JugadorMapper::toResponse)
                .toList();
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJugador(@PathVariable int id) {

        checkApiVersion(); // Validación interna
        
        deleteJugadorUseService.delete(new JugadorId(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public JugadorResponse editJugador(
            @PathVariable int id,
            @RequestBody JugadorRequest jugadorRequest) {

        checkApiVersion(); // Validación interna
        
        EditJugadorCommand comando = JugadorMapper.toCommand(id, jugadorRequest);
        Jugador jugador = editJugadorUseService.update(comando);

        return JugadorMapper.toResponse(jugador);
    }

    // Captura errores de validación
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

