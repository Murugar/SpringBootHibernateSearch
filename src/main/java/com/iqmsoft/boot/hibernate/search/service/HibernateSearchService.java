package com.iqmsoft.boot.hibernate.search.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iqmsoft.boot.hibernate.search.model.Employee;

import ch.qos.logback.classic.Logger;

@Service
public class HibernateSearchService  {

	private final Logger logger = (Logger) LoggerFactory.getLogger(HibernateSearchService.class);

	private final EntityManager entityManager;


	@Autowired
	public HibernateSearchService(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	public void initializeHibernateSearch() {

		try {
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Transactional
	public List<Employee> fuzzySearch(String searchTerm){

		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Employee.class).get();
		Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1)
				.withPrefixLength(1).onFields("firstname", "lastname")
				.matching(searchTerm).createQuery();

		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Employee.class);

		// execute search

		List<Employee> employeeList = null;
		try {
			employeeList  = jpaQuery.getResultList();
		} catch (NoResultException nre) {
			logger.warn("No result found");

		}

		return employeeList;

	
	}
}
