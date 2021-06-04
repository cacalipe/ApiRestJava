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

import project.api.entity.VaccinesEntity;
import project.api.service.VaccineService;

@RestController @RequestMapping("/vaccines")
public class VaccineController {

	private final VaccineService vaccine_service;
	
	@Autowired
	public VaccineController (VaccineService vaccine_service) {
		this.vaccine_service = vaccine_service;
	}
	
	@PostMapping(value = "/{id_user}")
	public ResponseEntity<VaccinesEntity> save (@RequestBody VaccinesEntity vaccines, @PathVariable Long id_user ){
		VaccinesEntity vaccine = vaccine_service.save(vaccines, id_user);
		return new ResponseEntity<VaccinesEntity>(vaccine, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/list")
	public List<VaccinesEntity> findAll (@RequestBody VaccinesEntity vaccines){
		List<VaccinesEntity> vaccine = vaccine_service.findAll(vaccines);
		return vaccine;
	}
	
	@GetMapping(value = "/list/{id_vaccine}")
	public VaccinesEntity findById (@PathVariable Long id_vaccine){
		VaccinesEntity vaccine = vaccine_service.findById(id_vaccine);
		return vaccine;
	}
		
	@DeleteMapping(value = "/remove/{id_vaccine}")
	public String removeById (@PathVariable Long id_vaccine){
		String delete_vaccine_id = vaccine_service.removeById(id_vaccine);
		return delete_vaccine_id;
	}
	
	@DeleteMapping(value = "/remove")
	public String remove (){
		String delete_all_vaccine = vaccine_service.removeAll();
		return delete_all_vaccine;
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<VaccinesEntity> update (@RequestBody VaccinesEntity vaccine){
		VaccinesEntity vaccines = vaccine_service.update(vaccine);
		return new ResponseEntity<VaccinesEntity>(vaccines, HttpStatus.ACCEPTED);
	}
	
}











