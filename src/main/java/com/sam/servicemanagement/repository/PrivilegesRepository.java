package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.servicemanagement.domain.Privilege;

/**
 * Spring Data JPA repository for the {@link Privilege} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 * 
 */
@Repository
public interface PrivilegesRepository extends JpaRepository<Privilege, Long> {
	Privilege findByPrivilege(String privilege);

	@Override
	void delete(Privilege privilege);
}
