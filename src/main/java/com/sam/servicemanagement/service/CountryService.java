package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.CountryDTO;

/**
 * Service Interface for managing
 * {@link com.sam.servicemanagement.domain.Country}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public interface CountryService {

	/**
	 * Save a country.
	 *
	 * @param countryDTO the entity to save.
	 * @return the persisted entity.
	 */
	CountryDTO save(CountryDTO countryDTO);

	/**
	 * Get all the countries.
	 *
	 * @return the list of entities.
	 */
	List<CountryDTO> findAll();

	/**
	 * Get the "id" country.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<CountryDTO> findOne(Long id);

	/**
	 * Delete the "id" country.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
