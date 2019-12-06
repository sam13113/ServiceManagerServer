package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.servicemanagement.domain.UserRole;

/**
 * Spring Data JPA repository for the {@link UserRole} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 * 
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRoleName(String roleName);
}
