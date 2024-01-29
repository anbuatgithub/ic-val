package com.qualcomm.chip.validation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import com.qualcomm.chip.validation.model.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	
	@Autowired 
	private RoleRepository repo;
	
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
	public void testCreateRoles() {
		Role admin = new Role("ROLE_ADMIN");
		Role customer = new Role("ROLE_CUSTOMER");
		repo.saveAll(List.of(admin, customer));
		
		long count = repo.count();
		assertEquals(2, count);
	}
	
	
}
