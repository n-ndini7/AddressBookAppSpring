package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.AddressBookDTO;
import com.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	AddressBookData addBookData = null;
	private List<AddressBookData> addList = new ArrayList<>();
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int id) {
		return addList.get(id-1);
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addDto) {
		addBookData = new AddressBookData(addList.size()+1, addDto);
		addList.add(addBookData);
		return addBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int Id , AddressBookDTO addDto) {
		addBookData = this.getAddressBookDataById(Id);
		addBookData.setFirstName(addDto.getFirstName());
		addBookData.setLastName(addDto.getLastName());
		addBookData.setAddress(addDto.getAddress());
		addBookData.setState(addDto.getState());
		addBookData.setCity(addDto.getCity());
		addBookData.setZip(addDto.getZip());
		addBookData.setPhoneNo(addDto.getPhoneNo());
		addBookData.setEmail(addDto.getEmail());
		addList.set(Id-1, addBookData);
		return addBookData;
	}

	@Override
	public void deleteAddressBookDataById(int id) {

		addList.remove(id-1);
	}

}