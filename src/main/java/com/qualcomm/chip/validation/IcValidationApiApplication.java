package com.qualcomm.chip.validation;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.qualcomm.chip.validation.model.Role;
import com.qualcomm.chip.validation.model.User;
import com.qualcomm.chip.validation.repository.RoleRepository;
import com.qualcomm.chip.validation.repository.UserRepository;

@SpringBootApplication
public class IcValidationApiApplication {
	
	Logger logger = LoggerFactory.getLogger(IcValidationApiApplication.class);
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;


	public static void main(String[] args) {
		SpringApplication.run(IcValidationApiApplication.class, args);
	}
	
	
	
	

}
