package com.syne.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.syne.api.dao.VenueDetailsDAO;
import com.syne.api.exception.BlueprismServiceException;
import com.syne.api.model.VenueDetail;

@Component
public class VenueDetailsDAOImpl implements VenueDetailsDAO {
	
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public VenueDetail getVenueDetailsByShortCode(long shortCode) throws BlueprismServiceException {

		String sql = "SELECT * FROM syneschema.venue_details WHERE short_code = " + shortCode;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			VenueDetail venueDetail = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 venueDetail= new VenueDetail(
						rs.getLong("short_code"), 
						rs.getString("long_code"), 
						rs.getString("identifier_type"),
						rs.getDate("effective_date"));
			}
			rs.close();
			ps.close();
			return venueDetail;
		} catch (SQLException e) {
			throw new BlueprismServiceException("Failed to get venue details from database", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BlueprismServiceException("Failed to close database connection", e);
				}
			}
		}
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public VenueDetail getVenueDetails(long shortCode, String identifier, Date effectiveDate )
			throws BlueprismServiceException {
		
		StringBuilder sqlStat = new StringBuilder("SELECT * FROM syneschema.venue_details WHERE short_code = ? ");
		if(identifier != null && !identifier.isEmpty()) {
			sqlStat.append(" AND identifier_type = ? ");
		} if(effectiveDate != null) {
			sqlStat.append(" AND effective_date <=  ?");
		}
		
		String sql = sqlStat.toString();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, shortCode);
			if(identifier != null && !identifier.isEmpty()) {
				ps.setString(2, identifier);
			} if(effectiveDate != null) {
				DateFormat dateFormatYMD = new SimpleDateFormat("yyyy-MM-dd");
		        String vDateYMD = dateFormatYMD.format(effectiveDate);
				ps.setString(3, vDateYMD);
			}
			VenueDetail venueDetail = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 venueDetail= new VenueDetail(
						 rs.getLong("short_code"), 
							rs.getString("long_code"), 
							rs.getString("identifier_type"),
							rs.getDate("effective_date"));
			}
			rs.close();
			ps.close();
			return venueDetail;
		} catch (SQLException e) {
			throw new BlueprismServiceException("Failed to get venue details from database", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BlueprismServiceException("Failed to close database connection", e);
				}
			}
		}
	}
}
