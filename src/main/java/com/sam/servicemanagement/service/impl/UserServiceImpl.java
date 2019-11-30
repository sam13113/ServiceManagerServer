package com.sam.servicemanagement.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.User;
import com.sam.servicemanagement.repository.UserRepository;
import com.sam.servicemanagement.service.UserService;
import com.sam.servicemanagement.service.dto.UserDTO;
import com.sam.servicemanagement.service.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
//	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper) {
//		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	/**
	 * Save a User.
	 *
	 * @param userDTO the entity to save.
	 * @return the persisted entity user.
	 */
	@Override
	public UserDTO save(final UserDTO userDTO) {
//		final String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
		logger.debug("Request to save UserDTO : " + userDTO.toString());
		final User user = userMapper.UserDTOtoUser(userDTO);
		userRepository.save(user);
		return userMapper.userToUserDTO(user);
	}

	/**
	 * Get all the Users.
	 *
	 * @return the list of entities.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		logger.debug("Request to get all Users");
		return userRepository.findAll().stream().map(userMapper::userToUserDTO).collect(Collectors.toList());
	}

	/**
	 * Get one User by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<UserDTO> findOne(final Long id) {
		logger.debug("Request to get one user by id : " + id);
		return userRepository.findById(id).map(userMapper::userToUserDTO);
	}

	/**
	 * Delete the User by id.
	 *
	 * @param id the id of the entity.
	 */
	@Override
	public void delete(final Long id) {
		logger.debug("Request to delete a user by id : " + id);
		userRepository.deleteById(id);
	}

}
