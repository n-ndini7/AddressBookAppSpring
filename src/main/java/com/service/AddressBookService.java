package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.AddressBookDTO;
import com.dto.ResponseDTO;
import com.exceptions.AddressBookException;
import com.model.AddressBookData;
import com.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

	String status = null;
	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public ResponseDTO getAddressBookDataById(long id) {
		AddressBookData adbkData = addressBookRepository.findById(id).get();
		if (adbkData.getFirstName() != null) {
			status = "Get Call Success or Employee Payroll ID : " + id;
			return new ResponseDTO(status, adbkData);
		} else {
			throw new AddressBookException("Contact Not Found in AddressBook");
		}
	}

	@Override
	public ResponseDTO createAddressBookData(AddressBookDTO addDto) {
		AddressBookData adbkData = new AddressBookData(addDto);
		log.debug("User Data: ",adbkData.toString());
		addressBookRepository.save(adbkData);
		status = "Created User Data in Address Book Successfully";
		return new ResponseDTO(status, adbkData);
	}

	@Override
	public ResponseDTO updateAddressBookData(long id, AddressBookDTO addDto) {
		AddressBookData adbkData = addressBookRepository.findById(id).get();
		if(adbkData.getId()==id) {
			adbkData.setFirstName(addDto.firstName);
			adbkData.setLastName(addDto.lastName);
			adbkData.setAddress(addDto.address);
			adbkData.setContact(addDto.contact);
			addressBookRepository.save(adbkData);
			status = "Updated User Data Successfully";
			return new ResponseDTO(status, adbkData);
		}
		else
		{
			throw new AddressBookException("Contact Not Found in AddressBook");
		}
	}

	@Override
	public ResponseDTO deleteAddressBookDataById(long id) {
		AddressBookData adbkData = addressBookRepository.findById(id).get();
		if (adbkData.getFirstName() != null) {
			addressBookRepository.deleteById(adbkData.getId());
			status = "Deleted Successfully, Deleted ID:" + id;
			return new ResponseDTO(status);
		} else {
			throw new AddressBookException("Contact Not Found in AddressBook");
		}
	}
}