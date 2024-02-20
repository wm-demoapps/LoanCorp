/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loancorpv2.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;

import com.wavemaker.loancorpv2.loancorpv2.CreditHistory;
import com.wavemaker.loancorpv2.loancorpv2.CustomerDetails;
import com.wavemaker.loancorpv2.loancorpv2.LoanApplication;
import com.wavemaker.loancorpv2.loancorpv2.LoginDetails;

/**
 * Service object for domain model class {@link CustomerDetails}.
 */
public interface CustomerDetailsService {

    /**
     * Creates a new CustomerDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CustomerDetails if any.
     *
     * @param customerDetails Details of the CustomerDetails to be created; value cannot be null.
     * @return The newly created CustomerDetails.
     */
    CustomerDetails create(@Valid CustomerDetails customerDetails);


	/**
     * Returns CustomerDetails by given id if exists.
     *
     * @param customerdetailsId The id of the CustomerDetails to get; value cannot be null.
     * @return CustomerDetails associated with the given customerdetailsId.
	 * @throws EntityNotFoundException If no CustomerDetails is found.
     */
    CustomerDetails getById(Integer customerdetailsId);

    /**
     * Find and return the CustomerDetails by given id if exists, returns null otherwise.
     *
     * @param customerdetailsId The id of the CustomerDetails to get; value cannot be null.
     * @return CustomerDetails associated with the given customerdetailsId.
     */
    CustomerDetails findById(Integer customerdetailsId);

	/**
     * Find and return the list of CustomerDetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param customerdetailsIds The id's of the CustomerDetails to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return CustomerDetails associated with the given customerdetailsIds.
     */
    List<CustomerDetails> findByMultipleIds(List<Integer> customerdetailsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing CustomerDetails. It replaces all fields of the existing CustomerDetails with the given customerDetails.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CustomerDetails if any.
     *
     * @param customerDetails The details of the CustomerDetails to be updated; value cannot be null.
     * @return The updated CustomerDetails.
     * @throws EntityNotFoundException if no CustomerDetails is found with given input.
     */
    CustomerDetails update(@Valid CustomerDetails customerDetails);


    /**
     * Partially updates the details of an existing CustomerDetails. It updates only the
     * fields of the existing CustomerDetails which are passed in the customerDetailsPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on CustomerDetails if any.
     *
     * @param customerdetailsId The id of the CustomerDetails to be deleted; value cannot be null.
     * @param customerDetailsPatch The partial data of CustomerDetails which is supposed to be updated; value cannot be null.
     * @return The updated CustomerDetails.
     * @throws EntityNotFoundException if no CustomerDetails is found with given input.
     */
    CustomerDetails partialUpdate(Integer customerdetailsId, Map<String, Object> customerDetailsPatch);

    /**
     * Deletes an existing CustomerDetails with the given id.
     *
     * @param customerdetailsId The id of the CustomerDetails to be deleted; value cannot be null.
     * @return The deleted CustomerDetails.
     * @throws EntityNotFoundException if no CustomerDetails found with the given id.
     */
    CustomerDetails delete(Integer customerdetailsId);

    /**
     * Deletes an existing CustomerDetails with the given object.
     *
     * @param customerDetails The instance of the CustomerDetails to be deleted; value cannot be null.
     */
    void delete(CustomerDetails customerDetails);

    /**
     * Find all CustomerDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CustomerDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<CustomerDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all CustomerDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching CustomerDetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<CustomerDetails> findAll(String query, Pageable pageable);

    /**
     * Exports all CustomerDetails matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all CustomerDetails matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the CustomerDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the CustomerDetails.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated creditHistories for given CustomerDetails id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated CreditHistory instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<CreditHistory> findAssociatedCreditHistories(Integer id, Pageable pageable);

    /*
     * Returns the associated loanApplications for given CustomerDetails id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated LoanApplication instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<LoanApplication> findAssociatedLoanApplications(Integer id, Pageable pageable);

    /*
     * Returns the associated loginDetailses for given CustomerDetails id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated LoginDetails instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<LoginDetails> findAssociatedLoginDetailses(Integer id, Pageable pageable);

}
