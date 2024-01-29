package com.qualcomm.chip.validation.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qualcomm.chip.validation.model.Directory;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Integer> {

	@Query("UPDATE Directory d SET d.chipType = ?1 WHERE d.id = ?2")
	@Modifying
	@Transactional
	public void updateChipType(String chipType, Integer id);
	
}
