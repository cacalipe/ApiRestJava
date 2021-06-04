package project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.api.entity.UsersEntity;
import project.api.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository user_repository;
	
	@Autowired
	public UserService (UserRepository user_repository) {
		this.user_repository = user_repository;
	}
	
	
	public UsersEntity save(UsersEntity user) {
		return user_repository.save(user);
	}
	
	public List<UsersEntity> findAll(UsersEntity user) {
		return user_repository.findAll();
	}
	
	public UsersEntity findById(Long id_user) {
		return user_repository.findById(id_user).get();
	}
		
	public String removeById(Long id_user) {
		user_repository.deleteById(id_user);
		return "User registration removed! ID: " + id_user;
	}
	
	public String removeAll() {
		user_repository.deleteAll();
		return "All user registration removed! ";
	}
	
	public UsersEntity update(UsersEntity user) {
		UsersEntity userExisting = user_repository.findById(user.getId_user()).get();
		userExisting.setName_user(user.getName_user());
		userExisting.setEmail_user(user.getEmail_user());
		userExisting.setCpf_user(user.getCpf_user());
		userExisting.setBirth_date_user(user.getBirth_date_user());
		return user_repository.save(userExisting);
	}
}
