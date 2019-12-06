package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Region;
import com.sam.servicemanagement.repository.RegionRepository;
import com.sam.servicemanagement.service.RegionService;
import com.sam.servicemanagement.service.dto.RegionDTO;
import com.sam.servicemanagement.service.mapper.RegionMapper;

/**
 * Service Implementation for managing {@link Region}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Service
@Transactional
public class RegionServiceImpl implements RegionService {

	private static final Logger log = LoggerFactory.getLogger(RegionServiceImpl.class);
	private final RegionRepository regionRepository;

	private final RegionMapper regionMapper;

	public RegionServiceImpl(final RegionRepository regionRepository, final RegionMapper regionMapper) {
		this.regionRepository = regionRepository;
		this.regionMapper = regionMapper;
	}

	/**
	 * Save a region.
	 *
	 * @param regionDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public RegionDTO save(final RegionDTO regionDTO) {
		log.debug("Request to save Region : {}", regionDTO);
		Region region = regionMapper.toEntity(regionDTO);
		region = regionRepository.save(region);
		return regionMapper.toDto(region);
	}

	/**
	 * Get all the regions.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<RegionDTO> findAll() {
		log.debug("Request to get all Regions");
		return regionRepository.findAll().stream().map(regionMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one region by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<RegionDTO> findOne(final Long id) {
		log.debug("Request to get Region : {}", id);
		return regionRepository.findById(id).map(regionMapper::toDto);
	}

	/**
	 * Delete the region by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete Region : {}", id);
		regionRepository.deleteById(id);
	}

}
