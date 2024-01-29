package com.qualcomm.chip.validation.api;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qualcomm.chip.validation.model.Directory;
import com.qualcomm.chip.validation.service.DirectoryService;

@RestController
@RequestMapping("/directories")
public class DirectoryApi {
	
	Logger logger = LoggerFactory.getLogger(DirectoryApi.class);

	@Autowired
	private DirectoryService service;

	@PostMapping
	@RolesAllowed("ROLE_ADMIN")
	public HttpEntity<Directory> create(@RequestBody Directory directory) {
		Directory savedDirectory = service.save(directory);
		return new ResponseEntity<>(savedDirectory, HttpStatus.CREATED);		
	}
	
	@PutMapping
	@RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
	public HttpEntity<Directory> replace(@RequestBody Directory directory) {
		Directory updatedDirectory = service.save(directory);	
		return new ResponseEntity<>(updatedDirectory, HttpStatus.OK);		
	} 
	
	@PatchMapping("/{id}/chiptype/{chiptype}")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR"})
	public HttpEntity<Directory> updateChipType(@PathVariable("id") Integer id,
			@PathVariable("chiptype")String chiptype) {
		Directory updatedDirectory = service.updateChipType(chiptype, id);		
		return new ResponseEntity<>(updatedDirectory, HttpStatus.OK);	
	}	

	@GetMapping
	@RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR","ROLE_CUSTOMER"})
	public HttpEntity<List<Directory>> getAll() {
		List<Directory> directories = service.listAll();
		logger.info("response with {} directories", directories.size());  
		return new ResponseEntity<>(directories, HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_EDITOR","ROLE_CUSTOMER"})
	public HttpEntity<Directory> getOne(@PathVariable("id") Integer id) {
		Directory directory = service.get(id);
		return new ResponseEntity<>(directory, HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	@RolesAllowed({"ROLE_ADMIN"})
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
