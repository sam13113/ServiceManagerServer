package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.KPI;
import com.sam.servicemanagement.repository.KPIRepository;
import com.sam.servicemanagement.service.KPIService;
import com.sam.servicemanagement.service.dto.KPIDTO;
import com.sam.servicemanagement.service.mapper.KPIMapper;

/**
 * Service Implementation for managing {@link KPI}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Service
@Transactional
public class KPIServiceImpl implements KPIService {

	private final Logger log = LoggerFactory.getLogger(KPIServiceImpl.class);

	private final KPIRepository kPIRepository;

	private final KPIMapper kPIMapper;

	public KPIServiceImpl(final KPIRepository kPIRepository, final KPIMapper kPIMapper) {
		this.kPIRepository = kPIRepository;
		this.kPIMapper = kPIMapper;
	}

	/**
	 * Save a kPI.
	 *
	 * @param kPIDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public KPIDTO save(final KPIDTO kPIDTO) {
		log.debug("Request to save KPI : {}", kPIDTO);
		KPI kPI = kPIMapper.toEntity(kPIDTO);
		kPI = kPIRepository.save(kPI);
		return kPIMapper.toDto(kPI);
	}

	/**
	 * Get all the kPIS.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<KPIDTO> findAll() {
		log.debug("Request to get all KPIS");
		return kPIRepository.findAll().stream().map(kPIMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one kPI by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<KPIDTO> findOne(final Long id) {
		log.debug("Request to get KPI : {}", id);
		return kPIRepository.findById(id).map(kPIMapper::toDto);
	}

	/**
	 * Delete the kPI by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete KPI : {}", id);
		kPIRepository.deleteById(id);
	}
}
