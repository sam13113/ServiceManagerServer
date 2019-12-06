package com.sam.servicemanagement.service.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {Program} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 */
public class ProgramDTO implements Serializable {

	private static final long serialVersionUID = 688018573980785730L;

	private Long id;

	@NotNull
	private String programName;

	@NotNull
	@Size(min = 4, max = 50)
	private String programDescription;

	@NotNull
	private Integer businessWeightage;

	private String strategy;

	private Long programOwner;

	private Long portfolioId;

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

	public Long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(final Long portfolioId) {
		this.portfolioId = portfolioId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessWeightage == null) ? 0 : businessWeightage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
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
		final ProgramDTO other = (ProgramDTO) obj;
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
		if (portfolioId == null) {
			if (other.portfolioId != null) {
				return false;
			}
		} else if (!portfolioId.equals(other.portfolioId)) {
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
		return "ProgramDTO [id=" + id + ", programName=" + programName + ", programDescription=" + programDescription
				+ ", businessWeightage=" + businessWeightage + ", strategy=" + strategy + ", programOwner="
				+ programOwner + ", portfolioId=" + portfolioId + "]";
	}

}
