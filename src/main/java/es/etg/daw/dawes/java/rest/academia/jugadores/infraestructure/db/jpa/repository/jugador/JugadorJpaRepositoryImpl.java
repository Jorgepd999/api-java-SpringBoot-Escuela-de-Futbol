package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.repository.jugador;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.JugadorRepository;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity.JugadorJpaEntity;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper.JugadorMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JugadorJpaRepositoryImpl implements JugadorRepository{

    private final JugadorEntityJpaRepository repository;

    @Override
    public Jugador save(Jugador t) {

        JugadorJpaEntity prod = JugadorMapper.toEntity(t);
        return JugadorMapper.toDomain(repository.save(prod));
    }

    @Override
    public List<Jugador> getAll() {
        return JugadorMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Jugador> getById(JugadorId id) {
        Optional<Jugador> Jugador = null;
        Optional<JugadorJpaEntity> pe = repository.findById(id.getValue());

        if(pe.isEmpty()){
            Jugador = Optional.empty();
        }else{
            Jugador = Optional.of(JugadorMapper.toDomain(pe.get()));
        }

        return Jugador;
    }

    @Override
    public void deleteById(JugadorId id) {
        repository.deleteById(id.getValue());
    }

     @Override
    public Optional<Jugador> getByName(String name) {
        JugadorJpaEntity prod = repository.findByNombre(name);
        if(prod!=null)
            return Optional.of(JugadorMapper.toDomain(prod));
        else
            return Optional.empty() ;
    }
    
}




