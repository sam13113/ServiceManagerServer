package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.servicemanagement.domain.Portfolio;

/**
 * Spring Data JPA repository for the {@link Portfolio} entity.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
