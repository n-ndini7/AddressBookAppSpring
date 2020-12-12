package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AddressBookDTO;
import com.dto.ResponseDTO;
import com.model.AddressBookData;
import com.service.IAddressBookService;

@RestController
public class AddressBookAppController {

	@Autowired
	private IAddressBookService addressBookService;

	AddressBookData addData = null;
	ResponseDTO responsedto = null;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addList = null;
		addList = addressBookService.getAddressBookData();
		responsedto = new ResponseDTO("Get Call Successfull", addList);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("Id") long Id) {
		addData = addressBookService.getAddressBookDataById(Id);
		responsedto = new ResponseDTO("Get Call for ID Successfull", addData);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addDto) {
		addData = addressBookService.createAddressBookData(addDto);
		responsedto = new ResponseDTO("Created Address Book Data Successfully", addData);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addDto) {
		addData = addressBookService.updateAddressBookData(addDto);
		responsedto = new ResponseDTO("Updated Address Book Data Successfully", addData);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("Id") long Id) {
		addressBookService.deleteAddressBookDataById(Id);
		responsedto = new ResponseDTO("Deleted Successfully, Deleted ID:" + Id);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

}