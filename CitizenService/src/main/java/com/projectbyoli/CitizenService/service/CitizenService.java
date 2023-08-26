package com.projectbyoli.CitizenService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectbyoli.CitizenService.entity.Citizen;
import com.projectbyoli.CitizenService.repo.CitizenRepo;

@Service
public class CitizenService {
	@Autowired
	private CitizenRepo repo;
	
	public List<Citizen> getByDeptId(int id){
		return repo.findByVaccinationCenterId(id);
		
	}
	public Citizen addCitizen(Citizen citizen) {
		return repo.save(citizen);
	}

}
