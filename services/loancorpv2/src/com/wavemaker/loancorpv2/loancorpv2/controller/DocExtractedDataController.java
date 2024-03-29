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

import com.wavemaker.loancorpv2.loancorpv2.DocExtractedData;
import com.wavemaker.loancorpv2.loancorpv2.service.DocExtractedDataService;


/**
 * Controller object for domain model class DocExtractedData.
 * @see DocExtractedData
 */
@RestController("loancorpv2.DocExtractedDataController")
@Api(value = "DocExtractedDataController", description = "Exposes APIs to work with DocExtractedData resource.")
@RequestMapping("/loancorpv2/DocExtractedData")
public class DocExtractedDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocExtractedDataController.class);

    @Autowired
	@Qualifier("loancorpv2.DocExtractedDataService")
	private DocExtractedDataService docExtractedDataService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new DocExtractedData instance.")
    @PostMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DocExtractedData createDocExtractedData(@RequestBody DocExtractedData docExtractedData) {
		LOGGER.debug("Create DocExtractedData with information: {}" , docExtractedData);

		docExtractedData = docExtractedDataService.create(docExtractedData);
		LOGGER.debug("Created DocExtractedData with information: {}" , docExtractedData);

	    return docExtractedData;
	}

    @ApiOperation(value = "Returns the DocExtractedData instance associated with the given id.")
    @GetMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DocExtractedData getDocExtractedData(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting DocExtractedData with id: {}" , id);

        DocExtractedData foundDocExtractedData = docExtractedDataService.getById(id);
        LOGGER.debug("DocExtractedData details with id: {}" , foundDocExtractedData);

        return foundDocExtractedData;
    }

    @ApiOperation(value = "Updates the DocExtractedData instance associated with the given id.")
    @PutMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DocExtractedData editDocExtractedData(@PathVariable("id") Integer id, @RequestBody DocExtractedData docExtractedData) {
        LOGGER.debug("Editing DocExtractedData with id: {}" , docExtractedData.getId());

        docExtractedData.setId(id);
        docExtractedData = docExtractedDataService.update(docExtractedData);
        LOGGER.debug("DocExtractedData details with id: {}" , docExtractedData);

        return docExtractedData;
    }
    
    @ApiOperation(value = "Partially updates the DocExtractedData instance associated with the given id.")
    @PatchMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DocExtractedData patchDocExtractedData(@PathVariable("id") Integer id, @RequestBody @MapTo(DocExtractedData.class) Map<String, Object> docExtractedDataPatch) {
        LOGGER.debug("Partially updating DocExtractedData with id: {}" , id);

        DocExtractedData docExtractedData = docExtractedDataService.partialUpdate(id, docExtractedDataPatch);
        LOGGER.debug("DocExtractedData details after partial update: {}" , docExtractedData);

        return docExtractedData;
    }

    @ApiOperation(value = "Deletes the DocExtractedData instance associated with the given id.")
    @DeleteMapping(value = "/{id:.+}")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDocExtractedData(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting DocExtractedData with id: {}" , id);

        DocExtractedData deletedDocExtractedData = docExtractedDataService.delete(id);

        return deletedDocExtractedData != null;
    }

    /**
     * @deprecated Use {@link #findDocExtractedDatas(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DocExtractedData instances matching the search criteria.")
    @PostMapping(value = "/search")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DocExtractedData> searchDocExtractedDatasByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DocExtractedDatas list by query filter:{}", (Object) queryFilters);
        return docExtractedDataService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DocExtractedData instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @GetMapping
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DocExtractedData> findDocExtractedDatas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DocExtractedDatas list by filter:", query);
        return docExtractedDataService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DocExtractedData instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @PostMapping(value="/filter", consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DocExtractedData> filterDocExtractedDatas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DocExtractedDatas list by filter", query);
        return docExtractedDataService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @GetMapping(value = "/export/{exportType}", produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDocExtractedDatas(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return docExtractedDataService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @PostMapping(value = "/export", consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportDocExtractedDatasAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = DocExtractedData.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> docExtractedDataService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of DocExtractedData instances matching the optional query (q) request param.")
	@GetMapping(value = "/count")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countDocExtractedDatas( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DocExtractedDatas");
		return docExtractedDataService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@PostMapping(value = "/aggregations")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getDocExtractedDataAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return docExtractedDataService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DocExtractedDataService instance
	 */
	protected void setDocExtractedDataService(DocExtractedDataService service) {
		this.docExtractedDataService = service;
	}

}
