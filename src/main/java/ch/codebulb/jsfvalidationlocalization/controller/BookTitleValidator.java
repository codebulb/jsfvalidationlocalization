package ch.codebulb.jsfvalidationlocalization.controller;

import ch.codebulb.jsfvalidationlocalization.service.BookService;
import ch.codebulb.jsfvalidationlocalization.util.Validation;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@FacesValidator
public class BookTitleValidator implements Validator {
    @Inject
    BookService service;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input = (String) value;
        
        if (service.isInBannedTitles(input)) {
            throw Validation.createValidatorException(component, "model.book.title.isInBannedTitles");
        }
    }
    
}
