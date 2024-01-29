package com.qualcomm.chip.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qualcomm.chip.validation.model.Directory;
import com.qualcomm.chip.validation.repository.DirectoryRepository;

@Service
@Transactional
public class DirectoryService {
	
	@Autowired
	private DirectoryRepository repo;

	public DirectoryService(DirectoryRepository repo) {
		this.repo = repo;
	}
	
	public List<Directory> listAll() {
		return repo.findAll();
	}
	
	public Directory get(Integer id) {
		return repo.findById(id).get();
	}
	
	public Directory save(Directory directory) {
		return repo.save(directory);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Directory updateChipType(String chiptype, Integer id) {
		repo.updateChipType(chiptype, id);
		return repo.findById(id).get();
	}
}
