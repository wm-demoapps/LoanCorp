/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/*
 * This function will be invoked when any of this prefab's property is changed
 * @key: property name
 * @newVal: new value of the property
 * @oldVal: old value of the property
 */
Prefab.onPropertyChange = function(key, newVal, oldVal) {
    /*
    switch (key) {
        case "prop1":
            // do something with newVal for property 'prop1'
            break;
        case "prop2":
            // do something with newVal for property 'prop2'
            break;
    }
    */
};

Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
};
Prefab.text1Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Prefab.Widgets.text2.focus();
};
Prefab.text2Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Prefab.Widgets.text3.focus();
};
Prefab.text3Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Prefab.Widgets.text4.focus();
};
Prefab.text4Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Prefab.Widgets.text5.focus();
};
Prefab.text5Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Prefab.Widgets.text6.focus();
};
