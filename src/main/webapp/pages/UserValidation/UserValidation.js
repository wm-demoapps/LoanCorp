/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/* perform any action on widgets/variables within this block */
Page.onReady = function() {

    Page.Widgets.otpDialog.open();

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

Page.validateOtpClick = function($event, widget) {
    //debugger
    if (count <= 0) {
        Page.Widgets.label7.caption = Page.maskEmail("Pavan@wm.com");
        // Page.Widgets.otpField.datavalue = "";
        Page.Widgets.text1.datavalue = "";
        Page.Widgets.text2.datavalue = "";
        Page.Widgets.text3.datavalue = "";
        Page.Widgets.text4.datavalue = "";
        Page.Widgets.text5.datavalue = "";
        Page.Widgets.text6.datavalue = "";
        count++;
    } else {
        if (Page.App.Variables.mdCustomerType.dataSet.loginFrom == "saveDraft") {
            //debugger
            Page.App.Variables.sv_createLoanApplication.invoke();
            Page.Widgets.label6.show = false;
            Page.Widgets.label5.show = false;
            Page.Widgets.validateOtp.show = false;
            Page.Widgets.otpField.show = false;
            Page.Widgets.label7.caption = "Application Draft has been sent to the registered customer";
            setTimeout(() => {
                Page.Actions.goToPage_HomeImprovementPage.navigate();
            }, 1000);

        } else {
            Page.Actions.goToPage_VideoKYCVerification.navigate();
        }

    }

};

Page.maskPhoneNumber = function(phoneNumber) {
    // Check if the phone number is valid (10 digits)
    if (phoneNumber.length === 10) {
        // Replace all but the last four digits with asterisks
        var maskedNumber = phoneNumber.substring(0, 6) + '****';
        return maskedNumber;
    } else {
        // Handle invalid phone number length
        return "Invalid phone number";
    }
};
Page.maskEmail = function(email) {
    // Split the email address into parts before and after the "@" symbol
    const parts = email.split('@');

    // Get the first part (before the "@") and mask characters except the first and last character
    const maskedUsername = parts[0].substring(0, 1) + '*'.repeat(parts[0].length - 2) + parts[0].substring(parts[0].length - 1);

    // Get the domain part (after the "@") and mask characters except the first and last character
    const domainParts = parts[1].split('.');
    const maskedDomain = domainParts[0].substring(0, 1) + '*'.repeat(domainParts[0].length - 2) + domainParts[0].substring(domainParts[0].length - 1);

    // Reconstruct the masked email
    const maskedEmail = maskedUsername + '@' + maskedDomain + '.' + domainParts.slice(1).join('.');

    return maskedEmail;
};

Page.text1Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Page.Widgets.text2.focus();
};
Page.text2Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Page.Widgets.text3.focus();
};
Page.text3Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Page.Widgets.text4.focus();
};
Page.text4Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Page.Widgets.text5.focus();
};
Page.text5Keyup = function($event, widget, newVal, oldVal) {
    //debugger
    Page.Widgets.text6.focus();
};
