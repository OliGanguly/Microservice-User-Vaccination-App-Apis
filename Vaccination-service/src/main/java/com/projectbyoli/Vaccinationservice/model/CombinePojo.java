package com.projectbyoli.Vaccinationservice.model;

import java.util.List;

import com.projectbyoli.Vaccinationservice.entity.VaccinationCenter;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//combined response

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombinePojo {
 
	private VaccinationCenter center;
	
	private List<Citizen> citizens ;
}
