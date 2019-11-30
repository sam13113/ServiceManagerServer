package com.sam.servicemanagement.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.servicemanagement.domain.User;
import com.sam.servicemanagement.service.UserService;
import com.sam.servicemanagement.service.dto.UserDTO;
import com.sam.servicemanagement.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing users.
 * <p>
 * This class accesses the {@link User} entity, and needs to fetch its
 * collection of authorities.
 * <p>
 * 
 * @author SAM
 * @since 30-Nov-2019
 * 
 */
@RestController
@RequestMapping("/serviceManagement")
public class UserResource {

	private static final Logger log = LoggerFactory.getLogger(UserResource.class);
	private static final String ENTITY_NAME = "user";
	private final UserService userService;

	public UserResource(final UserService userService) {
		this.userService = userService;
	}

	/**
	 * {@code POST  /users} : Create a new User.
	 *
	 * @param UserDTO the userDTO to create.
	 * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
	 *         body the new UserDTO, or with status {@code 400 (Bad Request)} if the
	 *         User has already an ID.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PostMapping("/users")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody final UserDTO userDTO)
			throws URISyntaxException, BadRequestAlertException {
		log.debug("REST request to save a User : " + userDTO);
		if (userDTO.getId() != null) {
			throw new BadRequestAlertException("A new kPI cannot already have an ID", ENTITY_NAME, "idexists");
		}
		final UserDTO result = userService.save(userDTO);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	/**
	 * {@code PUT  /users} : Updates an existing User.
	 *
	 * @param UserDTO the userDTO to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the updated userDTO, or with status {@code 400 (Bad Request)} if the
	 *         userDTO is not valid, or with status
	 *         {@code 500 (Internal Server Error)} if the userDTO couldn't be
	 *         updated.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PutMapping("/users")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody final UserDTO userDTO)
			throws URISyntaxException, BadRequestAlertException {
		log.debug("REST request to update a User : " + userDTO);
		if (userDTO.getId() != null) {
			throw new BadRequestAlertException("A new kPI cannot already have an ID", ENTITY_NAME, "idexists");
		}
		final UserDTO result = userService.save(userDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * {@code GET  /users} : get all the users.
	 *
	 * 
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
	 *         of users in body.
	 */
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		log.debug("REST request to get all Users");
		final List<UserDTO> usersList = userService.findAll();
		return new ResponseEntity<>(usersList, HttpStatus.OK);
	}

	/**
	 * {@code GET  /users/:id} : get the "id" user.
	 *
	 * @param id the id of the userDTO to retrieve.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
	 *         the userDTO, or with status {@code 404 (Not Found)}.
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getKPI(@PathVariable final Long id) {
		log.debug("REST request to get User : {}", id);
		final Optional<UserDTO> userDTO = userService.findOne(id);
		return new ResponseEntity<UserDTO>(userDTO.get(), HttpStatus.OK);
	}

	/**
	 * {@code DELETE  /users/:id} : delete the "id" user.
	 *
	 * @param id the id of the userDTO to delete.
	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
	 */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteKPI(@PathVariable final Long id) {
		log.debug("REST request to delete User : {}", id);
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
