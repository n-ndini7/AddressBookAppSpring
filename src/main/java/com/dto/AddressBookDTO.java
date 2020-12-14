package com.dto;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {

	@NotEmpty(message="First Name cannot be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}",message="First Name Invalid")
	public String firstName;
	@NotEmpty(message="Last Name cannot be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}",message="Last Name Invalid")
	public String lastName;
	public Set<Address> address;
	public Set<Contact> contact;
	public AddressBookDTO() {
		
	}
	public AddressBookDTO(String firstName, String lastName, Set<Address> address, Set<Contact> contact) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.contact=contact;
	
	}
}
