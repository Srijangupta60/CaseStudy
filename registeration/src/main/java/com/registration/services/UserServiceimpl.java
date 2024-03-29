package com.registration.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registration.exception.UserNotFoundException;
import com.registration.model.User;
import com.registration.repository.UserRepository;


@Service
public class UserServiceimpl implements UserServices {
	
	@Autowired
	private UserRepository csd;


	@Override
	public List<User> getUsers() {
		return csd.findAll();
	}

	@Override
	public User addUser(User cos) {
		
		return csd.save(cos);
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return csd.findByUsername(username);
	}

	@Override
	public User updateUser(String username, User updatedUser) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> existingUser = csd.findByUsername(username);
        if (!existingUser.isPresent()) {
            throw new UserNotFoundException("User Not found with "+ username);
        }
		updatedUser.setUsername(username);
        return csd.save(updatedUser);
	}

	@Override
	public void deleteUserByUsername(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		 Optional<User> existingProduct = csd.findByUsername(username);
	        if (!existingProduct.isPresent()) {
	            throw new UserNotFoundException("User Not found with "+ username);
	        }

	        csd.deleteByUsername(username);
	    }



}
