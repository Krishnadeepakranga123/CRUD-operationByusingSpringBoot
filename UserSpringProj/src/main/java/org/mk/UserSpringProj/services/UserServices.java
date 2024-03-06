package org.mk.UserSpringProj.services;

import java.util.List;
import java.util.Optional;

import org.mk.UserSpringProj.dao.Userdao;
import org.mk.UserSpringProj.dto.ResponseStructure;
import org.mk.UserSpringProj.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	@Autowired
	public Userdao userdao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> structure=new ResponseStructure<>() ;
		structure.setData(userdao.saveUser(user));
		structure.setMessage("User Saved Successfully");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>> (structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setData(userdao.updateUser(user));
		structure.setMessage("User upadted successfully");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<User>> findUserById(int id){
		Optional<User> dbuser=userdao.findById(id);
		ResponseStructure<User> structure=new ResponseStructure<>();
		if(dbuser.isPresent()) {
			structure.setData(dbuser.get());
			structure.setMessage("USer found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
		}
		structure.setData(dbuser.get());
		structure.setMessage("user not found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers(){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setData(userdao.findAll());
		structure.setMessage("List of all users");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<User> dBuser=userdao.findById(id);
		if(dBuser.isPresent()) {
			userdao.delete(id);
			structure.setData("User Found");
			structure.setMessage("User deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			return new  ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);		
		}
		structure.setData("user not found");
		structure.setMessage("user not deleted");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> dbUser=userdao.verifyUser(phone, password);
		if(dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("User Found and Verified");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("Invalid Phone Or password");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> dbuser=userdao.verifyUser(email, password);
		if(dbuser.isPresent()) {
			structure.setData(dbuser.get());
			structure.setMessage("User found and verified");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("Invalid Email or password");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(int id,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> dbuser=userdao.verifyUser(id, password);
		if(dbuser.isPresent()) {
			structure.setData(dbuser.get());
			structure.setMessage("User found and verified");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("Invalid id or password");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findByName(String name){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		Optional<List<User>> dbuser=userdao.findByName(name);
		if(dbuser.isPresent()) {
			structure.setData(dbuser.get());
			structure.setMessage("user Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
		}
		structure.setData(null);
		structure.setMessage("user not found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.NOT_FOUND);
	}
}
