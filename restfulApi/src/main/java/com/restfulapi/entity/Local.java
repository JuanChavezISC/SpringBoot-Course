package com.restfulapi.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "local")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // Permite usar el patron de diseño builder
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Please add the name")
	private String name;
	private String floor;
	@Length(min = 4, max = 10)
	private String code;
}
