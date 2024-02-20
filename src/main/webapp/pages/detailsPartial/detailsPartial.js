/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Partial.onReady = function() {

    //debugger
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
Partial.getData = function(dataType, num) {
    if (dataType == "h") {
        return Object.keys(Partial.pageParams.details)[num - 1];
    } else {
        return Object.values(Partial.pageParams.details)[num - 1];
    }

};

Partial.button1Click = function($event, widget) {
    //debugger
    // Partial.App.Widgets.wizard1.currentStep = Partial.App.Widgets.wizard1.steps._results[0];
    if (Partial.pageParams.heading == "personal Details") {

    }
    switch (Partial.pageParams.heading) {
        case "personal Details":
            {
                Partial.App.Widgets.wizard1.prev();
                Partial.App.Widgets.wizard1.prev();
                Partial.App.Widgets.wizard1.prev();
                break;
            }
        case "Documents Uploaded":
            {
                Partial.App.Widgets.wizard1.prev();
                Partial.App.Widgets.wizard1.prev();
                break;
            }
        case "Loan Details":
            {
                Partial.App.Widgets.wizard1.prev();
                break;
            }
        default:
            {

            }

    }

};

Partial.DriverLicenseOrPassportClick = function($event, widget) {
    // Partial.Variables.mdTestData.dataSet.ef = Partial.App.Variables.md_createLoanApplication.dataSet.document[0].docExtractData
    Partial.pageParams.details = Partial.getDlExtractedData(Partial.App.Variables.md_createLoanApplication.dataSet.document[0].docExtractData);
};
Partial.w2FormClick = function($event, widget) {
    //debugger
    // Partial.Variables.mdTestData.dataSet.ef = Partial.App.Variables.md_createLoanApplication.dataSet.document[1].docExtractData
    Partial.pageParams.details = Partial.getW2ExtractedData(Partial.App.Variables.md_createLoanApplication.dataSet.document[1].docExtractData);
};

Partial.getDlExtractedData = function(obj) {
    let detls = {
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabels[0]]: obj.dlNo,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabels[1]]: Partial.App.Variables.md_createLoanApplication.dataSet.document[1].docExtractData.w2Zip,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabels[2]]: Partial.App.Variables.md_createLoanApplication.dataSet.document[1].docExtractData.w2State,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabels[3]]: Partial.App.Variables.md_createLoanApplication.dataSet.document[1].docExtractData.w2Address
    };

    return detls;

};
Partial.getW2ExtractedData = function(obj) {
    let detls = {
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[0]]: obj.w2SsnNo,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[1]]: obj.w2EinNo,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[2]]: obj.w2Wages,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[3]]: obj.w2Zip,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[4]]: obj.w2State,
        [Partial.App.Variables.md_Review_Labels.dataSet.extractedLabelsW2[5]]: obj.w2Address
    };
    return detls;

};
