package com.skilldistillery.servicecalls.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Customer customer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAServiceCalls");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		customer = em.find(Customer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		customer = null;
	}

	@Test
	void test_customer_mapping() {
		assertNotNull(customer);
		assertEquals("CJ", customer.getFname());
		assertEquals("Harris", customer.getLname());
		assertEquals("62 Fake st", customer.getAddress());
		
	}

}
