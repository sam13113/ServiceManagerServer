package com.sam.servicemanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sam.servicemanagement.domain.enumeration.DevelopmentMethodology;

/**
 * A DTO for the {@link com.sam.servicemanagement.domain.Project} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 */
public class ProjectDTO implements Serializable {

	private static final long serialVersionUID = 504254508290502004L;

	private Long id;

	@NotNull
	private String projectName;

	@NotNull
	@Size(max = 50)
	private String projectDescription;

	@NotNull
	private DevelopmentMethodology developmentMethodology;

	private Long serviceOwnerIT;

	private Long serviceOwnerBusiness;

	private Long serviceManager;

	private Long projectowner;

	private Long programId;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(final String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(final String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public DevelopmentMethodology getDevelopmentMethodology() {
		return developmentMethodology;
	}

	public void setDevelopmentMethodology(final DevelopmentMethodology developmentMethodology) {
		this.developmentMethodology = developmentMethodology;
	}

	public Long getServiceOwnerIT() {
		return serviceOwnerIT;
	}

	public void setServiceOwnerIT(final Long serviceOwnerIT) {
		this.serviceOwnerIT = serviceOwnerIT;
	}

	public Long getServiceOwnerBusiness() {
		return serviceOwnerBusiness;
	}

	public void setServiceOwnerBusiness(final Long serviceOwnerBusiness) {
		this.serviceOwnerBusiness = serviceOwnerBusiness;
	}

	public Long getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(final Long serviceManager) {
		this.serviceManager = serviceManager;
	}

	public Long getProjectowner() {
		return projectowner;
	}

	public void setProjectowner(final Long projectowner) {
		this.projectowner = projectowner;
	}

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(final Long programId) {
		this.programId = programId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final ProjectDTO projectDTO = (ProjectDTO) o;
		if (projectDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), projectDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "ProjectDTO{" + "id=" + getId() + ", projectName='" + getProjectName() + "'" + ", projectDescription='"
				+ getProjectDescription() + "'" + ", developmentMethodology='" + getDevelopmentMethodology() + "'"
				+ ", serviceOwnerIT=" + getServiceOwnerIT() + ", serviceOwnerBusiness=" + getServiceOwnerBusiness()
				+ ", serviceManager=" + getServiceManager() + ", projectowner=" + getProjectowner() + ", program="
				+ getProgramId() + "}";
	}
}
