package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.web.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoAlumnoValidador implements ConstraintValidator<NombradoAlumno, String>{

    public final static String STR_BLANCO = " ";
    public final static String STR_SALTO = "\n";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        /* Vamos a validar el campo producto aplicando las siguientes normas:
         *  No es nulo, vacío, ni tiene blancos
         */ 
        return !(value == null || value.length()==0 || value.contains(STR_BLANCO) || value.contains(STR_SALTO));
    }
    
}