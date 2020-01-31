package com.syne.api.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syne.api.dao.VenueDetailsDAO;
import com.syne.api.dao.VenueDetailsRepository;
import com.syne.api.exception.BlueprismServiceException;
import com.syne.api.model.VenueDetail;
import com.syne.api.service.VenueDetailsService;

@Service
public class VenueDetailsServiceImpl implements VenueDetailsService {
	
	@Autowired
	VenueDetailsDAO venueDetailsDao;
	
	@Autowired
	VenueDetailsRepository repository;
	
	@Override
	public VenueDetail getVenueDetailsByShortCode(long shortCode) throws BlueprismServiceException {
		VenueDetail venueDetail = venueDetailsDao.getVenueDetailsByShortCode(shortCode);
		return venueDetail;
	}
	
	@Override
	public VenueDetail getVenueDetails(long shortCode, String identifier, Date effectiveDate ) 
			throws BlueprismServiceException {
		VenueDetail venueDetail = venueDetailsDao.getVenueDetails(shortCode, identifier, effectiveDate);
		return venueDetail;
	}
	
}
