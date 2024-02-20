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
Prefab.onPropertyChange = function(key, newVal, oldVal) {
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
let annualInterestRate;
Prefab.onReady = function() {
    // this method will be triggered post initialization of the prefab.
    annualInterestRate = 24;

};

// Prefab.calculateLoanAmount = function(loanAmount, loanTenureInYears, annualInterestRate) {
//     // Convert annual interest rate to a decimal
//     const monthlyInterestRate = annualInterestRate / 12 / 100;
//     const fortnightlyInterestRate = annualInterestRate / 26 / 100;
//     const weeklyInterestRate = annualInterestRate / 52 / 100;

//     // Calculate the number of payments
//     const numberOfMonthlyPayments = loanTenureInYears * 12;
//     const numberOfFortnightlyPayments = loanTenureInYears * 26;
//     const numberOfWeeklyPayments = loanTenureInYears * 52;

//     // Calculate EMI for each frequency
//     const monthlyEMI = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) / (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) - 1);
//     const fortnightlyEMI = loanAmount * fortnightlyInterestRate * Math.pow(1 + fortnightlyInterestRate, numberOfFortnightlyPayments) / (Math.pow(1 + fortnightlyInterestRate, numberOfFortnightlyPayments) - 1);
//     const weeklyEMI = loanAmount * weeklyInterestRate * Math.pow(1 + weeklyInterestRate, numberOfWeeklyPayments) / (Math.pow(1 + weeklyInterestRate, numberOfWeeklyPayments) - 1);

//     // Calculate total amounts
//     const totalInterestMonthly = (monthlyEMI * numberOfMonthlyPayments) - loanAmount;
//     const totalAmountMonthly = monthlyEMI * numberOfMonthlyPayments;

//     const totalInterestFortnightly = (fortnightlyEMI * numberOfFortnightlyPayments) - loanAmount;
//     const totalAmountFortnightly = fortnightlyEMI * numberOfFortnightlyPayments;

//     const totalInterestWeekly = (weeklyEMI * numberOfWeeklyPayments) - loanAmount;
//     const totalAmountWeekly = weeklyEMI * numberOfWeeklyPayments;

//     // Calculate percentages
//     const interestPercentageMonthly = (totalInterestMonthly / totalAmountMonthly) * 100;
//     const principalPercentageMonthly = (loanAmount / totalAmountMonthly) * 100;

//     const interestPercentageFortnightly = (totalInterestFortnightly / totalAmountFortnightly) * 100;
//     const principalPercentageFortnightly = (loanAmount / totalAmountFortnightly) * 100;

//     const interestPercentageWeekly = (totalInterestWeekly / totalAmountWeekly) * 100;
//     const principalPercentageWeekly = (loanAmount / totalAmountWeekly) * 100;

//     // Construct the result JSON object
//     const result = {
//         'EMI_Details': {
//             'Monthly': {
//                 'Emi': Math.round(monthlyEMI),
//                 'InterestAmt': Math.round(totalInterestMonthly),
//                 'PricipalAmt': loanAmount,
//                 'InterestPercentage': Math.round(interestPercentageMonthly),
//                 'PricipalPercentage': Math.round(principalPercentageMonthly),
//                 'TotalPayment': (Math.round(totalInterestMonthly) + parseInt(loanAmount))
//             },
//             'Fortnightly': {
//                 'Emi': Math.round(fortnightlyEMI),
//                 'InterestAmt': Math.round(totalInterestFortnightly),
//                 'PricipalAmt': loanAmount,
//                 'InterestPercentage': Math.round(interestPercentageFortnightly),
//                 'PricipalPercentage': Math.round(principalPercentageFortnightly),
//                 'TotalPayment': (Math.round(totalInterestFortnightly) + parseInt(loanAmount))
//             },
//             'Weekly': {
//                 'Emi': Math.round(weeklyEMI),
//                 'InterestAmt': Math.round(totalInterestWeekly),
//                 'PricipalAmt': loanAmount,
//                 'InterestPercentage': Math.round(interestPercentageWeekly),
//                 'PricipalPercentage': Math.round(principalPercentageWeekly),
//                 'TotalPayment': (Math.round(totalInterestWeekly) + parseInt(loanAmount))
//             }
//         }
//     };

//     Prefab.calculatedamount = result;
//     return result;
// };


/*
 * calculateLoan Amount
 */
Prefab.calculatLaonAmount = function (loanAmount, loanTenureInYears, annualInterestRate) {
    // Convert annual interest rate to a decimal
    const monthlyInterestRate = annualInterestRate / 12 / 100;
    const fortnightlyInterestRate = annualInterestRate / 26 / 100;
    const weeklyInterestRate = annualInterestRate / 52 / 100;

    // Calculate the number of payments
    const numberOfMonthlyPayments = loanTenureInYears * 12;
    const numberOfFortnightlyPayments = loanTenureInYears * 26;
    const numberOfWeeklyPayments = loanTenureInYears * 52;

    // Calculate EMI for each frequency
    const monthlyEMI = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) / (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) - 1);
    const fortnightlyEMI = loanAmount * fortnightlyInterestRate * Math.pow(1 + fortnightlyInterestRate, numberOfFortnightlyPayments) / (Math.pow(1 + fortnightlyInterestRate, numberOfFortnightlyPayments) - 1);
    const weeklyEMI = loanAmount * weeklyInterestRate * Math.pow(1 + weeklyInterestRate, numberOfWeeklyPayments) / (Math.pow(1 + weeklyInterestRate, numberOfWeeklyPayments) - 1);

    // Calculate total amounts
    const totalInterestMonthly = (monthlyEMI * numberOfMonthlyPayments) - loanAmount;
    const totalAmountMonthly = monthlyEMI * numberOfMonthlyPayments;

    const totalInterestFortnightly = (fortnightlyEMI * numberOfFortnightlyPayments) - loanAmount;
    const totalAmountFortnightly = fortnightlyEMI * numberOfFortnightlyPayments;

    const totalInterestWeekly = (weeklyEMI * numberOfWeeklyPayments) - loanAmount;
    const totalAmountWeekly = weeklyEMI * numberOfWeeklyPayments;

    // Calculate percentages
    const interestPercentageMonthly = (totalInterestMonthly / totalAmountMonthly) * 100;
    const principalPercentageMonthly = (loanAmount / totalAmountMonthly) * 100;

    const interestPercentageFortnightly = (totalInterestFortnightly / totalAmountFortnightly) * 100;
    const principalPercentageFortnightly = (loanAmount / totalAmountFortnightly) * 100;

    const interestPercentageWeekly = (totalInterestWeekly / totalAmountWeekly) * 100;
    const principalPercentageWeekly = (loanAmount / totalAmountWeekly) * 100;

    // Construct the result JSON object
    const result = {
        'EMI_Details': {
            'Monthly': {
                'Emi': Math.round(monthlyEMI),
                'InterestAmt': Math.round(totalInterestMonthly),
                'PricipalAmt': loanAmount,
                'InterestPercentage': Math.round(interestPercentageMonthly),
                'PricipalPercentage': Math.round(principalPercentageMonthly),
                'TotalPayment': (Math.round(totalInterestMonthly) + parseInt(loanAmount))
            },
            'Fortnightly': {
                'Emi': Math.round(fortnightlyEMI),
                'InterestAmt': Math.round(totalInterestFortnightly),
                'PricipalAmt': loanAmount,
                'InterestPercentage': Math.round(interestPercentageFortnightly),
                'PricipalPercentage': Math.round(principalPercentageFortnightly),
                'TotalPayment': (Math.round(totalInterestFortnightly) + parseInt(loanAmount))
            },
            'Weekly': {
                'Emi': Math.round(weeklyEMI),
                'InterestAmt': Math.round(totalInterestWeekly),
                'PricipalAmt': loanAmount,
                'InterestPercentage': Math.round(interestPercentageWeekly),
                'PricipalPercentage': Math.round(principalPercentageWeekly),
                'TotalPayment': (Math.round(totalInterestWeekly) + parseInt(loanAmount))
            }
        }
    };

    //Prefab.calculatedamount = result;
    return result;
};
