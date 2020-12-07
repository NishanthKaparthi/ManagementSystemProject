package com.management.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.springmvc.dao.RegistrationDao;
import com.management.springmvc.model.Registration;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationDao registrationDao;
	
	public void saveUser(Registration registration) {
		registrationDao.saveUser(registration);
	}

	public List<Registration> getAllUsers() {
		List<Registration> reg = registrationDao.getAllUsers();
		return reg;
	}
}
