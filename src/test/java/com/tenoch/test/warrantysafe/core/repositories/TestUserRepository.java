package com.tenoch.test.warrantysafe.core.repositories;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tenoch.WarrantySafeApplication;
import com.tenoch.warrantysafe.core.repositories.IUserRepository;
import com.tenoch.warrantysafe.core.repositories.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WarrantySafeApplication.class)
public class TestUserRepository {
	
	private User userOne, userTwo;
	
	public TestUserRepository() {
		initUsers();
	}

	@Autowired
	IUserRepository repository;
	
	@Test
	public void testAddUser() {
		
		deleteIfExist();
		
		Set<String> insertedIds = new HashSet<String>();
		
		User result = repository.save(userOne);
		Assert.assertNotNull(result.getId());
		insertedIds.add(result.getId());
		initUsers();
		//It should not save the same user again
		try {
			result = repository.save(userOne);
			Assert.assertTrue(false);
		} catch ( DuplicateKeyException e ) {
			Assert.assertTrue(true);			
		}
		
		try {
			userOne.setEmail("test-user-one-no-repeat@tenochsoftware.net");
			result = repository.save(userOne);
			Assert.assertTrue(false);
		} catch ( DuplicateKeyException e ) {
			Assert.assertTrue(true);			
		}
		
		try {
			userOne.setUserName("testUserOne");
			result = repository.save(userOne);
			Assert.assertTrue(false);
		} catch ( DuplicateKeyException e ) {
			Assert.assertTrue(true);			
		}

		System.out.println(userOne);
		userOne.setFirstName("noRepeated");
		result = repository.save(userOne);
		Assert.assertNotNull(result.getId());
		insertedIds.add(result.getId());			
		
		result = repository.save(userTwo);
		Assert.assertNotNull(result.getId());
		insertedIds.add(result.getId());
		testQuery();
		insertedIds.forEach( insertedId -> repository.delete(insertedId) );
	}	
	
	private void deleteIfExist() {
		
		User[] toDelete = {
				repository.findByEmail(userOne.getEmail()),
				repository.findByEmail(userTwo.getEmail()),
				repository.findByEmail("test-user-one-no-repeat@tenochsoftware.net")
		};
		
		for ( User u : toDelete) 
			if (u != null ) 
				repository.delete(u);
		
	}

	@Test
	public void testQuery () {
		
		repository.findAll().forEach( u -> System.out.println(u));
		
	}	

	@Test
	public void testFind() {
		
		initUsers();
		
		repository.save(userOne);
		repository.save(userTwo);
		
		User result;
		result = repository.findByUserName(userOne.getUserName());
		Assert.assertEquals(result.getUserName(), userOne.getUserName());
		
		result = repository.findByUserName(userTwo.getUserName());
		Assert.assertEquals(result.getUserName(), userTwo.getUserName());
		

		result = repository.findByEmail(userOne.getEmail());
		Assert.assertEquals(result.getEmail(), userOne.getEmail());
		
		result = repository.findByEmail(userTwo.getEmail());
		Assert.assertEquals(result.getEmail(), userTwo.getEmail());

		repository.delete(repository.findByEmail(userOne.getEmail()));
		repository.delete(repository.findByEmail(userTwo.getEmail()));
		
	}


	@Test
	public void testDelete() {
		
		initUsers();
		
		repository.save(userOne);
		repository.save(userTwo);

		repository.delete(repository.findByEmail(userOne.getEmail()));
		repository.delete(repository.findByEmail(userTwo.getEmail()));
		
		Assert.assertTrue(true);		
		
	}

	
	private void initUsers() {

		this.userOne = new User();
		
		this.userOne.setEmail("test-user-one@tenochsoftware.net");
		this.userOne.setUserName("testUser");
		this.userOne.setFirstName("testUser");
		this.userOne.setLastName("One");

		this.userTwo = new User();
		
		this.userTwo.setEmail("test-user-two@tenochsoftware.net");
		this.userTwo.setUserName("testUserTwo");
		this.userTwo.setFirstName("testUser");
		this.userTwo.setLastName("Two");		
		
	}
	
}
