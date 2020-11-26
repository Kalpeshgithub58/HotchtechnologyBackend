package com.hotchtechnology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotchtechnology.loicImp.LoginDaoImp;
import com.hotchtechnology.model.UserModel;

@RestController
@RequestMapping("/Login")
@CrossOrigin("http://localhost:3000")
public class LoginController {
	

	@Autowired
	LoginDaoImp daoImp;
	
	
@PostMapping(value = "/CheckUser",consumes = "application/json")
	public ResponseEntity<?>checkValidUser(@RequestBody UserModel model){
	   if(daoImp.checkvaliduser(model)) {
		   return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	   }else {
		   return new ResponseEntity<Boolean>(false,HttpStatus.OK);
	   }
	 
	}
	
	
	
	
}
