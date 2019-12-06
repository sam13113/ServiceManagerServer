package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.domain.OperationalEntity;
import com.sam.servicemanagement.service.dto.OperationalEntityDTO;

/**
 * Service Interface for managing {@link OperationalEntity}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public interface OperationalEntityService {

	/**
	 * Save a operationalEntity.
	 *
	 * @param operationalEntityDTO the entity to save.
	 * @return the persisted entity.
	 */
	OperationalEntityDTO save(OperationalEntityDTO operationalEntityDTO);

	/**
	 * Get all the operationalEntities.
	 *
	 * @return the list of entities.
	 */
	List<OperationalEntityDTO> findAll();

	/**
	 * Get the "id" operationalEntity.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<OperationalEntityDTO> findOne(Long id);

	/**
	 * Delete the "id" operationalEntity.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
