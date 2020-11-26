package com.hotchtechnology.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotchtechnology.logic.PersonDao;
import com.hotchtechnology.model.PersonModel;

@RestController
@RequestMapping(value = "/personApi")
public class PersonController {
	@Autowired
	private PersonDao dao;
	
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addPerson(@RequestBody PersonModel model){
		
		if(dao.personCreate(model))
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
	}

	@PostMapping(value = "/update")
	public ResponseEntity<?> updatePerson(@RequestBody PersonModel model){
		
		if(dao.personUpdate(model))
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
	}
	@GetMapping(value = "/delete")
	public ResponseEntity<?> deletePerson(@PathParam("personId") String personId){
		
		if(dao.personDelete(Integer.parseInt(personId)))
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
	}
	@GetMapping(value = "/getAllRecord")
	public ResponseEntity<?> getAllPerson(){
		List<PersonModel>list=new ArrayList<>();
		 list=dao.getAllRecord();
		if(list.isEmpty())
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		else
			return new ResponseEntity<List<PersonModel>>(list,HttpStatus.OK);
	}
	
}
