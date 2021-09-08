package io.bigobject.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.bigobject.demo.bean.Company;
import io.bigobject.demo.bean.User;
import io.bigobject.demo.dao.CompanyRepository;
import io.bigobject.demo.dao.UserRepository;
import lombok.extern.apachecommons.CommonsLog;

@Service
public class IndexService {
	@Autowired UserRepository userRepository;
	@Autowired CompanyRepository companyRepository;
	
	@Transactional(propagation=Propagation.NEVER)
	public void addUser() {
		Optional<Company> c = companyRepository.findById("C01");
		User u = new User();
		u.setId(UUID.randomUUID().toString());
		u.setUsername("Test_" + u.getId());
		u.setCompany(c.get());
		userRepository.save(u);
	}
	@Transactional(propagation=Propagation.NEVER)
	public List<User> queryUsers(){
		return userRepository.findByCompanyId("C01");
		
	}
	
	@Transactional(propagation=Propagation.NEVER)
	public List<User> queryUsersByNativeSql(){
		return userRepository.findByCompanyIdUsingNativeSql("C01");
		
	}
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Transactional(propagation=Propagation.NEVER)
	public List<Object[]> list(String sql) {
		Query q = entityManager.createNativeQuery(sql);
		List<Object[]> list = q.getResultList();
		return list;
	}
}
