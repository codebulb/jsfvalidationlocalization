package ch.codebulb.jsfvalidationlocalization.controller;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

// based on http://stackoverflow.com/a/5391493
@ManagedBean
@SessionScoped
public class LocaleManager implements Serializable {
    private Locale locale;
    
    @PostConstruct
    protected void init(){
        final UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        if (viewRoot != null) {
            locale = viewRoot.getLocale();
        }
        else {
            locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        }
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

}