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

import com.wavemaker.loancorpv2.loancorpv2.LoginDetails;

/**
 * Service object for domain model class {@link LoginDetails}.
 */
public interface LoginDetailsService {

    /**
     * Creates a new LoginDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LoginDetails if any.
     *
     * @param loginDetails Details of the LoginDetails to be created; value cannot be null.
     * @return The newly created LoginDetails.
     */
    LoginDetails create(@Valid LoginDetails loginDetails);


	/**
     * Returns LoginDetails by given id if exists.
     *
     * @param logindetailsId The id of the LoginDetails to get; value cannot be null.
     * @return LoginDetails associated with the given logindetailsId.
	 * @throws EntityNotFoundException If no LoginDetails is found.
     */
    LoginDetails getById(Integer logindetailsId);

    /**
     * Find and return the LoginDetails by given id if exists, returns null otherwise.
     *
     * @param logindetailsId The id of the LoginDetails to get; value cannot be null.
     * @return LoginDetails associated with the given logindetailsId.
     */
    LoginDetails findById(Integer logindetailsId);

	/**
     * Find and return the list of LoginDetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param logindetailsIds The id's of the LoginDetails to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return LoginDetails associated with the given logindetailsIds.
     */
    List<LoginDetails> findByMultipleIds(List<Integer> logindetailsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing LoginDetails. It replaces all fields of the existing LoginDetails with the given loginDetails.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LoginDetails if any.
     *
     * @param loginDetails The details of the LoginDetails to be updated; value cannot be null.
     * @return The updated LoginDetails.
     * @throws EntityNotFoundException if no LoginDetails is found with given input.
     */
    LoginDetails update(@Valid LoginDetails loginDetails);


    /**
     * Partially updates the details of an existing LoginDetails. It updates only the
     * fields of the existing LoginDetails which are passed in the loginDetailsPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on LoginDetails if any.
     *
     * @param logindetailsId The id of the LoginDetails to be deleted; value cannot be null.
     * @param loginDetailsPatch The partial data of LoginDetails which is supposed to be updated; value cannot be null.
     * @return The updated LoginDetails.
     * @throws EntityNotFoundException if no LoginDetails is found with given input.
     */
    LoginDetails partialUpdate(Integer logindetailsId, Map<String, Object> loginDetailsPatch);

    /**
     * Deletes an existing LoginDetails with the given id.
     *
     * @param logindetailsId The id of the LoginDetails to be deleted; value cannot be null.
     * @return The deleted LoginDetails.
     * @throws EntityNotFoundException if no LoginDetails found with the given id.
     */
    LoginDetails delete(Integer logindetailsId);

    /**
     * Deletes an existing LoginDetails with the given object.
     *
     * @param loginDetails The instance of the LoginDetails to be deleted; value cannot be null.
     */
    void delete(LoginDetails loginDetails);

    /**
     * Find all LoginDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LoginDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<LoginDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all LoginDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching LoginDetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<LoginDetails> findAll(String query, Pageable pageable);

    /**
     * Exports all LoginDetails matching the given input query to the given exportType format.
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
     * Exports all LoginDetails matching the given input query to the given exportType format.
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
     * Retrieve the count of the LoginDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the LoginDetails.
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


}
