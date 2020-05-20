/**
 * 
 */
package com.jesushenriquez.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesushenriquez.demo.model.User;

/**
 * @author jesushenriquez
 *
 */
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findById(int id);

}
