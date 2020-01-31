package com.syne.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.syne.api.exception.BlueprismServiceException;
import com.syne.api.model.VenueDetail;
import com.syne.api.service.VenueDetailsService;

@Controller
public class VenueDetailsController {

//	private static final String DATE_FORMAT = "dd-MMM-yyyy";
	@Autowired
	VenueDetailsService venueDetailsService;

    @RequestMapping(value = "/venuedetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VenueDetail> getVenueDetailsByShortCode(@RequestParam("shortCode") String shortCode) 
			throws NumberFormatException, BlueprismServiceException {
    	VenueDetail entity = venueDetailsService.getVenueDetailsByShortCode(Long.parseLong(shortCode));
		return new ResponseEntity<VenueDetail>(entity, new HttpHeaders(), HttpStatus.OK);
	}
    
    @RequestMapping(value = "/venuedetailsearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VenueDetail> getVenueDetails(@RequestParam("shortCode") String shortCode,
			@RequestParam("identifier") String identifier,
			@RequestParam("effectiveDate") 
			@DateTimeFormat(pattern="yyyy-dd-MM") Date effectiveDate) 
			throws NumberFormatException, BlueprismServiceException {
    	VenueDetail entity = venueDetailsService.getVenueDetails(Long.parseLong(shortCode), identifier, effectiveDate);
		return new ResponseEntity<VenueDetail>(entity, new HttpHeaders(), HttpStatus.OK);
	}

}
