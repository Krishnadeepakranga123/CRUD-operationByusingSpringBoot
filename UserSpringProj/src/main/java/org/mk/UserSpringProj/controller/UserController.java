package org.mk.UserSpringProj.controller;

import java.util.List;

import org.mk.UserSpringProj.dto.ResponseStructure;
import org.mk.UserSpringProj.dto.User;
import org.mk.UserSpringProj.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	public UserServices service;
	@PostMapping(value="/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@PutMapping(value="/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	
	@GetMapping(value="/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id){
		return service.findUserById(id);
	}
	
	@GetMapping(value="/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers(){
		return service.findAllUsers();
	}
	@DeleteMapping(value="/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id){
		return service.deleteUser(id);
	}
	@PostMapping(value="/users/verifybyphone")
	public ResponseEntity<ResponseStructure<User>> verifyUserPhone(@RequestParam long phone,@RequestParam String password){
		return service.verifyUser(phone, password);
	}
	@PostMapping(value="/users/verifybyemail")
	public ResponseEntity<ResponseStructure<User>> verifyByEmail(@RequestParam String email,@RequestParam String password){
		return service.verifyUser(email, password);
	}
	@PostMapping(value="/users/verifybyid")
	public ResponseEntity<ResponseStructure<User>> verifyById(@RequestParam int id,@RequestParam String password){
		return service.verifyUser(id, password);
	}
	@PostMapping(value="/users/findbyname")
	public ResponseEntity<ResponseStructure<List<User>>> findByName(@RequestParam String name){
		return service.findByName(name);
	}
}
