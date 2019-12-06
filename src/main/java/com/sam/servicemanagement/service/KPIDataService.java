package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.KPIDataDTO;

/**
 * Service Interface for managing
 * {@link com.sam.servicemanagement.domain.KPIData}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public interface KPIDataService {

	/**
	 * Save a kPIData.
	 *
	 * @param kPIDataDTO the entity to save.
	 * @return the persisted entity.
	 */
	KPIDataDTO save(KPIDataDTO kPIDataDTO);

	/**
	 * Get all the kPIData.
	 *
	 * @return the list of entities.
	 */
	List<KPIDataDTO> findAll();

	/**
	 * Get the "id" kPIData.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<KPIDataDTO> findOne(Long id);

	/**
	 * Delete the "id" kPIData.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
