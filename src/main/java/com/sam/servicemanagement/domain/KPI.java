package com.sam.servicemanagement.domain;

import java.io.Serializable;

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
 * Entity class for a KPI.
 * <p>
 * KPI is a measurement parameter used with respect to a project
 * </p>
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Entity
@Table(name = "t_kpi")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class KPI implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 20)
	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@NotNull
	@Column(name = "thresh_hold_max", nullable = false)
	private Integer threshHoldMax;

	@NotNull
	@Column(name = "thresh_hold_min", nullable = false)
	private Integer threshHoldMin;

	@NotNull
	@Column(name = "business_weightage", nullable = false)
	private Integer businessWeightage;

	@ManyToOne
	@JsonIgnoreProperties("kPIS")
	private Project project;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public KPI name(final String name) {
		this.name = name;
		return this;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getThreshHoldMax() {
		return threshHoldMax;
	}

	public KPI threshHoldMax(final Integer threshHoldMax) {
		this.threshHoldMax = threshHoldMax;
		return this;
	}

	public void setThreshHoldMax(final Integer threshHoldMax) {
		this.threshHoldMax = threshHoldMax;
	}

	public Integer getThreshHoldMin() {
		return threshHoldMin;
	}

	public KPI threshHoldMin(final Integer threshHoldMin) {
		this.threshHoldMin = threshHoldMin;
		return this;
	}

	public void setThreshHoldMin(final Integer threshHoldMin) {
		this.threshHoldMin = threshHoldMin;
	}

	public Integer getBusinessWeightage() {
		return businessWeightage;
	}

	public KPI businessWeightage(final Integer businessWeightage) {
		this.businessWeightage = businessWeightage;
		return this;
	}

	public void setBusinessWeightage(final Integer businessWeightage) {
		this.businessWeightage = businessWeightage;
	}

	public Project getProject() {
		return project;
	}

	public KPI project(final Project project) {
		this.project = project;
		return this;
	}

	public void setProject(final Project project) {
		this.project = project;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof KPI)) {
			return false;
		}
		return id != null && id.equals(((KPI) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "KPI{" + "id=" + getId() + ", name='" + getName() + "'" + ", threshHoldMax=" + getThreshHoldMax()
				+ ", threshHoldMin=" + getThreshHoldMin() + ", businessWeightage=" + getBusinessWeightage() + "}";
	}
}
