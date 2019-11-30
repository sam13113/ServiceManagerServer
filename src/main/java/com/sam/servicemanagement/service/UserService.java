package com.sam.servicemanagement.service;

import java.util.List;
import java.util.Optional;

import com.sam.servicemanagement.service.dto.UserDTO;

/**
 * User Service Interface
 * 
 * @author SAM
 * @since 23-Nov-2019
 * 
 */
public interface UserService {

	public UserDTO save(final UserDTO userDTO);

	public List<UserDTO> findAll();

	public Optional<UserDTO> findOne(final Long id);

	public void delete(final Long id);

}
