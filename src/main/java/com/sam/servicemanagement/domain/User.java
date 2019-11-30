package com.sam.servicemanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sam.servicemanagement.config.Constants;
import com.sun.istack.NotNull;

/**
 * User Table entity class
 * 
 * @author SAM
 * 
 * @23-Nov-2019
 * 
 */
@Entity
@Table(name = "T_User")
public class User implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(User.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String first_name;
	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String last_name;
	@Email
	@Size(min = 5, max = 254)
	@Column(length = 254, unique = true)
	private String email;
	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = Constants.LOGIN_REGEX)
	@Column(length = 50, unique = true, nullable = false)
	private String login_name;
	@NotNull
	@Size(min = 8, max = 60)
	@Column(name = "password_hash", length = 60, nullable = false)
	private String password;
	@NotNull
	@Column(nullable = false)
	private boolean activated = false;

// From this line onwards getters & setters
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(final Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(final String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(final String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(final String login_name) {
		this.login_name = login_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(final boolean activated) {
		this.activated = activated;
	}

	public static Logger getLog() {
		return log;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		return user_id != null && user_id.equals(((User) obj).user_id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "User{" + "login='" + login_name + '\'' + ", firstName='" + first_name + '\'' + ", lastName='"
				+ last_name + '\'' + ", email='" + email + '\'' + ", activated='" + activated + '\'' + "}";
	}

}
