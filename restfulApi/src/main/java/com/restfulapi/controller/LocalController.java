package com.restfulapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfulapi.entity.Local;
import com.restfulapi.error.LocalNotFoundException;
import com.restfulapi.service.ILocalService;

@RestController
public class LocalController {

	
	@Autowired
	ILocalService localService;

    
    @GetMapping("/findLocalById/{id}")
    Local findLocalById(@PathVariable Long id) throws LocalNotFoundException{
    	return localService.findLocalById(id);
    }
    
    @GetMapping("/findByName/{name}")
    Optional<Local> findByName(@PathVariable String name){
    	return localService.findByName(name);
    }
    
    @GetMapping("/findLocalBynameWithJPQL/{name}")
    Optional<Local> findLocalByNameWithJPQL(@PathVariable String name){
    	return localService.findLocalByNameWithJPQL(name);
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    Optional<Local> findByNameIgnoreCase(@PathVariable String name){
    	return localService.findByNameIgnoreCase(name);
    }
    
	@GetMapping("/findAllLocals")
	public List<Local> findAllLocals() {
		return localService.findAllLocals();
	}
	
	@PostMapping("/saveLocal")
	public Local saveLocal(@RequestBody Local local) {
		return localService.saveLocal(local);
	}
	
	@PutMapping("/updateLocal/{id}")
	public Local updateLocal(@PathVariable Long id, @RequestBody Local local) {
		return localService.updateLocal(id, local);
	}
	
	@DeleteMapping("/deleteLocal/{id}")
	
	public String deleteLocal(@PathVariable Long id) {
		localService.deleteLocal(id);
		return "Succesfully delete";
	}
}
