package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.ProgramDTO;

/**
 * Service Interface for managing
 * {@link com.sam.servicemanagement.domain.Program}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public interface ProgramService {

	/**
	 * Save a program.
	 *
	 * @param programDTO the entity to save.
	 * @return the persisted entity.
	 */
	ProgramDTO save(ProgramDTO programDTO);

	/**
	 * Get all the programs.
	 *
	 * @return the list of entities.
	 */
	List<ProgramDTO> findAll();

	/**
	 * Get the "id" program.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<ProgramDTO> findOne(Long id);

	/**
	 * Delete the "id" program.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
