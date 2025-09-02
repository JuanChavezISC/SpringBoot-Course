package com.restfulapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restfulapi.entity.Local;


public interface ILocalRepository extends JpaRepository<Local, Long>{

	// Consulta con JPQL
	
	@Query("SELECT l FROM Local l WHERE l.name = :name")
	Optional<Local>findLocalByNameWithJPQL(String name);
	
	//Consulta con inversion de Control
	Optional<Local> findByName(String name);
	
	//Consulta para encontrar ignorando mayusculas o minusculas
	Optional<Local>findByNameIgnoreCase(String name);
}
