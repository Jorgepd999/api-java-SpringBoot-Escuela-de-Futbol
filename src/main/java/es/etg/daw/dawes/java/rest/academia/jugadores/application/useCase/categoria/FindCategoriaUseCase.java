package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria;

import java.util.List;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.error.CategoriaNotFoundException;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCategoriaUseCase {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> categorias = categoriaRepository.getAll();
        if (categorias.isEmpty())
            throw new CategoriaNotFoundException();
        return categorias;
    }
}
