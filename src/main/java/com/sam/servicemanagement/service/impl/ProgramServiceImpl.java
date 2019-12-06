package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Program;
import com.sam.servicemanagement.repository.ProgramRepository;
import com.sam.servicemanagement.service.ProgramService;
import com.sam.servicemanagement.service.dto.ProgramDTO;
import com.sam.servicemanagement.service.mapper.ProgramMapper;

/**
 * Service Implementation for managing {@link Program}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {

	private final Logger log = LoggerFactory.getLogger(ProgramServiceImpl.class);

	private final ProgramRepository programRepository;

	private final ProgramMapper programMapper;

	public ProgramServiceImpl(final ProgramRepository programRepository, final ProgramMapper programMapper) {
		this.programRepository = programRepository;
		this.programMapper = programMapper;
	}

	/**
	 * Save a program.
	 *
	 * @param programDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public ProgramDTO save(final ProgramDTO programDTO) {
		log.debug("Request to save Program : {}", programDTO);
		Program program = programMapper.toEntity(programDTO);
		program = programRepository.save(program);
		return programMapper.toDto(program);
	}

	/**
	 * Get all the programs.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProgramDTO> findAll() {
		log.debug("Request to get all Programs");
		return programRepository.findAll().stream().map(programMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one program by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<ProgramDTO> findOne(final Long id) {
		log.debug("Request to get Program : {}", id);
		return programRepository.findById(id).map(programMapper::toDto);
	}

	/**
	 * Delete the program by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete Program : {}", id);
		programRepository.deleteById(id);
	}
}
