package com.controller;

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

@RestController
public class AddressBookAppController {

	AddressBookData addData = null;
	ResponseDTO responsedto = null;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		addData = new AddressBookData(1, new AddressBookDTO("Pankaj", "Tripathi", "Civil lines", "MP", "Indore",
				"121212", "+91 9898989898", "pankajT@gmail.com"));
		responsedto = new ResponseDTO("Get Call Successfull", addData);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("Id") long Id) {
		addData = new AddressBookData(1, new AddressBookDTO("Pankaj", "Tripathi", "Civil lines", "MP", "Indore",
				"121212", "+91 9898989898", "pankajT@gmail.com"));
		responsedto = new ResponseDTO("Get Call for ID Successfull",addData);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addDto) {
		addData = new AddressBookData(4,addDto);
		responsedto = new ResponseDTO("Created Address Book Data Successfully",addData);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addDto) {
		addData = new AddressBookData(4,addDto);
		responsedto = new ResponseDTO("Created Address Book Data Successfully",addData);
		return new ResponseEntity<ResponseDTO>(responsedto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("Id") long Id) {
		responsedto = new ResponseDTO("Deleted Successfully, Deleted ID:"+Id);
		return new ResponseEntity<ResponseDTO>(responsedto,HttpStatus.OK);
	}

}