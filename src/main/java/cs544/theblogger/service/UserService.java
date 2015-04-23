/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.User;
import cs544.theblogger.repository.UserRepository;

/**
 *
 * @author jeankahigiso
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService{
    
	@Autowired
    private UserRepository userRepository;
	private static final Logger log = Logger.getLogger(UserService.class.getName());
	

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User create(User user) {	
		return userRepository.save(user);
	}

	public User find(long id) {
		return userRepository.findOne(id);
	}
   
    
}
