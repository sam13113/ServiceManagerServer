package com.sam.servicemanagement.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Privilege Entity class for {@link User}
 * 
 * @author SAM
 * @since 01-Dec-2019
 * 
 */
@Entity
@Table(name = "T_Privilege")
public class Privilege implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 50)
	@Column(name = "Privilege", length = 50)
	private String privilege;
	@ManyToMany(mappedBy = "privileges")
	private final List<UserRole> roles = new ArrayList<>();

	public Privilege() {
		super();
	}

	public Privilege(final String privilege) {
		this.privilege = privilege;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(final String privilege) {
		this.privilege = privilege;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(final List<UserRole> roles) {
		this.roles.addAll(roles);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Privilege)) {
			return false;
		}
		return id != null && id.equals(((Privilege) obj).id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((privilege == null) ? 0 : privilege.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Privilege {" + "id='" + id + '\'' + ",privilege='" + privilege + '\'' + "}";
	}

}
