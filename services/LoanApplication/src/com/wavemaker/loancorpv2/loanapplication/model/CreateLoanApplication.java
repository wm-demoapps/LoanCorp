/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loanapplication.model;

import com.wavemaker.loancorpv2.loancorpv2.CustomerDetails;
import com.wavemaker.loancorpv2.loancorpv2.Document;
import com.wavemaker.loancorpv2.loancorpv2.Kyc;
import com.wavemaker.loancorpv2.loancorpv2.LoanDetails;

import java.util.List;

public class CreateLoanApplication {
    public List<DocumentModel> getDocument() {
        return document;
    }

    public void setDocument(List<DocumentModel> document) {
        this.document = document;
    }

    private String id;
    private String loanDetailsId;
    private String customerDetailsId;
    private String loanType;
    private String creationTime;
    private String status;

    private String kycStringImage;
    private CustomerDetails customerDetails;
    private List<DocumentModel> document;
    private LoanDetails loanDetails;

    private Kyc kyc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoanDetailsId() {
        return loanDetailsId;
    }

    public void setLoanDetailsId(String loanDetailsId) {
        this.loanDetailsId = loanDetailsId;
    }

    public String getCustomerDetailsId() {
        return customerDetailsId;
    }

    public void setCustomerDetailsId(String customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }


    public LoanDetails getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(LoanDetails loanDetails) {
        this.loanDetails = loanDetails;
    }

    public Kyc getKyc() {
        return kyc;
    }

    public void setKyc(Kyc kyc) {
        this.kyc = kyc;
    }

    public String getKycStringImage() {
        return kycStringImage;
    }

    public void setKycStringImage(String kycStringImage) {
        this.kycStringImage = kycStringImage;
    }
}
