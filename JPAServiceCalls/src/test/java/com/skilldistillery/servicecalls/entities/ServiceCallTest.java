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

class ServiceCallTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private ServiceCall call;

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
		call = em.find(ServiceCall.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		call = null;
	}

	@Test
	void test_service_call_mapping() {
		assertNotNull(call);
		assertEquals("No heat", call.getDescription());
		assertEquals(2022, call.getDateScheduled().getYear());
		assertEquals(01, call.getDateScheduled().getMonthValue());
		assertEquals(02, call.getDateScheduled().getDayOfMonth());
		assertEquals(2022, call.getDateCalled().getYear());
		assertEquals(01, call.getDateCalled().getMonthValue());
		assertEquals(01, call.getDateCalled().getDayOfMonth());
	}
}
