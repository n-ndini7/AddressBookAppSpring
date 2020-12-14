package com.dto;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

	@NotEmpty(message="Address cannot be empty")
	@Size(max=100)
	public String address;
	@NotEmpty(message="City cannot be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]+",message="City Invalid")
	public String city;
	@NotEmpty(message="State cannot be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]+",message="State Invalid")
	public String state;
	@NotEmpty(message="ZIP cannot be empty")
	@Pattern(regexp="^[0-9]{6}",message="ZIP Invalid")
	public String zip;

	public Address() {
		
	}
	public Address(String address , String city , String state , String zip) {
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
}
