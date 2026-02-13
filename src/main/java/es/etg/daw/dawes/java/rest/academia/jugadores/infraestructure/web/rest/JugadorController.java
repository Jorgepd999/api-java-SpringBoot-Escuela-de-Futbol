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
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.DeleteJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.EditJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper.JugadorMapper;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.jugador.JugadorRequest;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.jugador.JugadorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jugadores")
@RequiredArgsConstructor
@Tag(name = "Jugadores", description = "Operaciones relacionadas con la gestión de jugadores")
public class JugadorController {

    private final CreateJugadorUseService createJugadorUseService;
    private final FindJugadorUseService findJugadorUseService;
    private final DeleteJugadorUseService deleteJugadorUseService;
    private final EditJugadorUseService editJugadorUseService;

    // Recuperamos la versión desde el properties
    @Value("${api.version}")
    private String apiVersion;

    // MÉTODO DE VALIDACIÓN, comprueba la version de la API, si es distinta da
    // error.
    private void checkApiVersion() {
        if (!"1.0".equals(apiVersion)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Versión del API incorrecta: " + apiVersion);
        }
    }

    @Operation(summary = "Crear jugador", description = "Recibe los datos de un jugador y lo almacena en la base de datos")
    @ApiResponse(responseCode = "201", description = "Jugador creado correctamente")
    @ApiResponse(responseCode = "400", description = "Error de validación en los datos enviados")
    @PostMapping
    public ResponseEntity<JugadorResponse> createJugador(
            @Valid @RequestBody JugadorRequest jugadorRequest) {

        checkApiVersion(); // Validación interna

        CreateJugadorCommand comando = JugadorMapper.toCommand(jugadorRequest);
        Jugador jugador = createJugadorUseService.createJugador(comando);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(JugadorMapper.toResponse(jugador));
    }

    @Operation(summary = "Obtener todos los jugadores", description = "Devuelve el listado completo de jugadores registrados")
    @ApiResponse(responseCode = "200", description = "Listado generado correctamente")

    @GetMapping
    public List<JugadorResponse> allJugadores() {
        checkApiVersion(); // Validación interna

        return findJugadorUseService.findAll()
                .stream()
                .map(JugadorMapper::toResponse)
                .toList();
    }

    @Operation(summary = "Obtener jugador por ID", description = "Busca un jugador concreto en la base de datos por su identificador")
    @ApiResponse(responseCode = "200", description = "Jugador encontrado")
    @ApiResponse(responseCode = "404", description = "Jugador no encontrado")
    @GetMapping("/{id}")
    public JugadorResponse findJugadorById(@PathVariable int id) {

        checkApiVersion(); // Validación interna

        Jugador jugador = findJugadorUseService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Jugador no encontrado con id: " + id));

        return JugadorMapper.toResponse(jugador);
    }

    @Operation(summary = "Eliminar jugador", description = "Elimina un jugador de la base de datos por su ID")
    @ApiResponse(responseCode = "204", description = "Jugador eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Jugador no encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJugador(@PathVariable int id) {

        checkApiVersion(); // Validación interna

        deleteJugadorUseService.delete(new JugadorId(id));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Actualizar jugador", description = "Modifica los datos de un jugador existente")
    @ApiResponse(responseCode = "200", description = "Jugador actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Jugador no encontrado")
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
