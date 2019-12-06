package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.servicemanagement.domain.Department;

/**
 * Spring Data JPA repository for the {@link Department} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
