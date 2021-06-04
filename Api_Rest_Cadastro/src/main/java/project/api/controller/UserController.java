package project.api.controller;

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

import project.api.entity.UsersEntity;
import project.api.service.UserService;

@RestController @RequestMapping("/users")
public class UserController {
	
	private final UserService user_service;

	@Autowired
	public UserController (UserService user_service) {
		this.user_service = user_service;
	}
	
	@PostMapping
	public ResponseEntity<UsersEntity> save(@RequestBody UsersEntity users){
		UsersEntity user = user_service.save(users);
		return new ResponseEntity<UsersEntity>(user, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/list")
	public List<UsersEntity> findAll(@RequestBody UsersEntity users){
		List<UsersEntity> user = user_service.findAll(users);
		return user;
	}
	
	@GetMapping(value = "/list/{id_user}")
	public UsersEntity findById(@PathVariable Long id_user){
		UsersEntity user = user_service.findById(id_user);
		return user;
	}
	
	@DeleteMapping(value = "/remove/{id_user}")
	public String removeById(@PathVariable Long id_user) {
		String delete_user_id = user_service.removeById(id_user);
		return delete_user_id;
	}
	
	@DeleteMapping(value = "/remove")
	public String removeById() {
		String delete_all_user = user_service.removeAll();
		return delete_all_user;
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<UsersEntity> update(@RequestBody UsersEntity users){
		UsersEntity user = user_service.update(users);
		return new ResponseEntity<UsersEntity>(user, HttpStatus.ACCEPTED);
	}
}
