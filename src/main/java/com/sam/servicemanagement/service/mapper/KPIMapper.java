package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.KPI;
import com.sam.servicemanagement.service.dto.KPIDTO;

/**
 * Mapper for the entity {@link KPI} and its DTO {@link KPIDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = { ProjectMapper.class })
public interface KPIMapper extends EntityMapper<KPIDTO, KPI> {

	@Override
	@Mapping(source = "project.id", target = "projectId")
	KPIDTO toDto(KPI kPI);

	@Override
	@Mapping(source = "projectId", target = "project")
	KPI toEntity(KPIDTO kPIDTO);

	default KPI fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final KPI kPI = new KPI();
		kPI.setId(id);
		return kPI;
	}
}
