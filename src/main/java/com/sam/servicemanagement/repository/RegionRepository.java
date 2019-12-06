package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.servicemanagement.domain.Region;

/**
 * Spring Data JPA repository for the {@link Region} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public interface RegionRepository extends JpaRepository<Region, Long> {

}
