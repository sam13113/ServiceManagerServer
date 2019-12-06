package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.KPIData;
import com.sam.servicemanagement.service.dto.KPIDataDTO;

/**
 * Mapper for the entity {@link KPIData} and its DTO {@link KPIDataDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Mapper(componentModel = "spring", uses = { KPIMapper.class })
public interface KPIDataMapper extends EntityMapper<KPIDataDTO, KPIData> {

	@Override
	@Mapping(source = "kpi.id", target = "kpiId")
	KPIDataDTO toDto(KPIData kPIData);

	@Override
	@Mapping(source = "kpiId", target = "kpi")
	KPIData toEntity(KPIDataDTO kPIDataDTO);

	default KPIData fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final KPIData kPIData = new KPIData();
		kPIData.setId(id);
		return kPIData;
	}
}
