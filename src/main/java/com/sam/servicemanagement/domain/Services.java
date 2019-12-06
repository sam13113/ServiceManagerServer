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

/**
 * Entity class for a Service.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Entity
@Table(name = "t_service")
public class Services implements Serializable {

	private static final long serialVersionUID = 2564041938710472899L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "service_name", nullable = false)
	private String serviceName;

	@Size(max = 100)
	@Column(name = "description", length = 100)
	private String description;

	@ManyToOne
	private OperationalEntity operationalEntity;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(final String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public OperationalEntity getOperationalEntity() {
		return operationalEntity;
	}

	public void setOperationalEntity(final OperationalEntity operationalEntity) {
		this.operationalEntity = operationalEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((operationalEntity == null) ? 0 : operationalEntity.hashCode());
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
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
		final Services other = (Services) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (operationalEntity == null) {
			if (other.operationalEntity != null) {
				return false;
			}
		} else if (!operationalEntity.equals(other.operationalEntity)) {
			return false;
		}
		if (serviceName == null) {
			if (other.serviceName != null) {
				return false;
			}
		} else if (!serviceName.equals(other.serviceName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Services [id=" + id + ", serviceName=" + serviceName + ", description=" + description
				+ ", operationalEntity=" + operationalEntity + "]";
	}

}
