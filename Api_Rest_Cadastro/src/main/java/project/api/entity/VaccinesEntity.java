package project.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VaccinesEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @JoinColumn(nullable = false)
	private Long id_vaccine;
	@Column(nullable = false)
	private String name_vaccine;
	@Column(nullable = false)
	private String date_vaccination;
	@ManyToOne @JoinColumn(name = "id_user")
	private UsersEntity users;
	
	public String getName_vaccine() {
		return name_vaccine;
	}
	public void setName_vaccine(String name_vaccine) {
		this.name_vaccine = name_vaccine;
	}
	public String getDate_vaccination() {
		return date_vaccination;
	}
	public void setDate_vaccination(String date_vaccination) {
		this.date_vaccination = date_vaccination;
	}
	public UsersEntity getUsers() {
		return users;
	}
	public void setUsers(UsersEntity users) {
		this.users = users;
	}
	
	public Long getId_vaccine() {
		return id_vaccine;
	}
	
}
