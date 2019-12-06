package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.KPIData;
import com.sam.servicemanagement.repository.KPIDataRepository;
import com.sam.servicemanagement.service.KPIDataService;
import com.sam.servicemanagement.service.dto.KPIDataDTO;
import com.sam.servicemanagement.service.mapper.KPIDataMapper;

/**
 * Service Implementation for managing {@link KPIData}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Service
@Transactional
public class KPIDataServiceImpl implements KPIDataService {

	private final Logger log = LoggerFactory.getLogger(KPIDataServiceImpl.class);

	private final KPIDataRepository kPIDataRepository;

	private final KPIDataMapper kPIDataMapper;

	public KPIDataServiceImpl(final KPIDataRepository kPIDataRepository, final KPIDataMapper kPIDataMapper) {
		this.kPIDataRepository = kPIDataRepository;
		this.kPIDataMapper = kPIDataMapper;
	}

	/**
	 * Save a kPIData.
	 *
	 * @param kPIDataDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public KPIDataDTO save(final KPIDataDTO kPIDataDTO) {
		log.debug("Request to save KPIData : {}", kPIDataDTO);
		KPIData kPIData = kPIDataMapper.toEntity(kPIDataDTO);
		kPIData = kPIDataRepository.save(kPIData);
		return kPIDataMapper.toDto(kPIData);
	}

	/**
	 * Get all the kPIData.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<KPIDataDTO> findAll() {
		log.debug("Request to get all KPIData");
		return kPIDataRepository.findAll().stream().map(kPIDataMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one kPIData by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<KPIDataDTO> findOne(final Long id) {
		log.debug("Request to get KPIData : {}", id);
		return kPIDataRepository.findById(id).map(kPIDataMapper::toDto);
	}

	/**
	 * Delete the kPIData by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete KPIData : {}", id);
		kPIDataRepository.deleteById(id);
	}
}
