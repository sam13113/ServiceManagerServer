package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.ProjectDTO;

/**
 * Service Interface for managing
 * {@link com.sam.servicemanagement.domain.Project}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public interface ProjectService {

	/**
	 * Save a project.
	 *
	 * @param projectDTO the entity to save.
	 * @return the persisted entity.
	 */
	ProjectDTO save(ProjectDTO projectDTO);

	/**
	 * Get all the projects.
	 *
	 * @return the list of entities.
	 */
	List<ProjectDTO> findAll();

	/**
	 * Get the "id" project.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<ProjectDTO> findOne(Long id);

	/**
	 * Delete the "id" project.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
