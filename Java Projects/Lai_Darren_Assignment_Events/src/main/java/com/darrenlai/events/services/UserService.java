package com.darrenlai.events.services;

import java.util.Optional;
    
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
    
import com.darrenlai.events.models.LoginUser;
import com.darrenlai.events.models.User;
import com.darrenlai.events.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Unique", "The email already exists in database");
    	}
    	
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "Confirm Password and Password do not match!");
    	}
    	
    	if(result.hasErrors()) return null;
    	
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {

    	Optional<User> user = userRepo.findByEmail(newLoginObject.getEmail());
    	User currentUser = user.get();
    	if(!user.isPresent()) {
    		result.rejectValue("email", "NoMatch", "The email does not exist in database");
    	}
        else if(!BCrypt.checkpw(newLoginObject.getPassword(), currentUser.getPassword())) {
            result.rejectValue("password", "PasswordMatch", "Invalid Password!");
        }

    	if (result.hasErrors()) {
    		return null;
    	}
        return currentUser;
    }
    public User findUser(Long id) {
    	return userRepo.findById(id).orElse(null);
//		Optional<User> optionalUser = userRepo.findById(id);
//		if(optionalUser.isPresent()) {
//			return optionalUser.get();
//		}
//		else return null;
	}
}
    