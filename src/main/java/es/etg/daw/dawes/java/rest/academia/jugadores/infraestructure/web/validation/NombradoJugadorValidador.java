package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoJugadorValidador
        implements ConstraintValidator<NombradoJugador, String> {

    private static final int MIN_LENGTH = 3;
    private static final String REGEX_SOLO_LETRAS = "^[A-Za-zÁÉÍÓÚáéíóúÑñ]+(\\s+[A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        // elimina espacios al inicio y al final
        String texto = value.trim();

        // no vacío ni solo espacios
        if (texto.isEmpty()) {
            return false;
        }

        // mínimo 3 caracteres
        if (texto.length() < MIN_LENGTH) {
            return false;
        }

        // solo letras (sin números ni símbolos)
        return texto.matches(REGEX_SOLO_LETRAS);
    }
}
