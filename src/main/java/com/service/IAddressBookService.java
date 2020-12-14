package com.service;

import java.util.List;

import com.dto.AddressBookDTO;
import com.dto.ResponseDTO;
import com.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	ResponseDTO getAddressBookDataById(long id);

	ResponseDTO createAddressBookData(AddressBookDTO addDto);

	ResponseDTO deleteAddressBookDataById(long id);

	ResponseDTO updateAddressBookData(long Id, AddressBookDTO addDto);
}
