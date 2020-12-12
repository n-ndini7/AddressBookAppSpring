package com.model;

import com.dto.AddressBookDTO;

public class AddressBookData {

	private long id;
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phoneNo;
	public String email;
	
	public AddressBookData(long id , AddressBookDTO addDto) {
		this.id=id;
		this.firstName = addDto.getFirstName();
		this.lastName = addDto.getLastName();
		this.address = addDto.getAddress();
		this.state = addDto.getState();
		this.city = addDto.getCity();
		this.zip = addDto.getZip();
		this.phoneNo = addDto.getPhoneNo();
		this.email = addDto.getEmail();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
