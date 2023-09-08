package com.darrenlai.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darrenlai.dojosninjas.models.Ninja;
import com.darrenlai.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepo;
	
	public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else return null;
	
	}
	
}