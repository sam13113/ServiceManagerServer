package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Country;
import com.sam.servicemanagement.repository.CountryRepository;
import com.sam.servicemanagement.service.CountryService;
import com.sam.servicemanagement.service.dto.CountryDTO;
import com.sam.servicemanagement.service.mapper.CountryMapper;

/**
 * Service Implementation for managing {@link Country}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {

	private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

	private final CountryRepository countryRepository;

	private final CountryMapper countryMapper;

	public CountryServiceImpl(final CountryRepository countryRepository, final CountryMapper countryMapper) {
		this.countryRepository = countryRepository;
		this.countryMapper = countryMapper;
	}

	/**
	 * Save a country.
	 *
	 * @param countryDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public CountryDTO save(final CountryDTO countryDTO) {
		log.debug("Request to save Country : {}", countryDTO);
		Country country = countryMapper.toEntity(countryDTO);
		country = countryRepository.save(country);
		return countryMapper.toDto(country);
	}

	/**
	 * Get all the countries.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<CountryDTO> findAll() {
		log.debug("Request to get all Countries");
		return countryRepository.findAll().stream().map(countryMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one country by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<CountryDTO> findOne(final Long id) {
		log.debug("Request to get Country : {}", id);
		return countryRepository.findById(id).map(countryMapper::toDto);
	}

	/**
	 * Delete the country by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete Country : {}", id);
		countryRepository.deleteById(id);
	}
}
