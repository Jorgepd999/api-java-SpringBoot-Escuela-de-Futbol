package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.repository.AlumnoRepository;

@Repository
public class AlumnoRepositoryMockImpl implements AlumnoRepository {
    private final Map<Integer,Alumno> alumnos= AlumnoFactory.getDemoData();

    @Override
    public Alumno save(Alumno t){
        alumnos.put(t.getId(),t); 
        return t;
    }
     @Override
    public List<Alumno> getAll() {
        return new ArrayList<>(alumnos.values());
    }

    @Override
    public Optional<Alumno> getById(Integer id) {
        //Un optional puede tener una valor o no. Si no existe el producto devuelve Optional.empty
        return Optional.ofNullable(alumnos.get(id));
    }

    @Override
    public void deteteById(Integer id) {
        alumnos.remove(id);
    }
    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO Sin implementar
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
}
