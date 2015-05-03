package ch.codebulb.jsfvalidationlocalization.model.validator;

import ch.codebulb.jsfvalidationlocalization.model.Book;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookReleaseYearAndEditionPresentValidator implements ConstraintValidator<IsBookReleaseYearAndEditionPresent, Book> {
    @Override
    public void initialize(IsBookReleaseYearAndEditionPresent constraintAnnotation) {}

    @Override
    public boolean isValid(Book value, ConstraintValidatorContext context) {
        return value.isReleaseYearAndEditionPresent();
    }
    
}
