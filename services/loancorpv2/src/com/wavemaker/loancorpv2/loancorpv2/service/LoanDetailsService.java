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

import com.wavemaker.loancorpv2.loancorpv2.LoanApplication;
import com.wavemaker.loancorpv2.loancorpv2.LoanDetails;

/**
 * Service object for domain model class {@link LoanDetails}.
 */
public interface LoanDetailsService {

    /**
     * Creates a new LoanDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LoanDetails if any.
     *
     * @param loanDetails Details of the LoanDetails to be created; value cannot be null.
     * @return The newly created LoanDetails.
     */
    LoanDetails create(@Valid LoanDetails loanDetails);


	/**
     * Returns LoanDetails by given id if exists.
     *
     * @param loandetailsId The id of the LoanDetails to get; value cannot be null.
     * @return LoanDetails associated with the given loandetailsId.
	 * @throws EntityNotFoundException If no LoanDetails is found.
     */
    LoanDetails getById(Integer loandetailsId);

    /**
     * Find and return the LoanDetails by given id if exists, returns null otherwise.
     *
     * @param loandetailsId The id of the LoanDetails to get; value cannot be null.
     * @return LoanDetails associated with the given loandetailsId.
     */
    LoanDetails findById(Integer loandetailsId);

	/**
     * Find and return the list of LoanDetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param loandetailsIds The id's of the LoanDetails to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return LoanDetails associated with the given loandetailsIds.
     */
    List<LoanDetails> findByMultipleIds(List<Integer> loandetailsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing LoanDetails. It replaces all fields of the existing LoanDetails with the given loanDetails.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LoanDetails if any.
     *
     * @param loanDetails The details of the LoanDetails to be updated; value cannot be null.
     * @return The updated LoanDetails.
     * @throws EntityNotFoundException if no LoanDetails is found with given input.
     */
    LoanDetails update(@Valid LoanDetails loanDetails);


    /**
     * Partially updates the details of an existing LoanDetails. It updates only the
     * fields of the existing LoanDetails which are passed in the loanDetailsPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LoanDetails if any.
     *
     * @param loandetailsId The id of the LoanDetails to be deleted; value cannot be null.
     * @param loanDetailsPatch The partial data of LoanDetails which is supposed to be updated; value cannot be null.
     * @return The updated LoanDetails.
     * @throws EntityNotFoundException if no LoanDetails is found with given input.
     */
    LoanDetails partialUpdate(Integer loandetailsId, Map<String, Object> loanDetailsPatch);

    /**
     * Deletes an existing LoanDetails with the given id.
     *
     * @param loandetailsId The id of the LoanDetails to be deleted; value cannot be null.
     * @return The deleted LoanDetails.
     * @throws EntityNotFoundException if no LoanDetails found with the given id.
     */
    LoanDetails delete(Integer loandetailsId);

    /**
     * Deletes an existing LoanDetails with the given object.
     *
     * @param loanDetails The instance of the LoanDetails to be deleted; value cannot be null.
     */
    void delete(LoanDetails loanDetails);

    /**
     * Find all LoanDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LoanDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<LoanDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all LoanDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LoanDetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<LoanDetails> findAll(String query, Pageable pageable);

    /**
     * Exports all LoanDetails matching the given input query to the given exportType format.
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
     * Exports all LoanDetails matching the given input query to the given exportType format.
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
     * Retrieve the count of the LoanDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the LoanDetails.
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
     * Returns the associated loanApplications for given LoanDetails id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated LoanApplication instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<LoanApplication> findAssociatedLoanApplications(Integer id, Pageable pageable);

}