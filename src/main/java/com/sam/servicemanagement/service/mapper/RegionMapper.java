package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;

import com.sam.servicemanagement.domain.Region;
import com.sam.servicemanagement.service.dto.RegionDTO;

/**
 * Mapper for the entity {@link Region} and its DTO {@link RegionDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Mapper(componentModel = "spring", uses = {})
public interface RegionMapper extends EntityMapper<RegionDTO, Region> {

	default Region fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final Region region = new Region();
		region.setId(id);
		return region;
	}
}
