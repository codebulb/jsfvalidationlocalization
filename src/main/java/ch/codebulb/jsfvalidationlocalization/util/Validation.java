package ch.codebulb.jsfvalidationlocalization.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

/**
 * A utility class with common validation-related helper functionality.
 */
public class Validation {
    private Validation() {}
    
    private static final String MESSAGES_BUNDLE_BASE_NAME = "ValidationMessages";
    
    /**
     * Creates a {@link ValidatorException} based on a message with the message key and 
     * referring to the component provided.
     * 
     * @param component the component a reference to which should be included in the message
     * @param messageKey the message String as in I18N key, will be resolved within the ValidationMessages message-bundle
     * @return the newly created {@link ValidatorException}
     */
    public static ValidatorException createValidatorException(UIComponent component, String messageKey) {
        return new ValidatorException(Messages.createError(getMessage(component, messageKey)));
    }
    
    private static String getMessage(UIComponent component, String messageKey) {
        String message = getMessage(messageKey);
        return MessageFormat.format(getMessage("javax.faces.validator.BeanValidator.MESSAGE"), 
                message, component.getAttributes().get("label"));
    }
    
    /**
     * Gets the message with the key provided and referring to the label of the component provided.
     * The message will be resolved within the ValidationMessages message-bundle.<p/>
     * 
     * Suited for calling from a facelets page, using OmniFaces 
     * {@code <o:importFunctions type="ch.codebulb.jsfvalidationlocalization.util.Validation" var="val"/>} component.
     * 
     * @param component the component.
     * @param messageKey the messages key.
     * @return the localized message
     */
    public static String labeledMsg(UIComponent component, String messageKey) {
        return getMessage(messageKey, component.getAttributes().get("label"));
    }
    
    /**
     * Gets the message with the key provided. The message will be resolved within the ValidationMessages message-bundle.<p/>
     * 
     * Suited for calling from a facelets page, using OmniFaces 
     * {@code <o:importFunctions type="ch.codebulb.jsfvalidationlocalization.util.Validation" var="val"/>} component.
     * 
     * @param messageKey the messages key.
     * @return the localized message
     */
    public static String msg(String messageKey) {
        return getMessage(messageKey);
    }

    private static String getMessage(String messageKey, Object... params) {
         ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_BASE_NAME, Faces.getLocale());
         return MessageFormat.format(bundle.getString(messageKey), params);
    }
}
