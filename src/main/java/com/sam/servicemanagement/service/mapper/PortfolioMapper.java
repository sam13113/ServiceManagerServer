package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.Portfolio;
import com.sam.servicemanagement.service.dto.PortfolioDTO;

/**
 * Mapper for the entity {@link Portfolio} and its DTO {@link PortfolioDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = { DepartmentMapper.class, ServicesMapper.class })
public interface PortfolioMapper extends EntityMapper<PortfolioDTO, Portfolio> {

	@Override
	@Mapping(source = "department.id", target = "departmentId")
	@Mapping(source = "services.id", target = "serviceId")
	PortfolioDTO toDto(Portfolio portfolio);

	@Override
	@Mapping(source = "departmentId", target = "department")
	@Mapping(source = "serviceId", target = "services")
	Portfolio toEntity(PortfolioDTO portfolioDTO);

	default Portfolio fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final Portfolio portfolio = new Portfolio();
		portfolio.setId(id);
		return portfolio;
	}
}
