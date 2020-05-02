package com.emusicstore.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ShippingAddress")
public class ShippingAddress {

	@Id
	@GeneratedValue()
	public int id;
	public String street;
	public String town;
	public String county;
	public String areaCode;
	public String country;
	
	public ShippingAddress() {

	}

	public ShippingAddress(String street, String town, String county, String areaCode, String country) {
		super();
		this.street = street;
		this.town = town;
		this.county = county;
		this.areaCode = areaCode;
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
}
