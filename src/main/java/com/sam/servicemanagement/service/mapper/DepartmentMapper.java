package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;

import com.sam.servicemanagement.domain.Department;
import com.sam.servicemanagement.service.dto.DepartmentDTO;

/**
 * Mapper for the entity {@link Department} and its DTO {@link DepartmentDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = {})
public interface DepartmentMapper extends EntityMapper<DepartmentDTO, Department> {

	default Department fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final Department department = new Department();
		department.setId(id);
		return department;
	}
}
