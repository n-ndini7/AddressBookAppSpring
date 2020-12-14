package com.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.dto.Address;
import com.dto.AddressBookDTO;
import com.dto.Contact;

import lombok.Data;

@Entity
@Table(name="address_book_user")
public @Data class AddressBookData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long id;
	private String firstName;
	private String lastName;
	@ElementCollection
    @CollectionTable(name = "user_addresses", joinColumns = @JoinColumn(name = "user_id"))
	private Set<Address> address;
	@ElementCollection
    @CollectionTable(name = "user_contacts", joinColumns = @JoinColumn(name = "user_id"))
	private Set<Contact> contact;

	public AddressBookData() {
		
	}
		public AddressBookData(AddressBookDTO addDto) {
		this.setFirstName(addDto.firstName);
		this.setLastName(addDto.lastName);
		this.setAddress(addDto.address);
		this.setContact(addDto.contact);
	}
}
