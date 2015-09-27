package ch.codebulb.jsfvalidationlocalization.controller;


import ch.codebulb.jsfvalidationlocalization.model.Book;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class BookController implements Serializable {
    private Book item = new Book();

    public Book getItem() {
        return item;
    }

    public void setItem(Book item) {
        this.item = item;
    }
    
    public boolean isReleaseYearAndEditionPresent(FacesContext context, List<UIInput> components, List<Object> values) {
        Book book = new Book();
        book.setReleaseYear((Date) values.get(0));
        try {
            book.setEdition(Integer.parseInt(values.get(1).toString()));
        }
        catch (NumberFormatException ex) {}
        return book.isReleaseYearAndEditionPresent();
    }
    
    public void save() {
        // FIXME Only needed with custom Bean Validation validators
//        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//        Set<ConstraintViolation<Book>> violations = validator.validate(item);
//        for (ConstraintViolation<Book> violation : violations) {
//            Messages.addGlobalError(violation.getMessage());
//        }
    }
    
    public void clear() {
        item = new Book();
    }
}
