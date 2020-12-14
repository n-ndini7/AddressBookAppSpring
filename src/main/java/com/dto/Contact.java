package com.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
public class Contact {

	@NotEmpty(message="phone no cannot be empty")
	@Pattern(regexp="[0-9]{2}[\\s][7-9]{1}[0-9]{9}",message="Phone no. Invalid")
	public String phoneNo;
	@NotEmpty(message="email cannot be empty")
	@Column(unique=true)
	@Email
	@Size(max=100)
	public String email;
	public Contact() {
		
	}
	public Contact(String phoneno , String email) {
		this.phoneNo=phoneno;
		this.email=email;
	}
}
