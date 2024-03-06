package org.mk.UserSpringProj.dao;

import java.util.List;
import java.util.Optional;

import org.mk.UserSpringProj.Repository.UserRepository;
import org.mk.UserSpringProj.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Userdao {
	@Autowired
	public UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}
	
	public Optional<User> findById(int id){
		return repository.findById(id);
	}
	
	public boolean delete(int id) {
		Optional<User> dbuser=findById(id);
		if(dbuser.isPresent()) {
			repository.delete(dbuser.get());
			return true;
		}
		return false;
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public Optional<User> verifyUser(long phone, String password){
		return repository.verifyUser(phone, password);
	}
	
	public Optional<User> verifyUser(String email,String password){
		return repository.verifyUser(email,password);
	}
	
	public Optional<User> verifyUser(int id,String password){
		return repository.verifyUser(id,password);
	}
	
	public Optional<List<User>> findByName(String name){
		return repository.findbyname(name);
	}
}
