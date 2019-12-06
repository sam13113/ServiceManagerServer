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
 * Entity class for a Program. Programs are subset of a Portfolio
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Entity
@Table(name = "t_program")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Program implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "program_name", nullable = false)
	private String programName;

	@NotNull
	@Size(min = 4, max = 50)
	@Column(name = "program_description", length = 50, nullable = false)
	private String programDescription;

	@NotNull
	@Column(name = "business_weightage", nullable = false)
	private Integer businessWeightage;

	@Column(name = "strategy")
	private String strategy;

	@Column(name = "program_owner")
	private Long programOwner;

	@ManyToOne
	@JsonIgnoreProperties("programs")
	private Portfolio portfolio;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(final String programName) {
		this.programName = programName;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(final String programDescription) {
		this.programDescription = programDescription;
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

	public Long getProgramOwner() {
		return programOwner;
	}

	public void setProgramOwner(final Long programOwner) {
		this.programOwner = programOwner;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(final Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessWeightage == null) ? 0 : businessWeightage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((portfolio == null) ? 0 : portfolio.hashCode());
		result = prime * result + ((programDescription == null) ? 0 : programDescription.hashCode());
		result = prime * result + ((programName == null) ? 0 : programName.hashCode());
		result = prime * result + ((programOwner == null) ? 0 : programOwner.hashCode());
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
		final Program other = (Program) obj;
		if (businessWeightage == null) {
			if (other.businessWeightage != null) {
				return false;
			}
		} else if (!businessWeightage.equals(other.businessWeightage)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (portfolio == null) {
			if (other.portfolio != null) {
				return false;
			}
		} else if (!portfolio.equals(other.portfolio)) {
			return false;
		}
		if (programDescription == null) {
			if (other.programDescription != null) {
				return false;
			}
		} else if (!programDescription.equals(other.programDescription)) {
			return false;
		}
		if (programName == null) {
			if (other.programName != null) {
				return false;
			}
		} else if (!programName.equals(other.programName)) {
			return false;
		}
		if (programOwner == null) {
			if (other.programOwner != null) {
				return false;
			}
		} else if (!programOwner.equals(other.programOwner)) {
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
		return "Program [id=" + id + ", programName=" + programName + ", programDescription=" + programDescription
				+ ", businessWeightage=" + businessWeightage + ", strategy=" + strategy + ", programOwner="
				+ programOwner + ", portfolio=" + portfolio + "]";
	}

}
