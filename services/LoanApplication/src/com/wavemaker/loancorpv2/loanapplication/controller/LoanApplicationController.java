package com.wavemaker.loancorpv2.loanapplication.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.loancorpv2.loanapplication.LoanApplication;
import com.wavemaker.loancorpv2.loanapplication.model.CreateLoanApplication;
import com.wavemaker.loancorpv2.loancorpv2.LoanDetails;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;

/**
 * Controller object for domain model class {@link LoanApplication}.
 * @see LoanApplication
 */
@RestController
@Api(value = "LoanApplicationController", description = "controller class for java service execution")
@RequestMapping("/loanApplication")
public class LoanApplicationController {

    @Autowired
    private LoanApplication loanApplication;

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/toLoanDetails")
    public LoanDetails addToLoanDetails(@RequestBody LoanDetails loanDetailsReq) {
        return loanApplication.addToLoanDetails(loanDetailsReq);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @PostMapping(value = "/loanApplication")
    public void createLoanApplication(@RequestBody CreateLoanApplication createApplicationReq) {
        loanApplication.createLoanApplication(createApplicationReq);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @GetMapping(value = "/createdLoanApplicationById")
    public CreateLoanApplication getCreatedLoanApplicationById(@RequestParam(value = "id", required = false) String id) {
        return loanApplication.getCreatedLoanApplicationById(id);
    }
}
