package com.service;

import java.util.List;

import com.dto.AddressBookDTO;
import com.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(long id);

	AddressBookData createAddressBookData(AddressBookDTO addDto);

	AddressBookData updateAddressBookData(AddressBookDTO addDto);

	void deleteAddressBookDataById(long id);
}
