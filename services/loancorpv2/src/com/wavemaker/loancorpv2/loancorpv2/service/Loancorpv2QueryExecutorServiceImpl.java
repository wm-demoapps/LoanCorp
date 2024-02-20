/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loancorpv2.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.exception.BlobContentNotFoundException;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportOptions;
import com.wavemaker.runtime.data.model.QueryProcedureInput;

import com.wavemaker.loancorpv2.loancorpv2.models.query.*;

@Service
public class Loancorpv2QueryExecutorServiceImpl implements Loancorpv2QueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Loancorpv2QueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("loancorpv2WMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public Page<GetloanappdetailsResponse> executeGetloanappdetails(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("getloanappdetails", params, GetloanappdetailsResponse.class, pageable);
    }

    @Transactional(value = "loancorpv2TransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportGetloanappdetails(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput<GetloanappdetailsResponse> queryInput = new QueryProcedureInput<>("getloanappdetails", params, GetloanappdetailsResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "loancorpv2TransactionManager")
    @Override
    public Integer executeUpdateLoanApplicationStatus(UpdateLoanApplicationStatusRequest updateLoanApplicationStatusRequest) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("status", updateLoanApplicationStatusRequest.getStatus());
        params.put("loanId", updateLoanApplicationStatusRequest.getLoanId());

        return queryExecutor.executeNamedQueryForUpdate("updateLoanApplicationStatus", params);
    }

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public Page<GetPendingLoansResponse> executeGetPendingLoans(Pageable pageable) {
        Map<String, Object> params = new HashMap<>(0);


        return queryExecutor.executeNamedQuery("GetPendingLoans", params, GetPendingLoansResponse.class, pageable);
    }

    @Transactional(value = "loancorpv2TransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportGetPendingLoans(ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(0);


        QueryProcedureInput<GetPendingLoansResponse> queryInput = new QueryProcedureInput<>("GetPendingLoans", params, GetPendingLoansResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public Page<ValidateUserResponse> executeValidateUser(String id, String pswd, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("id", id);
        params.put("pswd", pswd);

        return queryExecutor.executeNamedQuery("validateUser", params, ValidateUserResponse.class, pageable);
    }

    @Transactional(value = "loancorpv2TransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportValidateUser(String id, String pswd, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("id", id);
        params.put("pswd", pswd);

        QueryProcedureInput<ValidateUserResponse> queryInput = new QueryProcedureInput<>("validateUser", params, ValidateUserResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public Page<TestCustomerDetailsResponse> executeTest_customer_details(String id, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        return queryExecutor.executeNamedQuery("test_customer_details", params, TestCustomerDetailsResponse.class, pageable);
    }

    @Transactional(value = "loancorpv2TransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportTest_customer_details(String id, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        QueryProcedureInput<TestCustomerDetailsResponse> queryInput = new QueryProcedureInput<>("test_customer_details", params, TestCustomerDetailsResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public Page<GetCustomerLoanDetailsResponse> executeGetCustomerLoanDetails(String id, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        return queryExecutor.executeNamedQuery("getCustomerLoanDetails", params, GetCustomerLoanDetailsResponse.class, pageable);
    }

    @Transactional(value = "loancorpv2TransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportGetCustomerLoanDetails(String id, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        QueryProcedureInput<GetCustomerLoanDetailsResponse> queryInput = new QueryProcedureInput<>("getCustomerLoanDetails", params, GetCustomerLoanDetailsResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public Page<GetKycImageResponse> executeGetKycImage(String id, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        return queryExecutor.executeNamedQuery("getKycImage", params, GetKycImageResponse.class, pageable);
    }

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public InputStream getKycImageContentForGetKycImage(Long id1, String id) throws EntityNotFoundException {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id_1", id1);
        params.put("id", id);

        GetKycImageResponse _result =  queryExecutor.executeNamedQuery("getKycImage__identifier", params, GetKycImageResponse.class);
        if(_result.getKycImage() == null) {
            LOGGER.debug("Blob content not exists for kycImage in query getKycImage");
            throw new BlobContentNotFoundException(MessageResource.create("com.wavemaker.runtime.blob.content.not.found"), "kycImage", "query", "getKycImage");
        }
        return new ByteArrayInputStream(_result.getKycImage());
    }

    @Transactional(value = "loancorpv2TransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportGetKycImage(String id, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        QueryProcedureInput<GetKycImageResponse> queryInput = new QueryProcedureInput<>("getKycImage", params, GetKycImageResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

    @Transactional(value = "loancorpv2TransactionManager", readOnly = true)
    @Override
    public Page<GetCustomerIdResponse> executeGetCustomerId(String id, Pageable pageable) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        return queryExecutor.executeNamedQuery("getCustomerId", params, GetCustomerIdResponse.class, pageable);
    }

    @Transactional(value = "loancorpv2TransactionManager", timeout = 300, readOnly = true)
    @Override
    public void exportGetCustomerId(String id, ExportOptions exportOptions, Pageable pageable, OutputStream outputStream) {
        Map<String, Object> params = new HashMap<>(1);

        params.put("id", id);

        QueryProcedureInput<GetCustomerIdResponse> queryInput = new QueryProcedureInput<>("getCustomerId", params, GetCustomerIdResponse.class);

        queryExecutor.exportNamedQueryData(queryInput, exportOptions, pageable, outputStream);
    }

}
