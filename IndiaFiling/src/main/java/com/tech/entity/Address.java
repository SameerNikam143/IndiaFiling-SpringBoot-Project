package com.tech.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address {

	@NotBlank(message = "Village Must Not Be Blank")
	private String village;
	
	@NotBlank(message = "Taluka Must Not Be Blank")
	private String taluka;
	
	@NotBlank(message = "District Must Not Be Blank")
	private String district;

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
