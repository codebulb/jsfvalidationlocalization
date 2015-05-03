var Focus = {
    /*
     * Sets the default keyboard focus automatically on either the first
     * invalid input component or, if no invalid component is present, on the
     * first input component found, beginning its search at the root node
     * with the clientId provided. If no root node is provided, it defaults to 
     * the HTML document BODY node.
     * 
     * This is a replacement to PrimeFaces focus component which is known to be buggy.
     * 
     * It is recommeded to place this inside
     * <o:onloadScript>Focus.setFocus();</o:onloadScript> to apply auto-focus on page load.
     * 
     * It works as well when invoked in the onsuccess callback of an ajaxified PrimeFaces
     * component.
     */
    setFocus : function(root) {
        // defer execution, so it works also as e.g. ajax button onsuccess event
        $(document).ready(function() {
            if (typeof root == "undefined") {
                root = "body";
            }
            else {
                root = "#" + root;
            }
            var elem = $(root).find("input[class][readonly!=readonly].ui-state-error").first();
            if (elem.length === 0) {
                elem = $(root).find("input[class][readonly!=readonly]").first();
            }
            if (elem.length === 0) {
                return;
            }
            elem.focus();
        });
    },
    
    /*
     * As setFocus, but without validation awareness.
     * 
     * For exclusive use with p:resetInput buttons as these conflict with setFocus:
     * when setFocus is executed, it is not aware of the fact that in the meantime, all validation
     * errors have been purged.
     */
    setFocusWithoutValidationAwareness : function(root) {
        // defer execution, so it works also as e.g. ajax button onsuccess event
        $(document).ready(function() {
            if (typeof root == "undefined") {
                root = "body";
            }
            else {
                root = "#" + root;
            }
            var elem = $(root).find("input[class][readonly!=readonly]").first();
            if (elem.length === 0) {
                return;
            }
            elem.focus();
        });
    }
};