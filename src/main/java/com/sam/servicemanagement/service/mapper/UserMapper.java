package com.sam.servicemanagement.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sam.servicemanagement.domain.User;
import com.sam.servicemanagement.service.dto.UserDTO;

/**
 * Mapper for the entity {@link User} and its DTO called {@link UserDTO}
 * 
 * @author SAM
 * @since 30-Nov-2019
 * 
 */
@Service
public class UserMapper {

	public List<UserDTO> usersToUserDTOs(final List<User> userList) {
		return userList.stream().filter(Objects::nonNull).map(this::userToUserDTO).collect(Collectors.toList());
	}

	public UserDTO userToUserDTO(final User user) {
		return new UserDTO(user);
	}

	public List<User> UsersDTOtoUsers(final List<UserDTO> userDTOList) {
		return userDTOList.stream().filter(Objects::nonNull).map(this::UserDTOtoUser).collect(Collectors.toList());
	}

	public User UserDTOtoUser(final UserDTO userDTO) {
		if (userDTO != null) {
			final User user = new User();
			user.setActivated(userDTO.isActivated());
			user.setEmail(userDTO.getEmail());
			user.setFirst_name(userDTO.getFirstName());
			user.setLast_name(userDTO.getLastName());
			user.setLogin_name(userDTO.getLoginName());
			user.setUser_id(userDTO.getId());
			user.setPassword(userDTO.getPassword());
			return user;
		} else {
			return null;
		}

	}

}
