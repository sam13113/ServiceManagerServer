package com.sam.servicemanagement.web.rest.errors;

import com.sam.servicemanagement.web.rest.UserResource;

/**
 * Custom exception for {@link UserResource} Rest controller
 * 
 * @author SAM
 * @since 30-Nov-2019
 * 
 */
public class BadRequestAlertException extends Exception {
	private static final long serialVersionUID = 1L;

	public BadRequestAlertException(final String defaultMessage, final String entityName, final String errorKey) {
		super(defaultMessage + " " + entityName);
	}
}
