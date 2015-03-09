package com.api.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.dto.JobDTO;
import com.api.dto.PageDTO;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
public class Search {
	

	/**
	 * Look for any job
	 */
	private static final String FIND_BY_ALL = "NOFILTER";

	/**
	 * Look for a list of jobs under a specific city.
	 */
	private static final String FIND_BY_CITY = "CITY";

	/**
	 * Look for a list of jobs under a specific category.
	 */
	private static final String FIND_BY_CATEGORY = "CATEGORY";
	
	/**
	 * Look for a list of jobs under a specific keyword.
	 */
	private static final String FIND_BY_KEYWORD = "KEYWORD";
	
	/**
	 * Look for a list of jobs under a specific company.
	 */
	private static final String FIND_BY_COMPANY = "COMPANY";
	
	/**
	 * Look for a list of jobs under a specific id.
	 */
	private static final String FIND_BY_ID = "ID";
	
	/**
	 * Allowed findBy filter expose to the API documentation
	 */
	private static final String ALLOWED_FINDBY = FIND_BY_ALL + "," + FIND_BY_CITY
			+ "," + FIND_BY_CATEGORY + "," + FIND_BY_KEYWORD
			+ "," + FIND_BY_COMPANY + "," + FIND_BY_ID;
	
	@ResponseBody
	@ApiOperation(value = "Get all the job postings by keyword", response = JobDTO.class, httpMethod = "GET", notes = "")
    @RequestMapping(value = "/search/keyword/{keyword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PageDTO<JobDTO> getJobByKeyword(@PathVariable("keyword") String keyword,
            							@ApiParam(value = "page number", defaultValue = "0") @RequestParam(value = "pn", required = false, defaultValue = "0") Integer page,
            							@ApiParam(value = "page size", defaultValue = "20") @RequestParam(value = "ps", required = false, defaultValue = "20") Integer pageSize){
		JobDTO jobDTO = new JobDTO();
		jobDTO.setCreated(new Date());
		jobDTO.setDescription("Description One");
		jobDTO.setTitle("Title One");
		List<JobDTO> jobs = new ArrayList<JobDTO>();
		jobs.add(jobDTO);
		PageDTO<JobDTO> pageDTO = new PageDTO(1, 10, 10, (long) 100, jobs);
		return pageDTO;
	}
	
	@ResponseBody
    @ApiOperation(value = "Get all the job postings by category", response = JobDTO.class, httpMethod = "GET", notes = "")
    @RequestMapping(value = "/search/category/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public PageDTO<JobDTO> getJobByCategory(@PathVariable("category") String category,
			@ApiParam(value = "page number", defaultValue = "0") @RequestParam(value = "pn", required = false, defaultValue = "0") Integer page,
			@ApiParam(value = "page size", defaultValue = "20") @RequestParam(value = "ps", required = false, defaultValue = "20") Integer pageSize){
		JobDTO jobDTO = new JobDTO();
		jobDTO.setCreated(new Date());
		jobDTO.setDescription("Description One");
		jobDTO.setTitle("Title One");
		List<JobDTO> jobs = new ArrayList<JobDTO>();
		jobs.add(jobDTO);
		PageDTO<JobDTO> pageDTO = new PageDTO(1, 10, 10, (long) 100, jobs);
		return pageDTO;
	}
	
	@ResponseBody
    @ApiOperation(value = "Get job details", response = JobDTO.class, httpMethod = "GET", notes = "")
    @RequestMapping(value = "/search/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public JobDTO getJobDetails(@PathVariable("id") String id){
		JobDTO job = new JobDTO();
		return new JobDTO();
	}
	
    @ResponseBody
    @ApiOperation(value = "Fetch a list of jobs based on filtering criteria", response = JobDTO.class, responseContainer = "List", httpMethod = "GET", notes = "Used the parameter 'filter' to add restriction on your search.")
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)    
    public PageDTO<JobDTO> getAffiliateList(
            @ApiParam(value = "Find By", allowableValues = Search.ALLOWED_FINDBY, defaultValue = Search.FIND_BY_ALL) 
            	@RequestParam(value = "filter", required = false, defaultValue = "0") String findBy,
            @ApiParam(value = "Filter Value", defaultValue = "") 
            	@RequestParam(value = "filtervalue", required = false, defaultValue = "0") String findValue,
            @ApiParam(value = "page number", defaultValue = "0") 
            	@RequestParam(value = "pn", required = false, defaultValue = "0") Integer page,
            @ApiParam(value = "page size", defaultValue = "20") 
            	@RequestParam(value = "ps", required = false, defaultValue = "20") Integer pageSize) {
		JobDTO jobDTO = new JobDTO();
		jobDTO.setCreated(new Date());
		jobDTO.setDescription("Description One");
		jobDTO.setTitle("Title One");
		List<JobDTO> jobs = new ArrayList<JobDTO>();
		jobs.add(jobDTO);
		PageDTO<JobDTO> pageDTO = new PageDTO(1, 10, 10, (long) 100, jobs);
		return pageDTO;
    }
}
