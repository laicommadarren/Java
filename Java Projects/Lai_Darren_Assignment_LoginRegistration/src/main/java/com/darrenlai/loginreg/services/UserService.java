package com.darrenlai.loginreg.services;

import java.util.Optional;
    
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
    
import com.darrenlai.loginreg.controllers.*;
import com.darrenlai.loginreg.models.LoginUser;
import com.darrenlai.loginreg.models.User;
import com.darrenlai.loginreg.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Unique", "The email already exists in database");
    	}
    	
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "Confirm Password and Password do not match!");
    	}
        // Return null if result has errors
    	if(result.hasErrors()) {
    	    // Exit the method and go back to the controller 
    	    // to handle the response
    	    return null;
    	    }
        // Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	// TO-DO - Reject values:
    	
    	// Find user in the DB by email
        // Reject if NOT present
    	Optional<User> user = userRepo.findByEmail(newLoginObject.getEmail());
    	if(!user.isPresent()) {
    		result.rejectValue("email", "NoMatch", "The email does not exist in database");
    		return null;
    	}
        User currentUser = user.get();
        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLoginObject.getPassword(), currentUser.getPassword())) {
            result.rejectValue("password", "PasswordMatch", "Invalid Password!");
        }
    		
        // Return null if result has errors
    	if (result.hasErrors()) {
    		return null;
    	}
        // Otherwise, return the user object
        return currentUser;
    }
}