package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.RegionDTO;

/**
 * Service Interface for managing
 * {@link com.sam.servicemanagement.domain.Region}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public interface RegionService {

	/**
	 * Save a region.
	 *
	 * @param regionDTO the entity to save.
	 * @return the persisted entity.
	 */
	RegionDTO save(RegionDTO regionDTO);

	/**
	 * Get all the regions.
	 *
	 * @return the list of entities.
	 */
	List<RegionDTO> findAll();

	/**
	 * Get the "id" region.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<RegionDTO> findOne(Long id);

	/**
	 * Delete the "id" region.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
