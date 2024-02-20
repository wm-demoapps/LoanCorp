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
let isOfficerChecked = false;
let userData;
Partial.login_buttonClick = function($event, widget) {
    // debugger
    // Partial.App.Variables.sv_Validate_User.invoke({
    //     "inputFields": {
    //         "id": Partial.Widgets.form2.dataoutput.j_username,
    //         "pswd": Partial.Widgets.form2.dataoutput.j_password
    //     }
    // }, function(data) {
    //     // Success Callback
    //     console.log("success", data);
    //     userData = data.content[0];
    //     localStorage.setItem("userId", userData.customerId);
    //     localStorage.setItem("userRole", userData.role);
    //     Partial.App.Variables.md_Login_User.dataSet.dataValue = userData.customerId;
    //     Partial.App.Variables.mdUserLoggedIn.dataSet.dataValue = true;
    //     // Partial.Widgets.signout_button.setWidgetProperty('show', true);
    //     // Partial.Widgets.signin_button.setWidgetProperty('show', false);
    //     Partial.Widgets.login_dialog.close();

    //     if (userData.role == "officer") {
    //         // if (isOfficerChecked) {
    //         // Partial.Widgets.validate_user_dialog.open();
    //         Partial.Widgets.QrScanDialog.open();

    //     } else {
    //         //check wether the user is loging from signup flow or from loan application flow based on condition naviagting to it's respective page
    //         Partial.App.Variables.mdCustomerType.dataSet.customerType = "existing";
    //         Partial.App.Variables.mdCustomerType.dataSet.loginFrom == "signUp" ? Partial.Actions.goToPage_CustomerPage.navigate() : Partial.Actions.goToPage_StartLoanPage.navigate();


    //     }
    // }, function(error) {
    //     // Error Callback
    //     console.log("error", error);
    // });




};

Partial.validate_otp_buttonClick = function($event, widget) {

    Partial.Actions.goToPage_PendingLoans.navigate();
};

Partial.officer_chechboxChange = function($event, widget, newVal, oldVal) {
    isOfficerChecked = newVal;
};

// setting flag for customer logging from sign up flow
Partial.signUpClick = function($event, widget) {
    Partial.App.Variables.mdCustomerType.dataSet.loginFrom = "signUp";
};
Partial.sv_Validate_UseronSuccess = function(variable, data) {

    // debugger
};

Partial.signout_buttonClick = function($event, widget) {
    Partial.App.Variables.mdUserLoggedIn.dataSet.dataValue = false;
    localStorage.setItem("userId", "");
    localStorage.setItem("userRole", "");
    Partial.Actions.goToPage_Main.navigate();

};

Partial.anchor9_1Click = function($event, widget) {
    // debugger
    if (Partial.App.Variables.loggedInUser.dataSet.isAuthenticated) {
        if (Partial.App.Variables.loggedInUser.dataSet.roles[0] == "officer") {
            Partial.Actions.goToPage_PendingLoans.navigate();
        } else {

            Partial.Actions.goToPage_CustomerPage.navigate();
            Partial.App.Variables.sv_GetCustomerId.invoke({
                "inputFields": {
                    "id": Partial.App.Variables.loggedInUser.dataSet.id

                }
            }, function(data) {
                // Success Callback

            }, function(error) {

            });
        }
    } else {
        window.location.replace(window.location.href.replace("Main", "Login"));
    }
};

Partial.signin_buttonClick = function($event, widget) {

    window.location.replace(window.location.href.replace("Main", "Login"));
};
