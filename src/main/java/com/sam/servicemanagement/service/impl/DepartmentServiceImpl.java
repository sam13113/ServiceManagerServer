package com.sam.servicemanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Department;
import com.sam.servicemanagement.repository.DepartmentRepository;
import com.sam.servicemanagement.service.DepartmentService;
import com.sam.servicemanagement.service.dto.DepartmentDTO;
import com.sam.servicemanagement.service.mapper.DepartmentMapper;

/**
 * Service Implementation for managing {@link Department}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	private final DepartmentRepository departmentRepository;

	private final DepartmentMapper departmentMapper;

	public DepartmentServiceImpl(final DepartmentRepository departmentRepository,
			final DepartmentMapper departmentMapper) {
		this.departmentRepository = departmentRepository;
		this.departmentMapper = departmentMapper;
	}

	/**
	 * Save a department.
	 *
	 * @param departmentDTO the entity to save.
	 * @return the persisted entity.
	 */
	@Override
	public DepartmentDTO save(final DepartmentDTO departmentDTO) {
		log.debug("Request to save Department : {}", departmentDTO);
		Department department = departmentMapper.toEntity(departmentDTO);
		department = departmentRepository.save(department);
		return departmentMapper.toDto(department);
	}

	/**
	 * Get all the departments.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DepartmentDTO> findAll() {
		log.debug("Request to get all Departments");
		return departmentRepository.findAll().stream().map(departmentMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one department by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<DepartmentDTO> findOne(final Long id) {
		log.debug("Request to get Department : {}", id);
		return departmentRepository.findById(id).map(departmentMapper::toDto);
	}

	/**
	 * Delete the department by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		log.debug("Request to delete Department : {}", id);
		departmentRepository.deleteById(id);
	}
}
