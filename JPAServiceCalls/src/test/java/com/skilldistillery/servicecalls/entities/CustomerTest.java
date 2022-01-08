package com.skilldistillery.servicecalls.entities;

import static org.junit.jupiter.api.Assertions.*;

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
	
	private Customer cust;

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
		cust = em.find(Customer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cust = null;
	}

	@Test
	void test_customer_mapping() {
		assertNotNull(cust);
		assertEquals("John", cust.getFirstName());
		assertEquals("Doe", cust.getLastName());
		assertEquals("1231231111", cust.getPhoneNumber());
	}
	
	@Test
	void test_customer_to_service_calls_mapping() {
		assertNotNull(cust);
		assertNotNull(cust.getServiceCalls());
		assertTrue(cust.getServiceCalls().size() > 0);
	}
	
	@Test
	void test_customer_to_address_mapping() {
		assertNotNull(cust);
		assertNotNull(cust.getAddresses());
		assertTrue(cust.getAddresses().size() > 0);
	}

}
