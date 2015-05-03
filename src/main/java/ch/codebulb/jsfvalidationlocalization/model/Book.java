package ch.codebulb.jsfvalidationlocalization.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@IsBookReleaseYearAndEditionPresent
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 100, message = "{javax.validation.constraints.Size.String.message}")
    private String title;
    @NotNull
    @Size(min = 1, max = 100, message = "{javax.validation.constraints.Size.String.message}")
    @Pattern(regexp = "[A-Za-z\\. ]+", message = "{model.book.author}")
    private String author;
    
    @Min(1)
    @Max(999999)
    @NotNull
    private int pages;
    
    @Past
    @Temporal(DATE)
    private Date releaseYear;
    @Min(0)
    @Max(99)
    private int edition;
    
    @AssertTrue(message = "{model.book.releaseYearAndEditionPresent}")
    public boolean isReleaseYearAndEditionPresent() {
        return (getReleaseYear() == null && getEdition() == 0) ||
                (getReleaseYear() != null && getEdition() != 0);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.codebulb.validationlocalization.model.Book[ id=" + id + " ]";
    }
    
}
