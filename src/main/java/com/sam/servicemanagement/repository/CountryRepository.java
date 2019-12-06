package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.servicemanagement.domain.Country;

/**
 * Spring Data JPA repository for the {@link Country} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
