package com.restfulapi.service;

import java.util.List;
import java.util.Optional;

import com.restfulapi.entity.Local;
import com.restfulapi.error.LocalNotFoundException;

public interface ILocalService {

	List<Local> findAllLocals();
	Local saveLocal(Local local);
	Local updateLocal(Long id, Local local);
	void deleteLocal(Long id);
	Optional<Local> findLocalByNameWithJPQL(String name);
	Optional<Local> findByName(String name);
	Optional<Local> findByNameIgnoreCase(String name);
	Local findLocalById(Long id) throws LocalNotFoundException;
}
