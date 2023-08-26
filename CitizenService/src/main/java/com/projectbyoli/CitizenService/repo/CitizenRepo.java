package com.projectbyoli.CitizenService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectbyoli.CitizenService.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

	public List<Citizen> findByVaccinationCenterId(Integer id);
}
