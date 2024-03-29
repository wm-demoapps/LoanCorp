/*Copyright (c) 2020-2021 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.wavemaker.loancorpv2.loancorpv2.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.commons.file.manager.ExportedFileManager;
import com.wavemaker.runtime.commons.file.model.Downloadable;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.wavemaker.loancorpv2.loancorpv2.LoanApplication;
import com.wavemaker.loancorpv2.loancorpv2.LoanDetails;
import com.wavemaker.loancorpv2.loancorpv2.service.LoanDetailsService;


/**
 * Controller object for domain model class LoanDetails.
 * @see LoanDetails
 */
@RestController("loancorpv2.LoanDetailsController")
@Api(value = "LoanDetailsController", description = "Exposes APIs to work with LoanDetails resource.")
@RequestMapping("/loancorpv2/LoanDetails")
public class LoanDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanDetailsController.class);

    @Autowired
	@Qualifier("loancorpv2.LoanDetailsService")
	private LoanDetailsService loanDetailsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new LoanDetails instance.")
    @PostMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LoanDetails createLoanDetails(@RequestBody LoanDetails loanDetails) {
		LOGGER.debug("Create LoanDetails with information: {}" , loanDetails);

		loanDetails = loanDetailsService.create(loanDetails);
		LOGGER.debug("Created LoanDetails with information: {}" , loanDetails);

	    return loanDetails;
	}

    @ApiOperation(value = "Returns the LoanDetails instance associated with the given id.")
    @GetMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LoanDetails getLoanDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting LoanDetails with id: {}" , id);

        LoanDetails foundLoanDetails = loanDetailsService.getById(id);
        LOGGER.debug("LoanDetails details with id: {}" , foundLoanDetails);

        return foundLoanDetails;
    }

    @ApiOperation(value = "Updates the LoanDetails instance associated with the given id.")
    @PutMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LoanDetails editLoanDetails(@PathVariable("id") Integer id, @RequestBody LoanDetails loanDetails) {
        LOGGER.debug("Editing LoanDetails with id: {}" , loanDetails.getId());

        loanDetails.setId(id);
        loanDetails = loanDetailsService.update(loanDetails);
        LOGGER.debug("LoanDetails details with id: {}" , loanDetails);

        return loanDetails;
    }
    
    @ApiOperation(value = "Partially updates the LoanDetails instance associated with the given id.")
    @PatchMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LoanDetails patchLoanDetails(@PathVariable("id") Integer id, @RequestBody @MapTo(LoanDetails.class) Map<String, Object> loanDetailsPatch) {
        LOGGER.debug("Partially updating LoanDetails with id: {}" , id);

        LoanDetails loanDetails = loanDetailsService.partialUpdate(id, loanDetailsPatch);
        LOGGER.debug("LoanDetails details after partial update: {}" , loanDetails);

        return loanDetails;
    }

    @ApiOperation(value = "Deletes the LoanDetails instance associated with the given id.")
    @DeleteMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLoanDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting LoanDetails with id: {}" , id);

        LoanDetails deletedLoanDetails = loanDetailsService.delete(id);

        return deletedLoanDetails != null;
    }

    /**
     * @deprecated Use {@link #findLoanDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of LoanDetails instances matching the search criteria.")
    @PostMapping(value = "/search")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LoanDetails> searchLoanDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering LoanDetails list by query filter:{}", (Object) queryFilters);
        return loanDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LoanDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @GetMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LoanDetails> findLoanDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LoanDetails list by filter:", query);
        return loanDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LoanDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @PostMapping(value="/filter", consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LoanDetails> filterLoanDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LoanDetails list by filter", query);
        return loanDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @GetMapping(value = "/export/{exportType}", produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportLoanDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return loanDetailsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @PostMapping(value = "/export", consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportLoanDetailsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = LoanDetails.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> loanDetailsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of LoanDetails instances matching the optional query (q) request param.")
	@GetMapping(value = "/count")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countLoanDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting LoanDetails");
		return loanDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@PostMapping(value = "/aggregations")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getLoanDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return loanDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }

    @GetMapping(value="/{id:.+}/loanApplications")
    @ApiOperation(value = "Gets the loanApplications instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LoanApplication> findAssociatedLoanApplications(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated loanApplications");
        return loanDetailsService.findAssociatedLoanApplications(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LoanDetailsService instance
	 */
	protected void setLoanDetailsService(LoanDetailsService service) {
		this.loanDetailsService = service;
	}

}
