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

class EquipmentTest {

private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Equipment equipment;

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
		equipment = em.find(Equipment.class, "123456789");
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		equipment = null;
	}

	@Test
	void test_equipment_mapping() {
		assertNotNull(equipment);
		assertEquals("123456789", equipment.getSerialNumber());
		assertEquals("hvac123", equipment.getModelNumber());
		assertEquals("furnace", equipment.getType());
		assertEquals("oil", equipment.getFuelType());
	}

}
