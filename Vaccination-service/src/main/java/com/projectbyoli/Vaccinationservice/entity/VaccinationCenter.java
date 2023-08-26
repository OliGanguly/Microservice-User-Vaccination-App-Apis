package com.projectbyoli.Vaccinationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VaccinationCenter {
	
	@Id
	private int id;
	private String v_name;
	private String v_address;

}
