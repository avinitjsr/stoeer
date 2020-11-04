package com.de.stroeer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.de.stroeer.model.Users;
import com.de.stroeer.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
    UserService service;
	
	@GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> list = service.getAllUsers();
 
        return new ResponseEntity<List<Users>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	@GetMapping("/{iban}")
    public ResponseEntity<Users> getUsersByIban(@PathVariable("iban") Long iban) 
                                                    throws Exception {
        Users entity = service.getUserDetails(iban);
 
        return new ResponseEntity<Users>(entity, new HttpHeaders(), HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<Users> createOrUpdateEmployee(Users users)
                                                    throws Exception {
        Users updated = service.createOrUpdateUsers(users);
        return new ResponseEntity<Users>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{iban}")
    public HttpStatus deleteUsersByIban(@PathVariable("iban") Long iban) 
                                                    throws Exception {
        service.deleteUsersByIban(iban);
        return HttpStatus.FORBIDDEN;
    }
}
