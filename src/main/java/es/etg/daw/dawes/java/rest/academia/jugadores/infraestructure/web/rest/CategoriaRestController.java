package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.CreateCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.DeleteCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.EditCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper.CategoriaMapper;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria.CategoriaRequest;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria.CategoriaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
@Tag(name = "Categorias", description = "Operaciones relacionadas con la gestión de las categorías")
public class CategoriaRestController {

    private final CreateCategoriaService createCategoriaService;
    private final FindCategoriaService findCategoriaService;
    private final DeleteCategoriaUseCase deleteCategoriaService;
    private final EditCategoriaUseCase editCategoriaService;

    // =========================
    // CREAR CATEGORIA
    // =========================
    @Operation(summary = "Crear categoría", description = "Crea una nueva categoría en el sistema")
    @ApiResponse(responseCode = "201", description = "Categoría creada correctamente")
    @ApiResponse(responseCode = "400", description = "Error de validación en los datos enviados")
    @PostMapping
    public ResponseEntity<CategoriaResponse> createCategoria(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos necesarios para crear una categoría", required = true) @Valid @RequestBody CategoriaRequest categoriaRequest) {

        CreateCategoriaCommand comando = CategoriaMapper.toCommand(categoriaRequest);
        Categoria categoria = createCategoriaService.createCategoria(comando);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CategoriaMapper.toResponse(categoria));
    }

    // =========================
    // LISTAR CATEGORIAS
    // =========================
    @Operation(summary = "Obtener todas las categorías", description = "Devuelve el listado completo de categorías registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de categorías generado correctamente"),
            @ApiResponse(responseCode = "404", description = "No existen categorías registradas")
    })
    @GetMapping
    public List<CategoriaResponse> allCategorias() {

        return findCategoriaService.findAll()
                .stream()
                .map(CategoriaMapper::toResponse)
                .toList();
    }

    // =========================
    // ELIMINAR CATEGORIA
    // =========================
    @Operation(summary = "Eliminar categoría", description = "Elimina una categoría del sistema según su ID")
    @ApiResponse(responseCode = "204", description = "Categoría eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "Categoría no encontrada")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(
            @io.swagger.v3.oas.annotations.Parameter(description = "ID de la categoría a eliminar", example = "1") @PathVariable int id) {

        deleteCategoriaService.delete(new CategoriaId(id));
        return ResponseEntity.noContent().build();
    }

    // =========================
    // EDITAR CATEGORIA
    // =========================
    @Operation(summary = "Actualizar categoría", description = "Modifica los datos de una categoría existente")
    @ApiResponse(responseCode = "200", description = "Categoría actualizada correctamente")
    @ApiResponse(responseCode = "404", description = "Categoría no encontrada")
    @PutMapping("/{id}")
    public CategoriaResponse editCategoria(
            @io.swagger.v3.oas.annotations.Parameter(description = "ID de la categoría a actualizar", example = "1") @PathVariable int id,
            @Valid @RequestBody CategoriaRequest categoriaRequest) {

        EditCategoriaCommand comando = CategoriaMapper.toCommand(id, categoriaRequest);
        Categoria categoria = editCategoriaService.update(comando);

        return CategoriaMapper.toResponse(categoria);
    }
}