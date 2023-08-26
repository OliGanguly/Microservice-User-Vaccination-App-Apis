package com.projectbyoli.Vaccinationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectbyoli.Vaccinationservice.entity.VaccinationCenter;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer>{
//	public void data();
}
