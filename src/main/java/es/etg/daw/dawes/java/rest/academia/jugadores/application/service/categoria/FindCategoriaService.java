package es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.FindCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindCategoriaService {
     private final FindCategoriaUseCase findCategoriaUseCase;


     public List<Categoria> findAll() {
        return findCategoriaUseCase.findAll();
     }
}
