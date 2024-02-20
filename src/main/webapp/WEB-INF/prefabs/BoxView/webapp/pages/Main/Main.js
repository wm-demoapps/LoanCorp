var DialogService = App.getDependency("DialogService");
/*
 * This function will be invoked when any of this prefab's property is changed
 * @key: property name
 * @newVal: new value of the property
 * @oldVal: old value of the property
 */

var urla = "";
Prefab.diaWidth = 200;

function propertyChangeHandler(key, newVal, oldVal) {
    console.log(key);
    switch (key) {
        case "url":
            urla = newVal;
            break;
    }
}
/* register the property change handler */

Prefab.onPropertyChange = propertyChangeHandler;
Prefab.onReady = function() {
    console.log(Prefab);
    // this method will be triggered post initialization of the prefab.
};

Prefab.anchor2Click = function($event, widget) {
    console.log(Prefab.urla);
    // Prefab.Variables.GetURL.setInput("fileId", urla);
    Prefab.Widgets.boxViewSpinner.show = true;
    Prefab.Variables.GetURL.update({}, function(data) {
        Prefab.emdURL = data;
        // Prefab.Widgets.iframedialog1.open();
        DialogService.open('iframedialog1', Prefab, {
            'emdURL': data
        });

        Prefab.Widgets.boxViewSpinner.show = false;
    });

};
