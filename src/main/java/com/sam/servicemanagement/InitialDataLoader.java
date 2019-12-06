package com.sam.servicemanagement;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Privilege;
import com.sam.servicemanagement.domain.User;
import com.sam.servicemanagement.domain.UserRole;
import com.sam.servicemanagement.repository.PrivilegesRepository;
import com.sam.servicemanagement.repository.UserRepository;
import com.sam.servicemanagement.repository.UserRoleRepository;
import com.sam.servicemanagement.security.crypto.password.PasswordEncoder;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository roleRepository;

	@Autowired
	private PrivilegesRepository privilegeRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {

		if (alreadySetup) {
			return;
		}
		final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

		final List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

		final UserRole adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
		final UserRole userRole = roleRepository.findByRoleName("ROLE_USER");
		final User admin = new User();
		admin.setFirst_name("Test");
		admin.setLogin_name("admin");
		admin.setLast_name("Admin");
		admin.setPassword(passwordEncoder.encode("password"));
		admin.setEmail("admin@test.com");
		admin.setRoles(Arrays.asList(adminRole, userRole));
		admin.setActivated(true);
		userRepository.save(admin);

		final User user = new User();
		user.setFirst_name("Test");
		user.setLogin_name("user");
		user.setLast_name("User");
		user.setPassword(passwordEncoder.encode("password"));
		user.setEmail("user@test.com");
		user.setRoles(Arrays.asList(userRole));
		user.setActivated(true);
		userRepository.save(user);

		alreadySetup = true;
	}

	@Transactional
	private Privilege createPrivilegeIfNotFound(final String name) {

		Privilege privilege = privilegeRepository.findByPrivilege(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Transactional
	private UserRole createRoleIfNotFound(final String name, final List<Privilege> privileges) {

		UserRole role = roleRepository.findByRoleName(name);
		if (role == null) {
			role = new UserRole();
			role.setRoleName(name);
			role.setPrivileges(privileges);
			roleRepository.save(role);
		}
		return role;
	}
}