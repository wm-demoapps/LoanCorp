/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Partial.onReady = function() {
    /*
     * variables can be accessed through 'Partial.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Partial.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Partial.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Partial.Widgets.username.datavalue'
     */
};

Partial.existingCustomerButtonClick = function($event, widget) {

    Partial.App.Variables.mdCustomerType.dataSet.customerType = "existing";
    Partial.App.Variables.mdCustomerType.dataSet.loginFrom = "loanApplication";
    window.location.replace(window.location.href.replace("Main", "Login"));
    // window.location.replace(window.location.href)
    //debugger
    Partial.App.Widgets.pagedialog1.close();
};

Partial.newCustonerButtonClick = function($event, widget) {

    Partial.App.Variables.mdCustomerType.dataSet.customerType = "new";
};
