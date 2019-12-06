package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.servicemanagement.domain.Program;

/**
 * Spring Data repository for the {@link Program} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 */
@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

}
