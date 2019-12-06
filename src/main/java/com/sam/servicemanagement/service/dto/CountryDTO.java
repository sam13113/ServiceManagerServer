package com.sam.servicemanagement.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.sam.servicemanagement.domain.Country} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public class CountryDTO implements Serializable {

	private static final long serialVersionUID = 1590409092821584430L;
	private Long id;

	@NotNull
	private String countryName;

	@NotNull
	@Size(min = 2, max = 2)
	private String countryCode;

	private Long regionId;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(final String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(final Long regionId) {
		this.regionId = regionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((regionId == null) ? 0 : regionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CountryDTO other = (CountryDTO) obj;
		if (countryCode == null) {
			if (other.countryCode != null) {
				return false;
			}
		} else if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (countryName == null) {
			if (other.countryName != null) {
				return false;
			}
		} else if (!countryName.equals(other.countryName)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (regionId == null) {
			if (other.regionId != null) {
				return false;
			}
		} else if (!regionId.equals(other.regionId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CountryDTO [id=" + id + ", countryName=" + countryName + ", countryCode=" + countryCode + ", regionId="
				+ regionId + "]";
	}
}
