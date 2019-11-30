package com.sam.servicemanagement.service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sam.servicemanagement.config.Constants;
import com.sam.servicemanagement.domain.User;

/**
 * A DTO representing a user, with his authorities
 * 
 * @author SAM
 * @since 23-Nov-2019
 * 
 */
public class UserDTO {
	private Long id;

	@NotBlank
	@Pattern(regexp = Constants.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	private String loginName;
	@Size(max = 50)
	private String firstName;
	@Size(max = 50)
	private String lastName;
	@Email
	@Size(min = 2, max = 50)
	private String email;
	private boolean activated = false;
	@Size(max = 60)
	private String password;

	public UserDTO() {
		// Empty contructor for Jackson
	}

	public UserDTO(final User user) {
		this.id = user.getUser_id();
		this.loginName = user.getLogin_name();
		this.firstName = user.getFirst_name();
		this.lastName = user.getLast_name();
		this.email = user.getEmail();
		this.activated = user.isActivated();
		this.password = user.getPassword();

	}

//From this line downwards getters & setters
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(final String loginName) {
		this.loginName = loginName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(final boolean activated) {
		this.activated = activated;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO{" + "login='" + loginName + '\'' + ", firstName='" + firstName + '\'' + ", lastName='"
				+ lastName + '\'' + ", email='" + email + '\'' + ", activated=" + activated + "}";
	}

}
