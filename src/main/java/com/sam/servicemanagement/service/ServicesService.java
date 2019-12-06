package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.ServicesDTO;

/**
 * Service Interface for managing {@link Services}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public interface ServicesService {

	/**
	 * Save a service.
	 *
	 * @param serviceDTO the entity to save.
	 * @return the persisted entity.
	 */
	ServicesDTO save(ServicesDTO serviceDTO);

	/**
	 * Get all the services.
	 *
	 * @return the list of entities.
	 */
	List<ServicesDTO> findAll();

	/**
	 * Get the "id" service.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<ServicesDTO> findOne(Long id);

	/**
	 * Delete the "id" service.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
