package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailJugadorValidador implements ConstraintValidator<EmailJugador, String> {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false; // obligatorio
        }
        return value.matches(EMAIL_REGEX);
    }
}
