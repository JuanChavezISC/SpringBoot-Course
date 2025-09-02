package com.restfulapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfulapi.entity.Local;
import com.restfulapi.repository.ILocalRepository;

@Service
public class LocalServiceImpl implements ILocalService{


	@Autowired
	ILocalRepository localRepository;


	@Override
	public List<Local> findAllLocals() {
		return localRepository.findAll();
	}
	
	@Override
	public Local saveLocal(Local local) {
		return localRepository.save(local);
	}
	
	@Override
	public Local updateLocal(Long id, Local local) {
		
		Local localDb = localRepository.findById(id).get();
		// Indica que el objeto no tiene que ser nulo y que no envie informacion vacia
		if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
			localDb.setCode(local.getCode());
		}
		
		if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
			localDb.setFloor(local.getFloor());
		}
		
		if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
			localDb.setName(local.getName());
		}
		
		
		return localRepository.save(localDb);
	}
	
	@Override
	public void deleteLocal(Long id) {		
		localRepository.deleteById(id);
	}

	
	@Override
	public Optional<Local> findLocalByNameWithJPQL(String name) {
		return localRepository.findLocalByNameWithJPQL(name);
	}

	@Override
	public Optional<Local> findByName(String name) {
		return localRepository.findByName(name);
	}

	@Override
	public Optional<Local> findByNameIgnoreCase(String name) {
		
		return localRepository.findByNameIgnoreCase(name);
	}
}
