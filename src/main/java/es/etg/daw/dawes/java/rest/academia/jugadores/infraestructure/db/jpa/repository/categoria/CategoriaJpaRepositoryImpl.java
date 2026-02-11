package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.repository.categoria;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.CategoriaRepository;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity.CategoriaJpaEntity;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoriaJpaRepositoryImpl implements CategoriaRepository{

    private final CategoriaEntityJpaRepository repository;

    @Override
    public Categoria save(Categoria c) {

        CategoriaJpaEntity cat = CategoriaMapper.toEntity(c);
        return CategoriaMapper.toDomain(repository.save(cat));
    }

    @Override
    public List<Categoria> getAll() {
        return CategoriaMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Categoria> getById(CategoriaId id) {
        Optional<Categoria> categoria = null;
        Optional<CategoriaJpaEntity> ce = repository.findById(id.getValue());

        if (ce.isEmpty()) {
            categoria = Optional.empty();
        } else {
            categoria = Optional.of(CategoriaMapper.toDomain(ce.get()));
        }

        return categoria;
    }

    @Override
    public void deleteById(CategoriaId id) {
        repository.deleteById(id.getValue());
    }

    /*  @Override
    public Optional<Categoria> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }*/
}