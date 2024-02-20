/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loancorpv2;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Kyc generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`kyc`")
public class Kyc implements Serializable {

    private Integer id;
    private int loanApplicationId;
    private Timestamp lastUpdate;
    private Timestamp startDate;
    private String status;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] kycImage;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`loan_application_id`", nullable = false, scale = 0, precision = 10)
    public int getLoanApplicationId() {
        return this.loanApplicationId;
    }

    public void setLoanApplicationId(int loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    @Column(name = "`last_update`", nullable = false)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Column(name = "`start_date`", nullable = false)
    public Timestamp getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Column(name = "`status`", nullable = true, length = 255)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "`kyc_image`", nullable = true)
    public byte[] getKycImage() {
        return this.kycImage;
    }

    public void setKycImage(byte[] kycImage) {
        this.kycImage = kycImage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kyc)) return false;
        final Kyc kyc = (Kyc) o;
        return Objects.equals(getId(), kyc.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
