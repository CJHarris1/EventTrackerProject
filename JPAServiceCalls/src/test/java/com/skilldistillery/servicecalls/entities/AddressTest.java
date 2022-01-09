package com.skilldistillery.servicecalls.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressTest {

	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Address address;

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
		address = em.find(Address.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		address = null;
	}

	@Test
	void test_address_mapping() {
		assertNotNull(address);
		assertEquals("62 Fake St.", address.getAddress());
		assertEquals("Hanover", address.getCity());
		assertEquals("PA", address.getStateAbbv());
	}
	
	@Test
	void test_address_to_service_call_mapping() {
		assertNotNull(address);
		assertNotNull(address.getServiceCalls());
		assertTrue(address.getServiceCalls().size() > 0);
	}
	
	@Test
	void test_address_to_equipment_mapping() {
		assertNotNull(address);
		assertNotNull(address.getEquipment());
		assertTrue(address.getEquipment().size() > 0);
	}

}
