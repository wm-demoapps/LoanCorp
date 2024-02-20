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

//var urla = "";
Prefab.onPropertyChange = function(key, newVal, oldVal) {

    // console.log(key);
    // switch (key) {
    //     case "url":
    //         urla = newVal;
    //         break;
    // }
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



// Prefab.anchorClick = function($event, widget) {
//     //  console.log(Prefab.urla);
//     // Prefab.Variables.GetURL.setInput("fileId", urla);
//     Prefab.Variables.GetField.update({}, function(data) {
//         Prefab.entityvalue = data;
//     });

// };

// Prefab.GetFieldonSuccess = function(variable, data) {
//     console.log(data)

// };

Prefab.getEntityValues = async function() {
    Prefab.Variables.GetEntityValues.invoke();
}

Prefab.GetEntityValuesonSuccess = function(variable, data) {
    Prefab.onSuccess({}, data);
};
