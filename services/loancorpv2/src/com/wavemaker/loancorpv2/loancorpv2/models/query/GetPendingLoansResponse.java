/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loancorpv2.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetPendingLoansResponse implements Serializable {


    @ColumnAlias("id")
    private Long id;

    @ColumnAlias("cd_id")
    private Long cdId;

    @ColumnAlias("creation_time")
    private Timestamp creationTime;

    @ColumnAlias("ld_id")
    private Long ldId;

    @ColumnAlias("loan_type")
    private String loanType;

    @ColumnAlias("customer_details_id")
    private Long customerDetailsId;

    @ColumnAlias("loan_details_id")
    private Long loanDetailsId;

    @ColumnAlias("status")
    private String status;

    @ColumnAlias("fname")
    private String fname;

    @ColumnAlias("lname")
    private String lname;

    @ColumnAlias("email")
    private String email;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCdId() {
        return this.cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public Timestamp getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Long getLdId() {
        return this.ldId;
    }

    public void setLdId(Long ldId) {
        this.ldId = ldId;
    }

    public String getLoanType() {
        return this.loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Long getCustomerDetailsId() {
        return this.customerDetailsId;
    }

    public void setCustomerDetailsId(Long customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }

    public Long getLoanDetailsId() {
        return this.loanDetailsId;
    }

    public void setLoanDetailsId(Long loanDetailsId) {
        this.loanDetailsId = loanDetailsId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetPendingLoansResponse)) return false;
        final GetPendingLoansResponse getPendingLoansResponse = (GetPendingLoansResponse) o;
        return Objects.equals(getId(), getPendingLoansResponse.getId()) &&
                Objects.equals(getCdId(), getPendingLoansResponse.getCdId()) &&
                Objects.equals(getCreationTime(), getPendingLoansResponse.getCreationTime()) &&
                Objects.equals(getLdId(), getPendingLoansResponse.getLdId()) &&
                Objects.equals(getLoanType(), getPendingLoansResponse.getLoanType()) &&
                Objects.equals(getCustomerDetailsId(), getPendingLoansResponse.getCustomerDetailsId()) &&
                Objects.equals(getLoanDetailsId(), getPendingLoansResponse.getLoanDetailsId()) &&
                Objects.equals(getStatus(), getPendingLoansResponse.getStatus()) &&
                Objects.equals(getFname(), getPendingLoansResponse.getFname()) &&
                Objects.equals(getLname(), getPendingLoansResponse.getLname()) &&
                Objects.equals(getEmail(), getPendingLoansResponse.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getCdId(),
                getCreationTime(),
                getLdId(),
                getLoanType(),
                getCustomerDetailsId(),
                getLoanDetailsId(),
                getStatus(),
                getFname(),
                getLname(),
                getEmail());
    }
}
