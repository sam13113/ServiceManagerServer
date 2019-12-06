package com.sam.servicemanagement.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sam.servicemanagement.domain.Country;
import com.sam.servicemanagement.service.dto.CountryDTO;

/**
 * Mapper for the entity {@link Country} and its DTO {@link CountryDTO}.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Mapper(componentModel = "spring", uses = { RegionMapper.class })
public interface CountryMapper extends EntityMapper<CountryDTO, Country> {

	@Override
	@Mapping(source = "region.id", target = "regionId")
	CountryDTO toDto(Country country);

	@Override
	@Mapping(source = "regionId", target = "region")
	Country toEntity(CountryDTO countryDTO);

	default Country fromId(final Long id) {
		if (id == null) {
			return null;
		}
		final Country country = new Country();
		country.setId(id);
		return country;
	}
}
