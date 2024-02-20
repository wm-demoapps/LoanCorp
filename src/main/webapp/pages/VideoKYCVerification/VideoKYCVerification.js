/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    /*
     * variables can be accessed through 'Page.Variables' property here
     * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
     * Page.Variables.loggedInUser.getData()
     *
     * widgets can be accessed through 'Page.Widgets' property here
     * e.g. to get value of text widget named 'username' use following script
     * 'Page.Widgets.username.datavalue'
     */
};



Page.submit_buttonClick = function($event, widget) {
    Page
    // debugger
    localStorage.removeItem('customerId');
    Page.App.Variables.md_createLoanApplication.dataSet.kyc.lastUpdate = "";
    Page.App.Variables.md_createLoanApplication.dataSet.kyc.startDate = "";
    Page.App.Variables.md_createLoanApplication.dataSet.kyc.status = "uploaded";
    Page.App.Variables.md_createLoanApplication.dataSet.kycStringImage = Page.Widgets.FacialRecognition1.url.replace('data:image/png;base64,', '');
    Page.App.Variables.sv_createLoanApplication.invoke({
        "inputFields": {
            "CreateLoanApplication": Page.App.Variables.md_createLoanApplication.dataSet

        }
    }, function(data) {
        // Success Callback
        console.log("success", data);
        Page.Widgets.SuccesDialog.open();
    }, function(error) {
        // Error Callback
        Page.Actions.ErrorMessage.invoke();

        console.log("error", error);
    });
    // Page.Actions.goToPage_Main.navigate();
};

Page.closeButtonClick = function($event, widget) {
    localStorage.removeItem('customerId');
    Page.Actions.goToPage_Main.navigate();
};
