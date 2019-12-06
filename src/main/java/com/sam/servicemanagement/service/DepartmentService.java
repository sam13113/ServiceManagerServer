package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.domain.Department;
import com.sam.servicemanagement.service.dto.DepartmentDTO;

/**
 * Service Interface for managing {@link Department}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public interface DepartmentService {

	/**
	 * Save a department.
	 *
	 * @param departmentDTO the entity to save.
	 * @return the persisted entity.
	 */
	DepartmentDTO save(DepartmentDTO departmentDTO);

	/**
	 * Get all the departments.
	 *
	 * @return the list of entities.
	 */
	List<DepartmentDTO> findAll();

	/**
	 * Get the "id" department.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<DepartmentDTO> findOne(Long id);

	/**
	 * Delete the "id" department.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
