package com.projectbyoli.Vaccinationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.projectbyoli.Vaccinationservice.entity.VaccinationCenter;
import com.projectbyoli.Vaccinationservice.model.Citizen;
import com.projectbyoli.Vaccinationservice.model.CombinePojo;
import com.projectbyoli.Vaccinationservice.repo.CenterRepo;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

	@Autowired
	private CenterRepo repo;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> add(@RequestBody VaccinationCenter vaccinationCenter) {
		
		VaccinationCenter savedDataCenter = repo.save(vaccinationCenter);
		
		return new ResponseEntity<VaccinationCenter>(savedDataCenter,HttpStatus.CREATED);
	}
	
	//But I want list of user under one vaccination center
	@GetMapping("/id/{id}")
	public ResponseEntity<CombinePojo> listofUsersInAVaccinationCenter(@PathVariable Integer id){
		 CombinePojo combinePojo = new CombinePojo();
		 //1st get vaccination center details
		  VaccinationCenter center = repo.findById(id).get();
		  combinePojo.setCenter(center);
		 //get all the citizen under the vaccination
		 List<Citizen> listOfCitizen= restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		 combinePojo.setCitizens(listOfCitizen);
		return new ResponseEntity<CombinePojo>(combinePojo ,HttpStatus.OK);
	}
}
