package project.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class UsersEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @JoinColumn(nullable = false)
	private Long id_user;
	@Column(nullable = false)
	private String name_user;
	@Column(nullable = false, unique = true)
	private String email_user;
	@Column(nullable = false, unique = true)
	private String cpf_user;
	@Column(nullable = false)
	private String birth_date_user;
	
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	public String getCpf_user() {
		return cpf_user;
	}
	public void setCpf_user(String cpf_user) {
		this.cpf_user = cpf_user;
	}
	public String getBirth_date_user() {
		return birth_date_user;
	}
	public void setBirth_date_user(String birth_date_user) {
		this.birth_date_user = birth_date_user;
	}
		
}
