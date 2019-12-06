package com.sam.servicemanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link Services} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public class ServicesDTO implements Serializable {

	private static final long serialVersionUID = -3616190034638343167L;

	private Long id;

	@NotNull
	private String serviceName;

	@Size(max = 100)
	private String description;

	private Long operationalEntityId;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(final String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Long getOperationalEntityId() {
		return operationalEntityId;
	}

	public void setOperationalEntityId(final Long operationalEntityId) {
		this.operationalEntityId = operationalEntityId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final ServicesDTO serviceDTO = (ServicesDTO) o;
		if (serviceDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), serviceDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "ServicesDTO{" + "id=" + getId() + ", serviceName='" + getServiceName() + "'" + ", description='"
				+ getDescription() + "'" + ", operationalEntity=" + getOperationalEntityId() + "}";
	}
}
