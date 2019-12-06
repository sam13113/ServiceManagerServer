package com.sam.servicemanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sam.servicemanagement.domain.Portfolio;

/**
 * A DTO for the {@link Portfolio} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public class PortfolioDTO implements Serializable {

	private static final long serialVersionUID = -3969308956920697266L;

	private Long id;

	@NotNull
	private String name;

	@NotNull
	@Size(min = 4, max = 50)
	private String description;

	@NotNull
	private Integer businessWeightage;

	private String strategy;

	private String solution;

	private Long portfolioOwner;

	private Long departmentId;

	private Long serviceId;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Integer getBusinessWeightage() {
		return businessWeightage;
	}

	public void setBusinessWeightage(final Integer businessWeightage) {
		this.businessWeightage = businessWeightage;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(final String strategy) {
		this.strategy = strategy;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(final String solution) {
		this.solution = solution;
	}

	public Long getPortfolioowner() {
		return portfolioOwner;
	}

	public void setPortfolioowner(final Long portfolioOwner) {
		this.portfolioOwner = portfolioOwner;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(final Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(final Long serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final PortfolioDTO portfolioDTO = (PortfolioDTO) o;
		if (portfolioDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), portfolioDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "PortfolioDTO{" + "id=" + getId() + ", name='" + getName() + "'" + ", description='" + getDescription()
				+ "'" + ", businessWeightage=" + getBusinessWeightage() + ", strategy='" + getStrategy() + "'"
				+ ", solution='" + getSolution() + "'" + ", portfolioowner=" + getPortfolioowner() + ", department="
				+ getDepartmentId() + ", service=" + getServiceId() + "}";
	}
}
