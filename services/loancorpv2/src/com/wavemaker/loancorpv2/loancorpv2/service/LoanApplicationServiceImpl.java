/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loancorpv2.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.wavemaker.commons.InvalidInputException;
import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.annotations.EntityService;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;

import com.wavemaker.loancorpv2.loancorpv2.CommTrail;
import com.wavemaker.loancorpv2.loancorpv2.LoanApplication;
import com.wavemaker.loancorpv2.loancorpv2.LoanOffers;


/**
 * ServiceImpl object for domain model class LoanApplication.
 *
 * @see LoanApplication
 */
@Service("loancorpv2.LoanApplicationService")
@Validated
@EntityService(entityClass = LoanApplication.class, serviceId = "loancorpv2")
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanApplicationServiceImpl.class);

    @Lazy
    @Autowired
    @Qualifier("loancorpv2.CommTrailService")
    private CommTrailService commTrailService;

    @Lazy
    @Autowired
    @Qualifier("loancorpv2.LoanOffersService")
    private LoanOffersService loanOffersService;

    @Autowired
    @Qualifier("loancorpv2.LoanApplicationDao")
    private WMGenericDao<LoanApplication, Integer> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<LoanApplication, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "loancorpv2TransactionManager")
    @Override
    public LoanApplication create(LoanApplication loanApplication) {
        LOGGER.debug("Creating a new LoanApplication with information: {}", loanApplication);

        LoanApplication loanApplicationCreated = this.wmGenericDao.create(loanApplication);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(loanApplicationCreated);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public LoanApplication getById(Integer loanapplicationId) {
        LOGGER.debug("Finding LoanApplication by id: {}", loanapplicationId);
        return this.wmGenericDao.findById(loanapplicationId);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public LoanApplication findById(Integer loanapplicationId) {
        LOGGER.debug("Finding LoanApplication by id: {}", loanapplicationId);
        try {
            return this.wmGenericDao.findById(loanapplicationId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No LoanApplication found with id: {}", loanapplicationId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public List<LoanApplication> findByMultipleIds(List<Integer> loanapplicationIds, boolean orderedReturn) {
        LOGGER.debug("Finding LoanApplications by ids: {}", loanapplicationIds);

        return this.wmGenericDao.findByMultipleIds(loanapplicationIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "loancorpv2TransactionManager")
    @Override
    public LoanApplication update(LoanApplication loanApplication) {
        LOGGER.debug("Updating LoanApplication with information: {}", loanApplication);

        this.wmGenericDao.update(loanApplication);
        this.wmGenericDao.refresh(loanApplication);

        return loanApplication;
    }

    @Transactional(value = "loancorpv2TransactionManager")
    @Override
    public LoanApplication partialUpdate(Integer loanapplicationId, Map<String, Object>loanApplicationPatch) {
        LOGGER.debug("Partially Updating the LoanApplication with id: {}", loanapplicationId);

        LoanApplication loanApplication = getById(loanapplicationId);

        try {
            ObjectReader loanApplicationReader = this.objectMapper.reader().forType(LoanApplication.class).withValueToUpdate(loanApplication);
            loanApplication = loanApplicationReader.readValue(this.objectMapper.writeValueAsString(loanApplicationPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", loanApplicationPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        loanApplication = update(loanApplication);

        return loanApplication;
    }

    @Transactional(value = "loancorpv2TransactionManager")
    @Override
    public LoanApplication delete(Integer loanapplicationId) {
        LOGGER.debug("Deleting LoanApplication with id: {}", loanapplicationId);
        LoanApplication deleted = this.wmGenericDao.findById(loanapplicationId);
        if (deleted == null) {
            LOGGER.debug("No LoanApplication found with id: {}", loanapplicationId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), LoanApplication.class.getSimpleName(), loanapplicationId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "loancorpv2TransactionManager")
    @Override
    public void delete(LoanApplication loanApplication) {
        LOGGER.debug("Deleting LoanApplication with {}", loanApplication);
        this.wmGenericDao.delete(loanApplication);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public Page<LoanApplication> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all LoanApplications");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public Page<LoanApplication> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all LoanApplications");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service loancorpv2 for table LoanApplication to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service loancorpv2 for table LoanApplication to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public Page<CommTrail> findAssociatedCommTrails(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated commTrails");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("loanApplication.id = '" + id + "'");

        return commTrailService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "loancorpv2TransactionManager")
    @Override
    public Page<LoanOffers> findAssociatedLoanOfferses(Integer id, Pageable pageable) {
        LOGGER.debug("Fetching all associated loanOfferses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("loanApplication.id = '" + id + "'");

        return loanOffersService.findAll(queryBuilder.toString(), pageable);
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service CommTrailService instance
     */
    protected void setCommTrailService(CommTrailService service) {
        this.commTrailService = service;
    }

    /**
     * This setter method should only be used by unit tests
     *
     * @param service LoanOffersService instance
     */
    protected void setLoanOffersService(LoanOffersService service) {
        this.loanOffersService = service;
    }

}
