package com.management.springmvc.dao;

import java.util.List;

import com.management.springmvc.model.Registration;

public interface RegistrationDao {
	
	public void saveUser(Registration registration);
	public List<Registration> getAllUsers();
}
