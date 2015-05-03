package ch.codebulb.jsfvalidationlocalization.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookService {
    private static final String[] BANNED_BOOK_TITLES = new String[]{
            "Moby Dick", // for animal cruelty
            "Robinson Crusoe", // for pro-colonization attitude
            "Peter Pan" // for kidnapping
    };
    
    public boolean isInBannedTitles(String title) {
        for (int i = 0; i < BANNED_BOOK_TITLES.length; i++) {
            if (BANNED_BOOK_TITLES[i].equals(title)) {
                return true;
            }
        }
        return false;
    }
}
