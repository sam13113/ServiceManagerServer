package com.sam.servicemanagement.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.servicemanagement.domain.Region;
import com.sam.servicemanagement.service.RegionService;
import com.sam.servicemanagement.service.dto.RegionDTO;

/**
 * REST controller for managing Region.
 * <p>
 * This class accesses the {@link Region} entity, and assists in fetching its
 * related countries.
 * <p>
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@RestController
@RequestMapping("/serviceManagement/region")
public class RegionResource {

	private static final Logger log = LoggerFactory.getLogger(RegionResource.class);
	private static final String ENTITY_NAME = "region";
	private final RegionService regionService;

	public RegionResource(final RegionService regionService) {
		this.regionService = regionService;
	}

	/**
	 * {@code GET  /listAll} : get all the regions.
	 *
	 * 
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
	 *         of regions in body.
	 */
	@GetMapping("/listAll")
	public ResponseEntity<List<RegionDTO>> getAllUsers() {
		log.debug("REST request to get all Users");
		final List<RegionDTO> regionList = regionService.findAll();
		return new ResponseEntity<>(regionList, HttpStatus.OK);
	}
}
