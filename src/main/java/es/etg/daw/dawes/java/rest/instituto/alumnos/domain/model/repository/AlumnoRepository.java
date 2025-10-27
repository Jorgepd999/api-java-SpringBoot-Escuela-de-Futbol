package es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;

public interface AlumnoRepository  extends CRUDRepository<Alumno,Integer>{
    public Optional <Alumno> getByName(String name);
}


