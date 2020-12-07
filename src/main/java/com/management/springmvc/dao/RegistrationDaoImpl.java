package com.management.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.management.springmvc.model.Registration;

@Repository
public class RegistrationDaoImpl extends AbstractDao<Integer, Registration> implements RegistrationDao {

	@Override
	public void saveUser(Registration registration) {
		persist(registration);
		
	}

	@Override
	public List<Registration> getAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<Registration>)criteria.list();
	}

}
