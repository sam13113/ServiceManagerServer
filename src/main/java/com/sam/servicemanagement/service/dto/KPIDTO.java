package com.sam.servicemanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.sam.servicemanagement.domain.KPI} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 */
public class KPIDTO implements Serializable {

	private static final long serialVersionUID = 7215694824417489756L;

	private Long id;

	@NotNull
	@Size(max = 20)
	private String name;

	@NotNull
	private Integer threshHoldMax;

	@NotNull
	private Integer threshHoldMin;

	@NotNull
	private Integer businessWeightage;

	private Long projectId;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getThreshHoldMax() {
		return threshHoldMax;
	}

	public void setThreshHoldMax(final Integer threshHoldMax) {
		this.threshHoldMax = threshHoldMax;
	}

	public Integer getThreshHoldMin() {
		return threshHoldMin;
	}

	public void setThreshHoldMin(final Integer threshHoldMin) {
		this.threshHoldMin = threshHoldMin;
	}

	public Integer getBusinessWeightage() {
		return businessWeightage;
	}

	public void setBusinessWeightage(final Integer businessWeightage) {
		this.businessWeightage = businessWeightage;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(final Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final KPIDTO kPIDTO = (KPIDTO) o;
		if (kPIDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), kPIDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "KPIDTO{" + "id=" + getId() + ", name='" + getName() + "'" + ", threshHoldMax=" + getThreshHoldMax()
				+ ", threshHoldMin=" + getThreshHoldMin() + ", businessWeightage=" + getBusinessWeightage()
				+ ", project=" + getProjectId() + "}";
	}
}
