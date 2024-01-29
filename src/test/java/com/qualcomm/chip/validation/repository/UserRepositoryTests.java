package com.qualcomm.chip.validation.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.qualcomm.chip.validation.model.Role;
import com.qualcomm.chip.validation.model.User;
import com.qualcomm.chip.validation.repository.RoleRepository;
import com.qualcomm.chip.validation.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired private UserRepository userRepo;
	
	@Autowired private RoleRepository roleRepo;
	
	
	@Test
	public void testAssignRoleToUser() {
		
		Role role = new Role("SAMPLE ROLE");
		role = roleRepo.save(role);
		
		Integer roleId = 3;
		User user = userRepo.findById(1).get();
		user.addRole(role);
			
		User updatedUser = userRepo.save(user);
		
		assertThat(updatedUser.getRoles()).hasSize(1);
		userRepo.delete(updatedUser);
		roleRepo.delete(role);
		
	}
}
