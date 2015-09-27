var Bugfixes = {
    /*
     * Retrieves the PrimeFaces widget for the component with the clientId provided.
     * This works for components with explicit widgetVar attribute as well as with components
     * without this implicit attribute.
     */
    // based on http://stackoverflow.com/a/22955176
    getWidgetVarById : function(id) {
        id = id.replace("_input", "");
        for (var propertyName in PrimeFaces.widgets) {
          if (PrimeFaces.widgets[propertyName].id === id) {
            return PrimeFaces.widgets[propertyName];
          }
        }
     },
    
    /*
     * Fixes a bug in PrimeFaces Extensions' inputNumber component:
     * Recognizing emptyValue to hide the symbol doesn't work if the component
     * is backed by a primitive int value as it is not rendered as "empty String" but as "0".
     * 
     * The bugfix resolves this problem by removing the value "0" onblur.
     */
    primeFacesExtensionsInputNumberZeroToEmpty : function() {
        $(document).ready(function() {
            $("span.bugfix-pe-inputNumber-zeroToEmpty > input:first").each(function() {
                var match = /[0-9]+/.exec(this.value);
                if (match !== null && match[0] === "0") {
                    this.value = "";
                }
            });
        });
        $("span.bugfix-pe-inputNumber-zeroToEmpty > input:first").each(function() {
            var onblur = this.onblur;
            this.onblur = function(){
                var match = /[0-9]+/.exec(this.value);
                if (match !== null && match[0] === "0") {
                    this.value = "";
                }
                // keep original function
                if (onblur !== null) {
                    return onblur();
                }
            };
        });
    },
    
    /*
     * Applies all bugfixes at ones.
     * 
     * It is recommeded to place this inside
     * <o:onloadScript>Bugfixes.apply();</o:onloadScript>
     */
    apply : function() {
        Bugfixes.primeFacesExtensionsInputNumberZeroToEmpty();
    }
};