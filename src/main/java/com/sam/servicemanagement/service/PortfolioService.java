package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.domain.Portfolio;
import com.sam.servicemanagement.service.dto.PortfolioDTO;

/**
 * Service Interface for managing {@link Portfolio}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public interface PortfolioService {

	/**
	 * Save a portfolio.
	 *
	 * @param portfolioDTO the entity to save.
	 * @return the persisted entity.
	 */
	PortfolioDTO save(PortfolioDTO portfolioDTO);

	/**
	 * Get all the portfolios.
	 *
	 * @return the list of entities.
	 */
	List<PortfolioDTO> findAll();

	/**
	 * Get the "id" portfolio.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<PortfolioDTO> findOne(Long id);

	/**
	 * Delete the "id" portfolio.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
