package com.tenoch.warrantysafe.core.repositories.entities;

import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class User extends BaseEntity {

	@Indexed( unique = true )	
	private String userName;
	
	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private Set<Integer> warrantiesShared;

	private static final String STATIC_SALT = "WattantySageSt4t1cSalt";
	
	public User() {
		this.password = new ShaPasswordEncoder(256).encodePassword(password, STATIC_SALT);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		if (password == null) {
			setPassword(KeyGenerators.string().generateKey());
		}
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Integer> getWarrantiesShared() {
		return warrantiesShared;
	}

	public void setWarrantiesShared(Set<Integer> warrantiesShared) {
		this.warrantiesShared = warrantiesShared;
	}

}
