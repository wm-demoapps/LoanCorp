/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {
    //debugger
    Page.App.Variables.sv_Get_Loan_Details_by_Id.invoke();
    Page.App.Variables.sv_Get_kyc_image.invoke();
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



Page.getDlData = function(obj) {
    //debugger
    let detls = {
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[0]]: obj.dlNo,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[1]]: obj.w2Zip,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[2]]: obj.w2State,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[3]]: obj.w2Address
    };

    return detls;
};
Page.getw2Data = function(obj) {
    //debugger
    let detls = {

        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[0]]: obj.w2SsnNo,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[1]]: obj.w2EinNo,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[2]]: obj.w2Wages,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[3]]: obj.w2Zip,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[4]]: obj.w2State,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[5]]: obj.w2Address
    };
    return detls;
};

Page.licenseButtonClick = function($event, widget) {
    debugger
    Page.Widgets.container9_2.pageParams.details = Page.getDlData(Page.App.Variables.sv_Get_Loan_Details_by_Id.dataSet.document[0].docExtractData);
    // Page.Widgets.container9_2.pageParams.details = {
    //     "ESN": "1234",
    //     "ENIN": "09292",
    //     "Wages": "10000",
    //     "state": "sc",
    //     "zip SecurityNumber": 12345
    // }
    // //debugger
};

Page.w2FormButtomClick = function($event, widget) {
    debugger
    Page.Widgets.container9_2.pageParams.details = Page.getw2Data(Page.App.Variables.sv_Get_Loan_Details_by_Id.dataSet.document[1].docExtractData);
    // Page.Widgets.container9_2.pageParams.details = {
    //     "ESN": "1234",
    //     "ENIN": "09292",
    //     "Wages": "10000",
    //     "state": "sc"
    // }
};





Page.Approve_buttonClick = function($event, widget) {
    debugger
    Page.App.Variables.md_status.dataSet.dataValue = "Approved";
    Page.Variables.sv_Update_Loan_Application_Status.invoke({
        "inputFields": {
            "loanId": Page.Variables.sv_Get_Loan_Details_by_Id.dataSet.id,
            "status": "Approved"
        }
    }, function(data) {
        // Success Callback
        console.log("success", data);
    }, function(error) {
        // Error Callback
        console.log("error", error)
    });
};

Page.Reject_ButtonClick = function($event, widget) {
    Page.Variables.sv_Update_Loan_Application_Status.invoke({
        "inputFields": {
            "loanId": Page.Variables.sv_Get_Loan_Details_by_Id.dataSet.id,
            "status": "Reject"
        }
    }, function(data) {
        // Success Callback
        console.log("success", data);
    }, function(error) {
        // Error Callback
        console.log("error", error)
    });
    Page.Actions.goToPage_PendingLoans.navigate();
};
