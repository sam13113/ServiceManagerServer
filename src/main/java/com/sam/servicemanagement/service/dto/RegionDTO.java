package com.sam.servicemanagement.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * A DTO for the {@link com.sam.servicemanagement.domain.Region} entity
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public class RegionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	private String regionName;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(final String regionName) {
		this.regionName = regionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((regionName == null) ? 0 : regionName.hashCode());
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
		final RegionDTO other = (RegionDTO) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (regionName == null) {
			if (other.regionName != null) {
				return false;
			}
		} else if (!regionName.equals(other.regionName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "RegionDTO [id=" + id + ", regionName=" + regionName + "]";
	}

}
