package com.sam.servicemanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sam.servicemanagement.domain.Department;

/**
 * A DTO for the {@link Department} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 */
public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = -4038258263900757346L;

	private Long id;

	@NotNull
	@Size(max = 50)
	private String departmentName;

	@Size(min = 2, max = 10)
	private String departmentCode;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(final String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(final String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final DepartmentDTO departmentDTO = (DepartmentDTO) o;
		if (departmentDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), departmentDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "DepartmentDTO{" + "id=" + getId() + ", departmentName='" + getDepartmentName() + "'"
				+ ", departmentCode='" + getDepartmentCode() + "'" + "}";
	}
}
