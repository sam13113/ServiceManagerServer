package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Portfolio;
import com.sam.servicemanagement.repository.PortfolioRepository;
import com.sam.servicemanagement.service.PortfolioService;
import com.sam.servicemanagement.service.dto.PortfolioDTO;
import com.sam.servicemanagement.service.mapper.PortfolioMapper;

/**
 * Service Implementation for managing {@link Portfolio}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Service
@Transactional
public class PortfolioServiceImpl implements PortfolioService {

	private final Logger log = LoggerFactory.getLogger(PortfolioServiceImpl.class);

	private final PortfolioRepository portfolioRepository;

	private final PortfolioMapper portfolioMapper;

	public PortfolioServiceImpl(final PortfolioRepository portfolioRepository, final PortfolioMapper portfolioMapper) {
		this.portfolioRepository = portfolioRepository;
		this.portfolioMapper = portfolioMapper;
	}

	/**
	 * Save a portfolio.
	 *
	 * @param portfolioDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public PortfolioDTO save(final PortfolioDTO portfolioDTO) {
		log.debug("Request to save Portfolio : {}", portfolioDTO);
		Portfolio portfolio = portfolioMapper.toEntity(portfolioDTO);
		portfolio = portfolioRepository.save(portfolio);
		return portfolioMapper.toDto(portfolio);
	}

	/**
	 * Get all the portfolios.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PortfolioDTO> findAll() {
		log.debug("Request to get all Portfolios");
		return portfolioRepository.findAll().stream().map(portfolioMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one portfolio by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<PortfolioDTO> findOne(final Long id) {
		log.debug("Request to get Portfolio : {}", id);
		return portfolioRepository.findById(id).map(portfolioMapper::toDto);
	}

	/**
	 * Delete the portfolio by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete Portfolio : {}", id);
		portfolioRepository.deleteById(id);
	}
}
