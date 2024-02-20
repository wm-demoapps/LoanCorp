/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loancorpv2;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * CreditHistory generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`credit_history`")
public class CreditHistory implements Serializable {

    private Integer id;
    private Integer customerDetailsId;
    private Integer creditScore;
    private Date scoreDate;
    private Integer previousScore;
    private Integer repaymentScore;
    private Integer monthlyIncome;
    private String creditHistoryDuration;
    private CustomerDetails customerDetails;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`customer_details_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCustomerDetailsId() {
        return this.customerDetailsId;
    }

    public void setCustomerDetailsId(Integer customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }

    @Column(name = "`credit_score`", nullable = true, scale = 0, precision = 10)
    public Integer getCreditScore() {
        return this.creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    @Column(name = "`score_date`", nullable = true)
    public Date getScoreDate() {
        return this.scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }

    @Column(name = "`previous_score`", nullable = true, scale = 0, precision = 10)
    public Integer getPreviousScore() {
        return this.previousScore;
    }

    public void setPreviousScore(Integer previousScore) {
        this.previousScore = previousScore;
    }

    @Column(name = "`repayment_score`", nullable = true, scale = 0, precision = 10)
    public Integer getRepaymentScore() {
        return this.repaymentScore;
    }

    public void setRepaymentScore(Integer repaymentScore) {
        this.repaymentScore = repaymentScore;
    }

    @Column(name = "`monthly_income`", nullable = true, scale = 0, precision = 10)
    public Integer getMonthlyIncome() {
        return this.monthlyIncome;
    }

    public void setMonthlyIncome(Integer monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @Column(name = "`credit_history_duration`", nullable = true, length = 255)
    public String getCreditHistoryDuration() {
        return this.creditHistoryDuration;
    }

    public void setCreditHistoryDuration(String creditHistoryDuration) {
        this.creditHistoryDuration = creditHistoryDuration;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`customer_details_id`", referencedColumnName = "`id`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_credit_history_TO_cusSisZj`"))
    @Fetch(FetchMode.JOIN)
    public CustomerDetails getCustomerDetails() {
        return this.customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        if(customerDetails != null) {
            this.customerDetailsId = customerDetails.getId();
        }

        this.customerDetails = customerDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditHistory)) return false;
        final CreditHistory creditHistory = (CreditHistory) o;
        return Objects.equals(getId(), creditHistory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
