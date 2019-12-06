package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Services;
import com.sam.servicemanagement.repository.ServicesRepository;
import com.sam.servicemanagement.service.ServicesService;
import com.sam.servicemanagement.service.dto.ServicesDTO;
import com.sam.servicemanagement.service.mapper.ServicesMapper;

/**
 * Service Implementation for managing {@link Services}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@org.springframework.stereotype.Service
@Transactional
public class ServicesServiceImpl implements ServicesService {

	private final Logger log = LoggerFactory.getLogger(ServicesServiceImpl.class);

	private final ServicesRepository servicesRepository;

	private final ServicesMapper servicesMapper;

	public ServicesServiceImpl(final ServicesRepository servicesRepository, final ServicesMapper servicesMapper) {
		this.servicesRepository = servicesRepository;
		this.servicesMapper = servicesMapper;
	}

	/**
	 * Save a service.
	 *
	 * @param serviceDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public ServicesDTO save(final ServicesDTO servicesDTO) {
		log.debug("Request to save Service : {}", servicesDTO);
		Services service = servicesMapper.toEntity(servicesDTO);
		service = servicesRepository.save(service);
		return servicesMapper.toDto(service);
	}

	/**
	 * Get all the services.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ServicesDTO> findAll() {
		log.debug("Request to get all Services");
		return servicesRepository.findAll().stream().map(servicesMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one service by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<ServicesDTO> findOne(final Long id) {
		log.debug("Request to get Service : {}", id);
		return servicesRepository.findById(id).map(servicesMapper::toDto);
	}

	/**
	 * Delete the service by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete Service : {}", id);
		servicesRepository.deleteById(id);
	}
}
