/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loanapplication.model;

public class LoanDetailsModel {
    private String id;
    private String amount;
    private String tenure;
    private String emiFreq;
    private String interestRate;
    private String interestAmt;
    private String defaultProbability;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getEmiFreq() {
        return emiFreq;
    }

    public void setEmiFreq(String emiFreq) {
        this.emiFreq = emiFreq;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getInterestAmt() {
        return interestAmt;
    }

    public void setInterestAmt(String interestAmt) {
        this.interestAmt = interestAmt;
    }

    public String getDefaultProbability() {
        return defaultProbability;
    }

    public void setDefaultProbability(String defaultProbability) {
        this.defaultProbability = defaultProbability;
    }
}
