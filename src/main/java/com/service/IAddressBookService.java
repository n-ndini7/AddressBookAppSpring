package com.service;

import java.util.List;

import com.dto.AddressBookDTO;
import com.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(int id);

	AddressBookData createAddressBookData(AddressBookDTO addDto);

	void deleteAddressBookDataById(int id);

	AddressBookData updateAddressBookData(int Id, AddressBookDTO addDto);
}
