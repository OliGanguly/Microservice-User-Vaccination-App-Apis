package com.projectbyoli.CitizenService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectbyoli.CitizenService.entity.Citizen;
import com.projectbyoli.CitizenService.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenService service;

	@PostMapping("/add")
	 public ResponseEntity<Citizen> addCitizen (@RequestBody Citizen citizen) {
		 Citizen data =  service.addCitizen(citizen);
		 return new ResponseEntity<Citizen>(data,HttpStatus.CREATED); 
	 }
	
	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>>findbYVaccination(@PathVariable("id") Integer id)
	{
		List<Citizen> dataCitizens =  service.getByDeptId(id);
		return new ResponseEntity<>(dataCitizens,HttpStatus.OK);
	}
}
