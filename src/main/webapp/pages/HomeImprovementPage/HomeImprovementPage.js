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
var count = 0;
let calculatedLoanAmount;
Page.wizard1Done = function(widget, steps) {
    Page.Variables.mdCustomerType.dataSet.loginFrom = "direct";
    Page.Widgets.md_createLoanApplicationForm1.reset();

};



Page.wizardstep1Next = function(widget, currentStep, stepIndex) {
    Page.App.Variables.md_createLoanApplication.dataSet.customerDetails = Page.Widgets.md_createLoanApplicationForm1.dataoutput;
};


Page.FileServiceUploadFileonSuccess = async function(variable, data) {
    Page.App.Variables.md_createLoanApplication.dataSet.document[0].fileName = data[0].fileName;
    Page.App.Variables.md_createLoanApplication.dataSet.document[0].filePath = data[0].path;
    Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.url = data[0].inlinePath;
};
Page.FileServiceUploadFile1onSuccess = async function(variable, data) {
    debugger
    let extractedData = JSON.parse(Page.Widgets.EntityExtract_V22.entityvalues.value);
    Page.App.Variables.md_createLoanApplication.dataSet.document[0].docExtractData = {

        [Page.Variables.md_labels.dataSet[0]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[0]],
        [Page.Variables.md_labels.dataSet[1]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[1]],
        [Page.Variables.md_labels.dataSet[2]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[2]],
        [Page.Variables.md_labels.dataSet[3]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[3]],
        [Page.Variables.md_labels.dataSet[6]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[4]],
        [Page.Variables.md_labels.dataSet[5]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[5]],
        [Page.Variables.md_labels.dataSet[7]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[6]],
        [Page.Variables.md_labels.dataSet[8]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[7]],
        [Page.Variables.md_labels.dataSet[9]]: extractedData[Page.Variables.md_Extracted_Field_Params_Dr_License.dataSet.params[0]]
    };
    Page.App.Variables.mdTestData.dataSet.ef = Page.App.Variables.md_createLoanApplication.dataSet.document[0].docExtractData;
    Page.App.Variables.md_createLoanApplication.dataSet.document[1].fileName = data[0].fileName;
    Page.App.Variables.md_createLoanApplication.dataSet.document[1].filePath = data[0].path;
    Page.Variables.md_Extracted_Field_Params_W2_Form.dataSet.url = data[0].inlinePath;


};

Page.wizardstep3Next = function(widget, currentStep, stepIndex) {

    let extractedData = JSON.parse(Page.Widgets.EntityExtract_V23.entityvalues.value);

    Page.App.Variables.md_createLoanApplication.dataSet.document[1].docExtractData = {
        [Page.Variables.md_labels.dataSet[0]]: extractedData[Page.Variables.md_Extracted_Field_Params_W2_Form.dataSet.params[1]],
        [Page.Variables.md_labels.dataSet[1]]: extractedData[Page.Variables.md_Extracted_Field_Params_W2_Form.dataSet.params[2]],
        [Page.Variables.md_labels.dataSet[2]]: extractedData[Page.Variables.md_Extracted_Field_Params_W2_Form.dataSet.params[4]],
        [Page.Variables.md_labels.dataSet[2]]: extractedData[Page.Variables.md_Extracted_Field_Params_W2_Form.dataSet.params[3]].split(",")[2],
        [Page.Variables.md_labels.dataSet[4]]: extractedData[Page.Variables.md_Extracted_Field_Params_W2_Form.dataSet.params[3]].split(",")[1],
        [Page.Variables.md_labels.dataSet[5]]: extractedData[Page.Variables.md_Extracted_Field_Params_W2_Form.dataSet.params[0]]

    };
    console.log(Page.App.Variables.md_createLoanApplication.dataSet.document[1].docExtractData);
    Page.App.Variables.md_createLoanApplication.dataSet.customerDetails = Page.Widgets.md_createLoanApplicationForm1.dataoutput;
    Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.amount = Page.Widgets.amountSlider.dataval;
    Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.tenure = Page.Widgets.tenureSlider.dataval;
    Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.interestRate = Page.Variables.md_Interest_Rate.dataSet.dataValue;
    Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.interestAmt = Page.Variables.mdCalculatedLoanAmount.dataSet.InterestAmt;
    Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.emiFreq = Page.Variables.mdCalculatedLoanAmount.dataSet.Emi;

    Page.App.Variables.md_createLoanApplication.dataSet.creationTime = getCurrentDateTime();
};

function getCurrentDateTime() {
    const now = new Date();
    const formattedDateTime = now.toISOString().slice(0, 19).replace('T', ' ');
    return formattedDateTime;
}


//calculate loan amount based on loan amount field value  change
Page.text1Change = function($event, widget, newVal) {
    // debugger
    newVal.indexOf("$") != -1 ? Page.Widgets.amountSlider.dataval = widget.datavalue.split("$")[1] : Page.Widgets.amountSlider.dataval = widget.datavalue;

    if ((Page.Widgets.amountSlider.dataval != 0) && (Page.Widgets.tenureSlider.dataval != 0)) {
        calculatedLoanAmount = Page.Widgets.EmiCalc1.calculatLaonAmount(Page.Widgets.amountSlider.dataval, Page.Widgets.tenureSlider.dataval, Page.Variables.md_Interest_Rate.dataSet.dataValue);

        Page.Variables.mdCalculatedLoanAmount.dataSet = calculatedLoanAmount.EMI_Details.Monthly;
    }

};
//calculate loan Value based on tenure  field value  change
Page.text2Change = function($event, widget, newVal, oldVal) {
    //debugger
    newVal.indexOf("Y") != -1 ? Page.Widgets.tenureSlider.dataval = widget.datavalue.split("Y")[1] : Page.Widgets.tenureSlider.dataval = widget.datavalue;
    if ((Page.Widgets.amountSlider.dataval != 0) && (Page.Widgets.tenureSlider.dataval != 0)) {
        calculatedLoanAmount = Page.Widgets.EmiCalc1.calculatLaonAmount(Page.Widgets.amountSlider.dataval, Page.Widgets.tenureSlider.dataval, Page.Variables.md_Interest_Rate.dataSet.dataValue);
        Page.Variables.mdCalculatedLoanAmount.dataSet = calculatedLoanAmount.EMI_Details.Monthly;
    }

};
//calculate loan Value based on amount slider  value  change
Page.amountSliderChange = function($event, widget, newVal, oldVal) {


    if ((Page.Widgets.amountSlider.dataval != 0) && (Page.Widgets.tenureSlider.dataval != 0)) {
        calculatedLoanAmount = Page.Widgets.EmiCalc1.calculatLaonAmount(Page.Widgets.amountSlider.dataval, Page.Widgets.tenureSlider.dataval, Page.Variables.md_Interest_Rate.dataSet.dataValue);
        Page.Variables.mdCalculatedLoanAmount.dataSet = calculatedLoanAmount.EMI_Details.Monthly;
    }

};

//calculate loan Value based on tenure slider  value  change
Page.tenureSliderChange = function($event, widget, newVal, oldVal) {
    debugger
    if ((Page.Widgets.amountSlider.dataval != 0) && (Page.Widgets.tenureSlider.dataval != 0)) {
        calculatedLoanAmount = Page.Widgets.EmiCalc1.calculatLaonAmount(Page.Widgets.amountSlider.dataval, Page.Widgets.tenureSlider.dataval, Page.Variables.md_Interest_Rate.dataSet.dataValue);
        Page.Variables.mdCalculatedLoanAmount.dataSet = calculatedLoanAmount.EMI_Details.Monthly;
    }
};

//swith loan details based on monthly/fortnight/weekly
Page.switch1Change = function($event, widget, newVal, oldVal) {
    Page.Variables.mdCalculatedLoanAmount.dataSet = calculatedLoanAmount.EMI_Details[newVal];
};
//setting min and max date to restrict user without selecting invaliding DOb
Page.getDobDate = function(type) {
    let yrs = 0;
    type == "min" ? yrs = 60 : yrs = 18;
    let today = new Date();
    let dobDate = new Date(today.getFullYear() - yrs, today.getMonth(), today.getDate());
    return dobDate;
};



Page.wizard1Cancel = function(widget, steps) {
    //debugger
    Page.App.Variables.md_createLoanApplication.dataSet.customerDetails = Page.Widgets.md_createLoanApplicationForm1.dataoutput;
    Page.App.Variables.md_createLoanApplication.dataSet.creationTime = getCurrentDateTime();
    Page.App.Variables.md_createLoanApplication.dataSet.status = "Draft";
    console.log(Page.App.Variables.md_createLoanApplication.dataSet.customerDetails);
    Page.Variables.mdCustomerType.dataSet.loginFrom = "saveDraft";
    if (Page.Variables.mdCustomerType.dataSet.customerType == "new") {
        Page.Widgets.userValidationDialog.open();
    } else {
        Page.App.Variables.sv_createLoanApplication.invoke();
        Page.Actions.notificationAction2.invoke();
    }



};

Page.getLoanData = function() {
    let detls = {
        [Page.App.Variables.md_Review_Labels.dataSet.loanLabels[0]]: `$${(Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.amount.toLocaleString("en-US"))}`,
        [Page.App.Variables.md_Review_Labels.dataSet.loanLabels[1]]: `${Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.tenure} Years`,
        [Page.App.Variables.md_Review_Labels.dataSet.loanLabels[2]]: `${Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.interestRate} %`,
        [Page.App.Variables.md_Review_Labels.dataSet.loanLabels[3]]: `$${(Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.interestAmt.toLocaleString("en-US"))}`,
        [Page.App.Variables.md_Review_Labels.dataSet.loanLabels[4]]: `$${(Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.emiFreq.toLocaleString("en-US"))}`,
        [Page.App.Variables.md_Review_Labels.dataSet.loanLabels[5]]: `$${((Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.amount + Page.App.Variables.md_createLoanApplication.dataSet.loanDetails.interestAmt).toLocaleString("en-US"))}`
    };
    return detls;

};
Page.getExtractedData = function(obj) {

    let detls = {
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[0]]: obj.dlNo,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[1]]: Page.Variables.md_createLoanApplication.dataSet.document[1].docExtractData.w2Zip,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[2]]: Page.Variables.md_createLoanApplication.dataSet.document[1].docExtractData.w2State,
        [Page.App.Variables.md_Review_Labels.dataSet.extractedLabels[3]]: Page.Variables.md_createLoanApplication.dataSet.document[1].docExtractData.w2Address
    };
    return detls;

};
Page.getCustomerData = function(obj) {
    let detls = {
        [Page.App.Variables.md_Review_Labels.dataSet.customerLabels[0]]: obj.fname,
        [Page.App.Variables.md_Review_Labels.dataSet.customerLabels[1]]: obj.lname,
        [Page.App.Variables.md_Review_Labels.dataSet.customerLabels[2]]: obj.dob,
        [Page.App.Variables.md_Review_Labels.dataSet.customerLabels[3]]: obj.email,
        [Page.App.Variables.md_Review_Labels.dataSet.customerLabels[4]]: obj.ssn,
        [Page.App.Variables.md_Review_Labels.dataSet.customerLabels[5]]: obj.mobileno,
        [Page.App.Variables.md_Review_Labels.dataSet.customerLabels[6]]: obj.address
    };
    return detls;
};
Page.validateOtpClick = function($event, widget) {
    if (count <= 0) {
        Page.Widgets.label7.show = false;
        Page.Widgets.label8.show = true;
        Page.Widgets.OtpModule1.Widgets.text1.datavalue = "";
        Page.Widgets.OtpModule1.Widgets.text2.datavalue = "";
        Page.Widgets.OtpModule1.Widgets.text3.datavalue = "";
        Page.Widgets.OtpModule1.Widgets.text4.datavalue = "";
        Page.Widgets.OtpModule1.Widgets.text5.datavalue = "";
        Page.Widgets.OtpModule1.Widgets.text6.datavalue = "";
        count++;
    } else {

        if (Page.App.Variables.mdCustomerType.dataSet.loginFrom == "saveDraft") {
            Page.Widgets.label6.show = false;

            Page.Widgets.userValidationDialog.close();
            Page.Widgets.seuccesDialog1.open();
            //reset monile number label to show and email label to hide
            Page.Widgets.label7.show = true;
            Page.Widgets.label8.show = false;

        } else {
            Page.Actions.goToPage_VideoKYCVerification.navigate();
            //reset monile number label to show and email label to hide
            Page.Widgets.label7.show = true;
            Page.Widgets.label8.show = false;
        }

    }

};
