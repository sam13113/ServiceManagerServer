package com.sam.servicemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.sam.servicemanagement.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for {@link PasswordEncoder} beans
 * 
 * @author SAM
 * @since 06-Dec-2019
 * 
 */
@Configuration
public class PasswordEncoderConfig {
	@Bean
	public PasswordEncoder customPasswordEncoder() {

		return new PasswordEncoder() {

			@Override
			public String encode(final CharSequence rawPassword) {

				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
			}

			@Override
			public boolean matches(final CharSequence rawPassword, final String encodedPassword) {

				return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
			}
		};
	}
}
