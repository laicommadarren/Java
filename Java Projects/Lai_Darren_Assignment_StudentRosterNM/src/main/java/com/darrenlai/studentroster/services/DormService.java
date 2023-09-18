package com.darrenlai.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darrenlai.studentroster.models.Dorm;
import com.darrenlai.studentroster.repositories.DormRepository;

@Service
public class DormService {
	@Autowired
	private DormRepository dormRepository;
	
	public List<Dorm> allDorms() {
		return dormRepository.findAll();
	}
	
	public Dorm createDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormRepository.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		}
		else return null;
	}
}
