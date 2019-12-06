package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.KPIDTO;

/**
 * Service Interface for managing {@link com.sam.servicemanagement.domain.KPI}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public interface KPIService {

	/**
	 * Save a kPI.
	 *
	 * @param kPIDTO the entity to save.
	 * @return the persisted entity.
	 */
	KPIDTO save(KPIDTO kPIDTO);

	/**
	 * Get all the kPIS.
	 *
	 * @return the list of entities.
	 */
	List<KPIDTO> findAll();

	/**
	 * Get the "id" kPI.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<KPIDTO> findOne(Long id);

	/**
	 * Delete the "id" kPI.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
