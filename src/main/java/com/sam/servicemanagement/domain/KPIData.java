package com.sam.servicemanagement.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity class for a KPIData.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Entity
@Table(name = "t_kpi_data")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class KPIData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "value", nullable = false)
	private Integer value;

	@NotNull
	@Size(max = 50)
	@Column(name = "comments", length = 50, nullable = false)
	private String comments;

	@NotNull
	@Column(name = "reporting_period", nullable = false)
	private LocalDate reportingPeriod;

	@ManyToOne
	@JsonIgnoreProperties("kPIData")
	private KPI kpi;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public KPIData value(final Integer value) {
		this.value = value;
		return this;
	}

	public void setValue(final Integer value) {
		this.value = value;
	}

	public String getComments() {
		return comments;
	}

	public KPIData comments(final String comments) {
		this.comments = comments;
		return this;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}

	public LocalDate getReportingPeriod() {
		return reportingPeriod;
	}

	public KPIData reportingPeriod(final LocalDate reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
		return this;
	}

	public void setReportingPeriod(final LocalDate reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public KPI getKpi() {
		return kpi;
	}

	public KPIData kpi(final KPI kPI) {
		this.kpi = kPI;
		return this;
	}

	public void setKpi(final KPI kPI) {
		this.kpi = kPI;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof KPIData)) {
			return false;
		}
		return id != null && id.equals(((KPIData) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "KPIData{" + "id=" + getId() + ", value=" + getValue() + ", comments='" + getComments() + "'"
				+ ", reportingPeriod='" + getReportingPeriod() + "'" + "}";
	}
}
