package com.iqmsoft.boot.hibernate.search;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iqmsoft.boot.hibernate.search.model.Employee;
import com.iqmsoft.boot.hibernate.search.service.HibernateSearchService;

import ch.qos.logback.classic.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHibernateSearchAppTests {
	private final Logger logger = (Logger) LoggerFactory.getLogger(SpringBootHibernateSearchAppTests.class);


	@Autowired
	HibernateSearchService service;
	
	@Test
	public void searchSingleTerm() {
		List<Employee> result =service.fuzzySearch("Muntz");
		logger.debug("Found " + result.size() + " employees");
		assert(result.size()>0);
		
		for(Employee emp : result){
			logger.debug("Id: "+ emp.getEmployee_id() + " " + emp.getFirstname() + " " + emp.getLastname() );
		}
	}

}
