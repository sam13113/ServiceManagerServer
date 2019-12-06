package com.sam.servicemanagement.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * User Roles Entity class
 * 
 * @author SAM
 * @since 01-Dec-2019
 * 
 */
@Entity
@Table(name = "T_UserRole")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(max = 50)
	@Column(name = "Role_Name", length = 50)
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	private final List<Privilege> privileges = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(final String roleName) {
		this.roleName = roleName;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(final Collection<User> users) {
		this.users = users;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(final List<Privilege> privileges) {
		this.privileges.addAll(privileges);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserRole)) {
			return false;
		}
		return id != null && id.equals(((UserRole) obj).id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "UserRole{" + "id='" + id + '\'' + ", role='" + roleName + '\'' + ", Privileges='"
				+ privileges.toString() + "}";
	}
}
