package com.syne.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venue_details")
public class VenueDetail {
	
	@Column(name ="IdentifierType")
	private String identifierType;
	
	@Id
	private Long shortCode;
	
	@Column(name ="LongCode")
	private String longCode;
	
	@Column(name ="EffectiveDate")
	private Date effectiveDate;
	
	public VenueDetail(Long shortCode, String longCode, String identifierType, Date effectiveDate) {
		this.shortCode = shortCode;
		this.longCode = longCode;
		this.identifierType = identifierType;
		this.effectiveDate = effectiveDate;
	}
	
	public VenueDetail() {
	}
	
	/**
	 * @return the shortCode
	 */
	public Long getShortCode() {
		return shortCode;
	}
	/**
	 * @param shortCode the shortCode to set
	 */
	public void setShortCode(Long shortCode) {
		this.shortCode = shortCode;
	}
	/**
	 * @return the longCode
	 */
	public String getLongCode() {
		return longCode;
	}
	/**
	 * @param longCode the longCode to set
	 */
	public void setLongCode(String longCode) {
		this.longCode = longCode;
	}
	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @return the identifierType
	 */
	public String getIdentifierType() {
		return identifierType;
	}
	/**
	 * @param identifierType the identifierType to set
	 */
	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}
	
	

}
