package com.tenoch.warrantysafe.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tenoch.warrantysafe.core.repositories.entities.User;

/**
 * This repositore provide access to the user repository
 * @author dventura
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface IUserRepository extends MongoRepository<User, String> {

	/**
	 * This method return an user if exist
	 * @param userName user name to find
	 * @return User with username Parameter
	 */
	User findByUserName(String userName);
	

	/**
	 * This method return an user if exist
	 * @param email user email to find
	 * @return User with email parameter
	 */
	User findByEmail(String email);
	
}
