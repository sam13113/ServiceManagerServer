package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.OperationalEntity;
import com.sam.servicemanagement.repository.OperationalEntityRepository;
import com.sam.servicemanagement.service.OperationalEntityService;
import com.sam.servicemanagement.service.dto.OperationalEntityDTO;
import com.sam.servicemanagement.service.mapper.OperationalEntityMapper;

/**
 * Service Implementation for managing {@link OperationalEntity}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Service
@Transactional
public class OperationalEntityServiceImpl implements OperationalEntityService {

	private final Logger log = LoggerFactory.getLogger(OperationalEntityServiceImpl.class);

	private final OperationalEntityRepository operationalEntityRepository;

	private final OperationalEntityMapper operationalEntityMapper;

	public OperationalEntityServiceImpl(final OperationalEntityRepository operationalEntityRepository,
			final OperationalEntityMapper operationalEntityMapper) {
		this.operationalEntityRepository = operationalEntityRepository;
		this.operationalEntityMapper = operationalEntityMapper;
	}

	/**
	 * Save a operationalEntity.
	 *
	 * @param operationalEntityDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public OperationalEntityDTO save(final OperationalEntityDTO operationalEntityDTO) {
		log.debug("Request to save OperationalEntity : {}", operationalEntityDTO);
		OperationalEntity operationalEntity = operationalEntityMapper.toEntity(operationalEntityDTO);
		operationalEntity = operationalEntityRepository.save(operationalEntity);
		return operationalEntityMapper.toDto(operationalEntity);
	}

	/**
	 * Get all the operationalEntities.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<OperationalEntityDTO> findAll() {
		log.debug("Request to get all OperationalEntities");
		return operationalEntityRepository.findAll().stream().map(operationalEntityMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one operationalEntity by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<OperationalEntityDTO> findOne(final Long id) {
		log.debug("Request to get OperationalEntity : {}", id);
		return operationalEntityRepository.findById(id).map(operationalEntityMapper::toDto);
	}

	/**
	 * Delete the operationalEntity by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete OperationalEntity : {}", id);
		operationalEntityRepository.deleteById(id);
	}
}
