package com.management.springmvc.service;

import java.util.List;

import com.management.springmvc.model.Registration;

public interface RegistrationService {
	public void saveUser(Registration registration);
	public List<Registration> getAllUsers();
}
