package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailJugadorValidador.class)
@Documented
public @interface EmailJugador {

    String message() default "{jugador.valid.email.formato}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
