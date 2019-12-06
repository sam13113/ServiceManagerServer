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

/**
 * Entity class for a Portfolio.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Entity
@Table(name = "t_portfolio")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Portfolio implements Serializable {

	private static final long serialVersionUID = 2749037847618206241L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "portfolio_name", nullable = false)
	private String portfolioName;

	@NotNull
	@Size(min = 4, max = 50)
	@Column(name = "portfolio_description", length = 50, nullable = false)
	private String portfolioDescription;

	@NotNull
	@Column(name = "business_weightage", nullable = false)
	private Integer businessWeightage;

	@Column(name = "strategy")
	private String strategy;

	@Column(name = "solution")
	private String solution;

	@Column(name = "portfolio_owner")
	private Long portfolioOwner;

	@ManyToOne
	private Department department;

	@ManyToOne
	private Services services;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(final String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getPortfolioDescription() {
		return portfolioDescription;
	}

	public void setPortfolioDescription(final String portfolioDescription) {
		this.portfolioDescription = portfolioDescription;
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

	public Long getPortfolioOwner() {
		return portfolioOwner;
	}

	public void setPortfolioOwner(final Long portfolioOwner) {
		this.portfolioOwner = portfolioOwner;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(final Department department) {
		this.department = department;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(final Services services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessWeightage == null) ? 0 : businessWeightage.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((portfolioDescription == null) ? 0 : portfolioDescription.hashCode());
		result = prime * result + ((portfolioName == null) ? 0 : portfolioName.hashCode());
		result = prime * result + ((portfolioOwner == null) ? 0 : portfolioOwner.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + ((solution == null) ? 0 : solution.hashCode());
		result = prime * result + ((strategy == null) ? 0 : strategy.hashCode());
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
		final Portfolio other = (Portfolio) obj;
		if (businessWeightage == null) {
			if (other.businessWeightage != null) {
				return false;
			}
		} else if (!businessWeightage.equals(other.businessWeightage)) {
			return false;
		}
		if (department == null) {
			if (other.department != null) {
				return false;
			}
		} else if (!department.equals(other.department)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (portfolioDescription == null) {
			if (other.portfolioDescription != null) {
				return false;
			}
		} else if (!portfolioDescription.equals(other.portfolioDescription)) {
			return false;
		}
		if (portfolioName == null) {
			if (other.portfolioName != null) {
				return false;
			}
		} else if (!portfolioName.equals(other.portfolioName)) {
			return false;
		}
		if (portfolioOwner == null) {
			if (other.portfolioOwner != null) {
				return false;
			}
		} else if (!portfolioOwner.equals(other.portfolioOwner)) {
			return false;
		}
		if (services == null) {
			if (other.services != null) {
				return false;
			}
		} else if (!services.equals(other.services)) {
			return false;
		}
		if (solution == null) {
			if (other.solution != null) {
				return false;
			}
		} else if (!solution.equals(other.solution)) {
			return false;
		}
		if (strategy == null) {
			if (other.strategy != null) {
				return false;
			}
		} else if (!strategy.equals(other.strategy)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", portfolioName=" + portfolioName + ", portfolioDescription="
				+ portfolioDescription + ", businessWeightage=" + businessWeightage + ", strategy=" + strategy
				+ ", solution=" + solution + ", portfolioOwner=" + portfolioOwner + ", department=" + department
				+ ", services=" + services + "]";
	}

}
