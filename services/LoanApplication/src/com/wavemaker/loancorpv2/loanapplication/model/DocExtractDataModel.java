/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loanapplication.model;

public class DocExtractDataModel {

    private String id;
    private String documentId;
    private String w2EinNo;
    private String w2Wages;
    private String w2State;
    private String w2Zip;
    private String w2Address;
    private String w2SsnNo;
    private String dlNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getW2EinNo() {
        return w2EinNo;
    }

    public void setW2EinNo(String w2EinNo) {
        this.w2EinNo = w2EinNo;
    }

    public String getW2Wages() {
        return w2Wages;
    }

    public void setW2Wages(String w2Wages) {
        this.w2Wages = w2Wages;
    }

    public String getW2State() {
        return w2State;
    }

    public void setW2State(String w2State) {
        this.w2State = w2State;
    }

    public String getW2Zip() {
        return w2Zip;
    }

    public void setW2Zip(String w2Zip) {
        this.w2Zip = w2Zip;
    }

    public String getW2Address() {
        return w2Address;
    }

    public void setW2Address(String w2Address) {
        this.w2Address = w2Address;
    }

    public String getW2SsnNo() {
        return w2SsnNo;
    }

    public void setW2SsnNo(String w2SsnNo) {
        this.w2SsnNo = w2SsnNo;
    }

    public String getDlNo() {
        return dlNo;
    }

    public void setDlNo(String dlNo) {
        this.dlNo = dlNo;
    }
}
