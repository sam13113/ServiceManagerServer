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
 * Entity class for an OperationalEntity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Entity
@Table(name = "t_operational_entity")
public class OperationalEntity implements Serializable {
	private static final long serialVersionUID = -138417658578393994L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 50)
	@Column(name = "oe_name", length = 50, nullable = false)
	private String oeName;

	@ManyToOne
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getOeName() {
		return oeName;
	}

	public void setOeName(final String oeName) {
		this.oeName = oeName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(final Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((oeName == null) ? 0 : oeName.hashCode());
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
		final OperationalEntity other = (OperationalEntity) obj;
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (oeName == null) {
			if (other.oeName != null) {
				return false;
			}
		} else if (!oeName.equals(other.oeName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "OperationalEntity [id=" + id + ", oeName=" + oeName + ", country=" + country + "]";
	}

}
