package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.AddressBookDTO;
import com.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	AddressBookData addBookData = null;

	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> addList = new ArrayList<>();
		addList.add(new AddressBookData(1, new AddressBookDTO("Pankaj", "Tripathi", "Civil lines", "MP", "Indore",
				"121212", "+91 9898989898", "pankajT@gmail.com")));
		return addList;
	}

	@Override
	public AddressBookData getAddressBookDataById(long id) {
		addBookData = new AddressBookData(1, new AddressBookDTO("Pankaj", "Tripathi", "Civil lines", "MP", "Indore",
				"121212", "+91 9898989898", "pankajT@gmail.com"));
		return addBookData;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addDto) {
		addBookData = new AddressBookData(2, addDto);
		return addBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(AddressBookDTO addDto) {
		addBookData = new AddressBookData(2, addDto);
		return addBookData;
	}

	@Override
	public void deleteAddressBookDataById(long id) {

	}

}
