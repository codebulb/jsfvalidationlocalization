package ch.codebulb.jsfvalidationlocalization.model.validator;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = BookReleaseYearAndEditionPresentValidator.class)
@Documented
public @interface IsBookReleaseYearAndEditionPresent {
    String message() default "model.book.releaseYearAndEditionPresent";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
