/**
 * This file is used to extend the app runtime
 *
 * Custom Formatters:
 * Used for data formatting across widgets. Apart from predefined formatter like toDate, toCurrency, prefix, etc, you can define custom formatters here.
 * Once defined here, custom formatters appear in the "Use Expression" tab of data binding dialog.
 * E.g. Here is sample custom formatter (for data formatting)
 *   myFormatter : {
 *     formatter : function(data, param1){
 *       // your logic goes here
 *       return data;
 *     },
 *     config: {
 *       param1: {
 *         name: '',
 *         widget: '',
 *         value: ''
 *       }...
 *     }
 *   }
 *
 * Terminology
 * myFormatter	:   Name of the custom formatter
 * formatter 	:   Function where you can write the logic to format the data. The returned value from this function will be applied on the property this formatter is bound to
 * config       :   parameter information required during the design time. List down all the parameters required for your formatter function
 *                  Each param has following info
 *                  - name      : name of the parameter to display during design time
 *                  - widget    : widget to take parameter input from the user. E.g. text, select
 *                  - value     : default value if user doesn't provide any value
 */

// var WM_CUSTOM_FORMATTERS =(function(){
//   // Define custom formatters here.

//       maskPhoneNumber: {
//             formatter:function(data,context) {
//                 debugger
//                 if (data.length === 10) {
//         // Replace all but the last four digits need to display
//         let maskedNumber = '******' + data.substring(6, 10);
//         return maskedNumber;
//     } else {
//         // Handle invalid phone number length
//         return "Invalid phone number";
//     }
//             }

//   }




//   })();

var WM_CUSTOM_FORMATTERS = (function() {
    // Define custom pipes here.
    debugger
    return {

        maskPhoneNumber: {
            formatter: function(data, context) {
                debugger

                if (data.length === 10) {
                    // Replace all but the last four digits need to display
                    let maskedNumber = '******' + data.substring(6, 10);
                    return maskedNumber;
                } else {
                    // Handle invalid phone number length
                    return "Invalid phone number";
                }

            }

        },
        maskEmail: {
            formatter: function(data, context) {
                const parts = data.split('@');

                // Get the first part (before the "@") and mask characters except the first and last character
                const maskedUsername = parts[0].substring(0, 1) + '*'.repeat(parts[0].length - 2) + parts[0].substring(parts[0].length - 1);

                // Get the domain part (after the "@") and mask characters except the first and last character

                const domainParts = parts[1].split('.');
                const maskedDomain = domainParts[0].substring(0, 1) + '*'.repeat(domainParts[0].length - 2) + domainParts[0].substring(domainParts[0].length - 1);

                // Reconstruct the masked email
                const maskedEmail = maskedUsername + '@' + maskedDomain + '.' + domainParts.slice(1).join('.');

                return maskedEmail;
            }
        }
    }

})();
