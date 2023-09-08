package com.darrenlai.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darrenlai.dojosninjas.models.Dojo;
import com.darrenlai.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepo;
	
	public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else return null;
	}
	
}