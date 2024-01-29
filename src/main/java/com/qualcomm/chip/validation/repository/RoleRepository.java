package com.qualcomm.chip.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qualcomm.chip.validation.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
