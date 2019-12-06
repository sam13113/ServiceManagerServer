package com.sam.servicemanagement.security.crypto.password;

/**
 * Custom password encoder for this application.
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
public interface PasswordEncoder {
	String encode(CharSequence rawPassword);

	boolean matches(CharSequence rawPassword, String encodedPassword);
}
