package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.Project;
import com.sam.servicemanagement.service.dto.ProjectDTO;

/**
 * Mapper for the entity {@link Project} and its DTO {@link ProjectDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = { ProgramMapper.class })
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {

	@Override
	@Mapping(source = "program.id", target = "programId")
	ProjectDTO toDto(Project project);

	@Override
	@Mapping(source = "programId", target = "program")
	Project toEntity(ProjectDTO projectDTO);

	default Project fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final Project project = new Project();
		project.setId(id);
		return project;
	}
}
