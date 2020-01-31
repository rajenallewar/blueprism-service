package com.syne.api.dao;

import java.util.Date;

import com.syne.api.exception.BlueprismServiceException;
import com.syne.api.model.VenueDetail;

public interface VenueDetailsDAO {
	public VenueDetail getVenueDetailsByShortCode(long shortCode) throws BlueprismServiceException;
	public VenueDetail getVenueDetails(long shortCode, String identifier, Date effectiveDate ) 
			throws BlueprismServiceException;
}
