package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.Services;
import com.sam.servicemanagement.service.dto.ServicesDTO;

/**
 * Mapper for the entity {@link Service} and its DTO {@link ServiceDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = { OperationalEntityMapper.class })
public interface ServicesMapper extends EntityMapper<ServicesDTO, Services> {

	@Override
	@Mapping(source = "operationalEntity.id", target = "operationalEntityId")
	ServicesDTO toDto(Services service);

	@Override
	@Mapping(source = "operationalEntityId", target = "operationalEntity")
	Services toEntity(ServicesDTO serviceDTO);

	default Services fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final Services service = new Services();
		service.setId(id);
		return service;
	}
}