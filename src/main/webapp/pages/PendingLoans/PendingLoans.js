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



// Page.mdTestDataList1Select = function(widget, $data) {
//     Page.Actions.goToPage_LoanDetails.navigate();
// };

// Page.pendingLoansTable_updaterowAction = function($event, row) {
//     debugger

// };

Page.executeGetPendingLoansTable2_updaterowAction = function($event, row) {
    localStorage.setItem("loanId", row.id);
    Page.App.Variables.md_loanId.dataSet.dataValue = row.id;
};
