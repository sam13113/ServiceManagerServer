package com.sam.servicemanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sam.servicemanagement.domain.OperationalEntity;

/**
 * A DTO for the {@link OperationalEntity} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public class OperationalEntityDTO implements Serializable {

	private static final long serialVersionUID = -7735242334788035654L;

	private Long id;

	@NotNull
	@Size(max = 50)
	private String oeName;

	private Long countryId;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getOeName() {
		return oeName;
	}

	public void setOeName(final String oeName) {
		this.oeName = oeName;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(final Long countryId) {
		this.countryId = countryId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final OperationalEntityDTO operationalEntityDTO = (OperationalEntityDTO) o;
		if (operationalEntityDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), operationalEntityDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "OperationalEntityDTO{" + "id=" + getId() + ", oeName='" + getOeName() + "'" + ", country="
				+ getCountryId() + "}";
	}
}
