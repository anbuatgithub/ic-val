package com.qualcomm.chip.validation.config;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.qualcomm.chip.validation.IcValidationApiApplication;
import com.qualcomm.chip.validation.model.Role;
import com.qualcomm.chip.validation.model.User;
import com.qualcomm.chip.validation.repository.RoleRepository;
import com.qualcomm.chip.validation.repository.UserRepository;

@Configuration
public class DatabaseConifg {
	
	Logger logger = LoggerFactory.getLogger(DatabaseConifg.class);

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Bean
	public CommandLineRunner loadData(RoleRepository repo) {
	    return (args) -> {
	    	Role admin = new Role("ROLE_ADMIN");
			Role editor = new Role("ROLE_EDITOR");
			Role customer = new Role("ROLE_CUSTOMER");
			
			roleRepository.saveAll(List.of(admin, editor, customer));
			
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
			String password = passwordEncoder.encode("pass@123");
			User user1 = new User("anbu@qc.com", password);
			user1.addRole(admin);
			user1.addRole(editor);
			
			User user2 = new User("thomas@qc.com", password);
			user2.addRole(admin);
			
			User user3 = new User("benjamin@qc.com", password);
			user3.addRole(editor);
			
			User user4 = new User("abdullah@qc.com", password);
			user4.addRole(customer);
			
			List<User> users = userRepository.saveAll(Arrays.asList(user1,user2,user3,user4));
			
			logger.info("Sample database initialized with {} users" , users.size());
	    };
	}
	
}
