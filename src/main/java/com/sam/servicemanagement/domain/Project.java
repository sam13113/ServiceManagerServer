package com.sam.servicemanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import com.sam.servicemanagement.domain.enumeration.DevelopmentMethodology;

/**
 * Entity class for a Project. Projects are subset of a Programs
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
@Entity
@Table(name = "t_project")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "project_name", nullable = false)
	private String projectName;

	@NotNull
	@Size(max = 50)
	@Column(name = "project_description", length = 50, nullable = false)
	private String projectDescription;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "development_methodology", nullable = false)
	private DevelopmentMethodology developmentMethodology;

	@Column(name = "service_owner_it")
	private Long serviceOwnerIT;

	@Column(name = "service_owner_business")
	private Long serviceOwnerBusiness;

	@Column(name = "service_manager")
	private Long serviceManager;

	@Column(name = "projectowner")
	private Long projectowner;

	@ManyToOne
	@JsonIgnoreProperties("projects")
	private Program program;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public Project projectName(final String projectName) {
		this.projectName = projectName;
		return this;
	}

	public void setProjectName(final String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public Project projectDescription(final String projectDescription) {
		this.projectDescription = projectDescription;
		return this;
	}

	public void setProjectDescription(final String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public DevelopmentMethodology getDevelopmentMethodology() {
		return developmentMethodology;
	}

	public Project developmentMethodology(final DevelopmentMethodology developmentMethodology) {
		this.developmentMethodology = developmentMethodology;
		return this;
	}

	public void setDevelopmentMethodology(final DevelopmentMethodology developmentMethodology) {
		this.developmentMethodology = developmentMethodology;
	}

	public Long getServiceOwnerIT() {
		return serviceOwnerIT;
	}

	public Project serviceOwnerIT(final Long serviceOwnerIT) {
		this.serviceOwnerIT = serviceOwnerIT;
		return this;
	}

	public void setServiceOwnerIT(final Long serviceOwnerIT) {
		this.serviceOwnerIT = serviceOwnerIT;
	}

	public Long getServiceOwnerBusiness() {
		return serviceOwnerBusiness;
	}

	public Project serviceOwnerBusiness(final Long serviceOwnerBusiness) {
		this.serviceOwnerBusiness = serviceOwnerBusiness;
		return this;
	}

	public void setServiceOwnerBusiness(final Long serviceOwnerBusiness) {
		this.serviceOwnerBusiness = serviceOwnerBusiness;
	}

	public Long getServiceManager() {
		return serviceManager;
	}

	public Project serviceManager(final Long serviceManager) {
		this.serviceManager = serviceManager;
		return this;
	}

	public void setServiceManager(final Long serviceManager) {
		this.serviceManager = serviceManager;
	}

	public Long getProjectowner() {
		return projectowner;
	}

	public Project projectowner(final Long projectowner) {
		this.projectowner = projectowner;
		return this;
	}

	public void setProjectowner(final Long projectowner) {
		this.projectowner = projectowner;
	}

	public Program getProgram() {
		return program;
	}

	public Project program(final Program program) {
		this.program = program;
		return this;
	}

	public void setProgram(final Program program) {
		this.program = program;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Project)) {
			return false;
		}
		return id != null && id.equals(((Project) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "Project{" + "id=" + getId() + ", projectName='" + getProjectName() + "'" + ", projectDescription='"
				+ getProjectDescription() + "'" + ", developmentMethodology='" + getDevelopmentMethodology() + "'"
				+ ", serviceOwnerIT=" + getServiceOwnerIT() + ", serviceOwnerBusiness=" + getServiceOwnerBusiness()
				+ ", serviceManager=" + getServiceManager() + ", projectowner=" + getProjectowner() + "}";
	}
}
