package com.darrenlai.burgers.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.darrenlai.burgers.models.Burger;
import com.darrenlai.burgers.repositories.*;
@Service
public class BurgerService {
    // adding the Burger repository as a dependency
    private final BurgerRepository BurgerRepository;
    
    public BurgerService(BurgerRepository BurgerRepository) {
        this.BurgerRepository = BurgerRepository;
    }
    public List<Burger> allBurgers() {
        return BurgerRepository.findAll();
    }
    // creates a Burger
    public Burger createBurger(Burger b) {
        return BurgerRepository.save(b);
    }
    // retrieves a Burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = BurgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    public Burger updateBurger(Burger b) {
    	return BurgerRepository.save(b);
    }
}

