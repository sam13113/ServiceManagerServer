package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.Program;
import com.sam.servicemanagement.service.dto.ProgramDTO;

/**
 * Mapper for the entity {@link Program} and its DTO {@link ProgramDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = { PortfolioMapper.class })
public interface ProgramMapper extends EntityMapper<ProgramDTO, Program> {

	@Override
	@Mapping(source = "portfolio.id", target = "portfolioId")
	ProgramDTO toDto(Program program);

	@Override
	@Mapping(source = "portfolioId", target = "portfolio")
	Program toEntity(ProgramDTO programDTO);

	default Program fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final Program program = new Program();
		program.setId(id);
		return program;
	}
}
