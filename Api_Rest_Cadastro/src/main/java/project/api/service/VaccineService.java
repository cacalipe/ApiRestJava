package project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.api.entity.UsersEntity;
import project.api.entity.VaccinesEntity;
import project.api.repository.UserRepository;
import project.api.repository.VaccineRepository;

@Service
public class VaccineService {
	
	private final VaccineRepository vaccine_repository;
	private final UserRepository user_repository;
	
	@Autowired
	public VaccineService (VaccineRepository vaccine_repository, UserRepository user_repository) {
		this.vaccine_repository = vaccine_repository;
		this.user_repository = user_repository;
	}
	
	public VaccinesEntity save(VaccinesEntity vaccine, Long id_user) {
		UsersEntity user = user_repository.findById(id_user).get();
		vaccine.setUsers(user);
		return vaccine_repository.save(vaccine);
	}
	
	public List<VaccinesEntity> findAll(VaccinesEntity vaccine) {
		return vaccine_repository.findAll();
	}
	
	public VaccinesEntity findById(Long id_vaccine) {
		return vaccine_repository.findById(id_vaccine).get();
	}
		
	public String removeById(Long id_vaccine) {
		vaccine_repository.deleteById(id_vaccine);
		return "Vaccine registration removed! ID: " + id_vaccine;
	}
	
	public String removeAll() {
		vaccine_repository.deleteAll();
		return "All vaccines registration removed! ";
	}
	
	public VaccinesEntity update(VaccinesEntity vaccine) {
		VaccinesEntity vaccineExisting = vaccine_repository.findById(vaccine.getId_vaccine()).get();
		vaccineExisting.setName_vaccine(vaccine.getName_vaccine());
		vaccineExisting.setDate_vaccination(vaccine.getDate_vaccination());
		return vaccine_repository.save(vaccineExisting);
	}
	
}




