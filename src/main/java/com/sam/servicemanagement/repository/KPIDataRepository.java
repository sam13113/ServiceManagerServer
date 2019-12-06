package com.sam.servicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.servicemanagement.domain.KPIData;

/**
 * Spring Data repository for the {@link KPIData} entity.
 * 
 * @author SAM
 * @since 01-Dec-2019
 */
@Repository
public interface KPIDataRepository extends JpaRepository<KPIData, Long> {

}
