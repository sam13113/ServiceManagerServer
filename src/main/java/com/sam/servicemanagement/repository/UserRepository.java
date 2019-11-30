package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.servicemanagement.domain.User;

/**
 * Spring Data JPA repository for the {@link User} entity.
 * 
 * @author SAM
 * 
 * @since 23-Nov-2019
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	Optional<User> findOneByEmailIgnoreCase(String email);
//
//	Optional<User> findOneByLogin(String login_name);
//
//	@EntityGraph(attributePaths = "authorities")
//	Optional<User> findOneWithAuthoritiesById(Long id);
//
//	@EntityGraph(attributePaths = "authorities")
//	Optional<User> findOneWithAuthoritiesByLogin(String login);
//
//	@EntityGraph(attributePaths = "authorities")
//	Optional<User> findOneWithAuthoritiesByEmailIgnorCase(String email);

}
