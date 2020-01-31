package com.syne.api.service;

import java.util.Date;

import com.syne.api.exception.BlueprismServiceException;
import com.syne.api.model.VenueDetail;

public interface VenueDetailsService {
	public VenueDetail getVenueDetailsByShortCode(long shortCode) throws BlueprismServiceException;
	public VenueDetail getVenueDetails(long shortCode, String identifier, Date effectiveDate ) 
			throws BlueprismServiceException;
}
