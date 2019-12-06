package com.sam.servicemanagement.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.sam.servicemanagement.domain.KPIData} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 */
public class KPIDataDTO implements Serializable {

	private static final long serialVersionUID = 8274055895414815466L;

	private Long id;

	@NotNull
	private Integer value;

	@NotNull
	@Size(max = 50)
	private String comments;

	@NotNull
	private LocalDate reportingPeriod;

	private Long kpiId;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(final Integer value) {
		this.value = value;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}

	public LocalDate getReportingPeriod() {
		return reportingPeriod;
	}

	public void setReportingPeriod(final LocalDate reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public Long getKpiId() {
		return kpiId;
	}

	public void setKpiId(final Long kPIId) {
		this.kpiId = kPIId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final KPIDataDTO kPIDataDTO = (KPIDataDTO) o;
		if (kPIDataDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), kPIDataDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "KPIDataDTO{" + "id=" + getId() + ", value=" + getValue() + ", comments='" + getComments() + "'"
				+ ", reportingPeriod='" + getReportingPeriod() + "'" + ", kpi=" + getKpiId() + "}";
	}
}
