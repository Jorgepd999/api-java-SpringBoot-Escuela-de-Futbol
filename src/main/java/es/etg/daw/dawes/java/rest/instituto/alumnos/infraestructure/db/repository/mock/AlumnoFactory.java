package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.db.repository.mock;

import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model.Alumno;

public class AlumnoFactory {
    public static final Map<Integer, Alumno> getDemoData() {
        Map<Integer, Alumno> datos = new LinkedHashMap<>();
        datos.put(1, new Alumno(1, "Marce", "Perez"));
        datos.put(1, new Alumno(1, "Raquel", "Prieto"));
        datos.put(1, new Alumno(1, "Edo", "Perez"));
        datos.put(1, new Alumno(1, "Mario", "Del Rincon"));
        return datos;
    }

}
