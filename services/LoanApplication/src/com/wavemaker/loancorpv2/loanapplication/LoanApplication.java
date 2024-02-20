/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loanapplication;

import com.wavemaker.loancorpv2.loancorpv2.*;
import com.wavemaker.loancorpv2.loancorpv2.service.*;

import javax.servlet.http.HttpServletRequest;

import org.checkerframework.checker.units.qual.K;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import com.wavemaker.loancorpv2.loanapplication.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 * <p>
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 * <p>
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 * <p>
 * NOTE: We do not recommend using method overloading on client exposed methods.
 */
@ExposeToClient
public class LoanApplication {

    private static final Logger logger = LoggerFactory.getLogger(LoanApplication.class);

    @Autowired
    private LoanApplicationService loanApplicationService;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private LoanDetailsService loanDetailsService;


    @Autowired
    private SecurityService securityService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocExtractedDataService docExtractedDataService;

    @Autowired
    private LoginDetailsService loginDetailsService;

    @Autowired
    private KycService kycService;

    @Value("${app.environment.customer}")
    private String customer;

    @Value("${app.environment.password}")
    private String password;

    private static final int PAGE_SIZE = 500;

    private static final String DOCUMENT_ID_PARAM = "documentId=";


    public void createLoanApplication(CreateLoanApplication createApplicationReq) {
        // Extract loan details
        LoanDetails loanDetails = createApplicationReq.getLoanDetails();
        LoanDetails createdLoanDetails = addToLoanDetails(loanDetails);

        // Extract customer details
        CustomerDetails createdCustomerDetails = addCustomerDetails(createApplicationReq.getCustomerDetails());

        // Set loan application details
        com.wavemaker.loancorpv2.loancorpv2.LoanApplication loanApplication = new com.wavemaker.loancorpv2.loancorpv2.LoanApplication();
        loanApplication.setLoanType(createApplicationReq.getLoanType());
        loanApplication.setLoanDetailsId(createdLoanDetails.getId());
        loanApplication.setCreationTime(Timestamp.valueOf(createApplicationReq.getCreationTime()));
        loanApplication.setStatus(createApplicationReq.getStatus());

        // Set customer detailsId if available
        if (createdCustomerDetails != null) {
            loanApplication.setCustomerDetailsId(createdCustomerDetails.getId());
        }

        // Create loan application
        com.wavemaker.loancorpv2.loancorpv2.LoanApplication loanApplicationDetails = loanApplicationService.create(loanApplication);

        // Add document details
        List<DocumentModel> documentModelList = createApplicationReq.getDocument();
        addDocumentDetails(documentModelList, String.valueOf(loanApplicationDetails.getId()));

        // Create and save KYC details
        Kyc applicationReqKyc = createApplicationReq.getKyc();
        byte[] kycImage = Base64.getDecoder().decode(createApplicationReq.getKycStringImage());
        applicationReqKyc.setLoanApplicationId(loanApplicationDetails.getId());
        applicationReqKyc.setKycImage(kycImage);
        kycService.create(applicationReqKyc);

        // Create login details for the customer
        createLoginDetails(createdCustomerDetails);
    }


    private void createLoginDetails(CustomerDetails createdCustomerDetails) {
        com.wavemaker.loancorpv2.loancorpv2.LoginDetails ld = new com.wavemaker.loancorpv2.loancorpv2.LoginDetails();

        ld.setRole(customer);
        ld.setCustomerId(createdCustomerDetails.getId());
        ld.setUserId(createdCustomerDetails.getEmail());
        ld.setPassword(password);
        loginDetailsService.create(ld);
    }

    public LoanDetails addToLoanDetails(LoanDetails loanDetailsReq) {

        return loanDetailsService.create(loanDetailsReq);
    }

    private CustomerDetails addCustomerDetails(CustomerDetails customerDetailsReq) {

        return customerDetailsService.create(customerDetailsReq);
    }

    private void addDocumentDetails(List<DocumentModel> documents, String id) {
        for (DocumentModel documentModel : documents) {
            Document createdDocument = createDocument(Integer.valueOf(id), documentModel);
            addDocumentExtractData(createdDocument.getId(), documentModel.getDocExtractData());
        }
    }

    private Document createDocument(Integer loanApplicationId, DocumentModel documentModel) {
        Document documentData = new Document();
        documentData.setLoanApplicationId(loanApplicationId);
        documentData.setFileSize(documentModel.getFileSize());
        documentData.setFileType(documentModel.getFileType());
        documentData.setFilePath(documentModel.getFilePath());
        documentData.setFileName(documentModel.getFileName());

        return documentService.create(documentData);
    }

    private void addDocumentExtractData(Integer documentId, DocExtractDataModel docExtractDataModel) {
        DocExtractedData docExtractedData = new DocExtractedData();
        docExtractedData.setDocumentId(documentId);
        docExtractedData.setW2SsnNo(docExtractDataModel.getW2SsnNo());
        docExtractedData.setW2Address(docExtractDataModel.getW2Address());
        docExtractedData.setW2EinNo(docExtractDataModel.getW2EinNo());
        docExtractedData.setW2State(docExtractDataModel.getW2State());
        docExtractedData.setW2Zip(docExtractDataModel.getW2Zip());
        docExtractedData.setDlNo(docExtractDataModel.getDlNo());

        docExtractedDataService.create(docExtractedData);
    }


    public CreateLoanApplication getCreatedLoanApplicationById(String id) {
        com.wavemaker.loancorpv2.loancorpv2.LoanApplication loanApplicationDetails = loanApplicationService.getById(Integer.valueOf(id));
        CreateLoanApplication createLoanApplication = mapToCreateLoanApplication(loanApplicationDetails);

        try {
            List<DocumentModel> documentModelList = getDocumentModelsForLoanApplication(loanApplicationDetails);
            createLoanApplication.setDocument(documentModelList);
        } catch (Exception e) {
            logger.error("Exception while fetching document details: " + e.getMessage(), e);
            throw new RuntimeException("Error fetching document details", e);
        }

        return createLoanApplication;
    }

    private CreateLoanApplication mapToCreateLoanApplication(com.wavemaker.loancorpv2.loancorpv2.LoanApplication loanApplicationDetails) {
        CreateLoanApplication createLoanApplication = new CreateLoanApplication();
        createLoanApplication.setLoanDetailsId(String.valueOf(loanApplicationDetails.getLoanDetailsId()));
        createLoanApplication.setCustomerDetails(loanApplicationDetails.getCustomerDetails());
        createLoanApplication.setLoanType(loanApplicationDetails.getLoanType());
        createLoanApplication.setLoanDetails(loanApplicationDetails.getLoanDetails());
        createLoanApplication.setCreationTime(String.valueOf(loanApplicationDetails.getCreationTime()));
        createLoanApplication.setId(String.valueOf(loanApplicationDetails.getId()));
        createLoanApplication.setCustomerDetailsId(String.valueOf(loanApplicationDetails.getCustomerDetailsId()));
        createLoanApplication.setStatus(loanApplicationDetails.getStatus());
        return createLoanApplication;
    }


    private List<DocumentModel> getDocumentModelsForLoanApplication(com.wavemaker.loancorpv2.loancorpv2.LoanApplication loanApplicationDetails) {
        Page<Document> documents = documentService.findAll((String) null, PageRequest.of(0, PAGE_SIZE));

        return documents.getContent().stream()
                .filter(document -> {
                    String documentLoanApplicationId = document != null ? String.valueOf(document.getLoanApplicationId()) : "null";
                    String detailsLoanApplicationId = loanApplicationDetails != null ? String.valueOf(loanApplicationDetails.getId()) : "null";
                    boolean filterResult = document != null && documentLoanApplicationId.equals(detailsLoanApplicationId);
                    return filterResult;
                })
                .map(document -> mapToDocumentModel(document))
                .collect(Collectors.toList());
    }

    private DocumentModel mapToDocumentModel(Document documentDetails) {
        DocumentModel documentModel = new DocumentModel();
        documentModel.setFileName(documentDetails.getFileName());
        documentModel.setFilePath(documentDetails.getFilePath());
        documentModel.setId(String.valueOf(documentDetails.getId()));
        documentModel.setLoanApplicationId(String.valueOf(documentDetails.getLoanApplicationId()));
        documentModel.setFileType(documentDetails.getFileType());
        documentModel.setFileSize(documentDetails.getFileSize());

        Page<DocExtractedData> docExtractedDataDetails = docExtractedDataService.findAll(DOCUMENT_ID_PARAM + documentDetails.getId(), Pageable.unpaged());
        DocExtractDataModel docExtractDataModel = new DocExtractDataModel();

        docExtractedDataDetails.forEach(docExtractedData -> {
            docExtractDataModel.setId(String.valueOf(docExtractedData.getId()));
            docExtractDataModel.setDocumentId(String.valueOf(docExtractedData.getDocumentId()));
            docExtractDataModel.setDlNo(docExtractedData.getDlNo());
            docExtractDataModel.setW2EinNo(docExtractedData.getW2EinNo());
            docExtractDataModel.setW2Wages(String.valueOf(docExtractedData.getW2Wages()));
            docExtractDataModel.setW2State(docExtractedData.getW2State());
            docExtractDataModel.setW2Zip(String.valueOf(docExtractedData.getW2Zip()));
            docExtractDataModel.setW2Address(docExtractedData.getW2Address());
            docExtractDataModel.setW2SsnNo(docExtractedData.getW2SsnNo());
        });

        documentModel.setDocExtractData(docExtractDataModel);

        return documentModel;
    }

}
