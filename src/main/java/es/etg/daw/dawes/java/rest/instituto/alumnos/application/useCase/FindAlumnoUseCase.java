package es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase;

import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindAlumnoUseCase {

    public List<Alumno> findAll() {
        List<Alumno> lista = new ArrayList<>();

        lista.add(new Alumno(1, "Raquel", "Prieto"));
        lista.add(new Alumno(1, "Mario", "Del Rincon"));
        lista.add(new Alumno(1, "Marce", "Perez"));

        return lista;
    }

}