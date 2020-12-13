package com.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AddressBookDTO {

	@NotEmpty(message="First Name cannot be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}",message="First Name Invalid")
	private String firstName;
	@NotEmpty(message="Last Name cannot be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}",message="Last Name Invalid")
	private String lastName;
	@NotEmpty(message="Address cannot be empty")
	private String address;
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]+",message="City Invalid")
	private String city;
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]+",message="State Invalid")
	private String state;
	@Pattern(regexp="^[0-9]{6}",message="ZIP Invalid")
	private String zip;
	@Pattern(regexp="[0-9]{2}[\\s][7-9]{1}[0-9]{9}",message="Phone no. Invalid")
	private String phoneNo;
	@Pattern(regexp="^[a-zA-Z0-9+_-]+([.][a-zA-Z0-9]+)*@([a-zA-Z0-9]+)([.][a-z]+)?[.][a-z]{2,}$",message="Email ID Invalid")
	private String email;

	public AddressBookDTO(String firstName, String lastName, String address, String state, String city, String zip,
			String phoneNo, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setState(state);
		this.setCity(city);
		this.setZip(zip);
		this.setPhoneNo(phoneNo);
		this.setEmail(email);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "firstName : " + firstName + " ,lastName : " + lastName + " ,address : " + address + " ,state : " + state
				+ " ,city : " + city + " ,zip : " + zip + " ,phoneNo : " + phoneNo + " ,email : " + email;
	}

	
}
