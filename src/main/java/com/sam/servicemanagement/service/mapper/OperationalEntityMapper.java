package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.OperationalEntity;
import com.sam.servicemanagement.service.dto.OperationalEntityDTO;

/**
 * Mapper for the entity {@link OperationalEntity} and its DTO
 * {@link OperationalEntityDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = { CountryMapper.class })
public interface OperationalEntityMapper extends EntityMapper<OperationalEntityDTO, OperationalEntity> {

	@Override
	@Mapping(source = "country.id", target = "countryId")
	OperationalEntityDTO toDto(OperationalEntity operationalEntity);

	@Override
	@Mapping(source = "countryId", target = "country")
	OperationalEntity toEntity(OperationalEntityDTO operationalEntityDTO);

	default OperationalEntity fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final OperationalEntity operationalEntity = new OperationalEntity();
		operationalEntity.setId(id);
		return operationalEntity;
	}
}
