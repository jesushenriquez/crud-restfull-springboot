/**
 * 
 */
package com.jesushenriquez.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jesushenriquez.demo.model.User;
import com.jesushenriquez.demo.repository.UserRepository;

/**
 * @author jesushenriquez
 *
 */
@Service
@Transactional(readOnly = true)
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public User create(User user) {
		return this.userRepository.save(user);
	}
	
	@Transactional
	public User update(User user) {
		return this.userRepository.save(user);
	}
	
	@Transactional
	public void delete(User user) {
		this.userRepository.delete(user);
	}
	
	public User findById(int id) {
		return this.userRepository.findById(id);
	}
	
	public List<User> findAll(){
		return this.userRepository.findAll();
	}

}
