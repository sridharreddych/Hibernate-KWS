package org.sree.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import oracle.sql.TIMESTAMP;

@Entity
@Table (name="USER_DETAILS") //IMPORT FROM PERSISTENCE 
public class UserDetails {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	//@Basic
	//@Transient
	private String username;
		
	@Embedded 
	@AttributeOverrides({
	@AttributeOverride (name="street",column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride (name="city",column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride (name="state",column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride (name="pincode",column=@Column(name="HOME_PIN_CODE")),
	})
	private Address homeAddress;
	
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Embedded
	private Address officeAddress;
	
	@Temporal (TemporalType.DATE)
	/*private Date joinedDate; //import date from java.util 
	
	private String Description;
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Lob
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
