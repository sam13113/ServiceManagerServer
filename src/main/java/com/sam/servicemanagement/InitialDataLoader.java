package com.sam.servicemanagement;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sam.servicemanagement.domain.Country;
import com.sam.servicemanagement.domain.Department;
import com.sam.servicemanagement.domain.OperationalEntity;
import com.sam.servicemanagement.domain.Portfolio;
import com.sam.servicemanagement.domain.Privilege;
import com.sam.servicemanagement.domain.Region;
import com.sam.servicemanagement.domain.Services;
import com.sam.servicemanagement.domain.User;
import com.sam.servicemanagement.domain.UserRole;
import com.sam.servicemanagement.repository.CountryRepository;
import com.sam.servicemanagement.repository.DepartmentRepository;
import com.sam.servicemanagement.repository.OperationalEntityRepository;
import com.sam.servicemanagement.repository.PortfolioRepository;
import com.sam.servicemanagement.repository.PrivilegesRepository;
import com.sam.servicemanagement.repository.RegionRepository;
import com.sam.servicemanagement.repository.ServicesRepository;
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
	private RegionRepository regionRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private OperationalEntityRepository operationalEntityRepository;

	@Autowired
	private ServicesRepository servicesRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private PortfolioRepository portfolioRepository;

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

		final Region region = new Region();
		region.setRegionName("Europe");
		regionRepository.save(region);

		final Country country = new Country();
		country.setRegion(region);
		country.setCountryCode("DE");
		country.setCountryName("Germany");
		countryRepository.save(country);

		final OperationalEntity oe = new OperationalEntity();
		oe.setCountry(country);
		oe.setOeName("AzGermany");
		operationalEntityRepository.save(oe);

		final Services services = new Services();
		services.setOperationalEntity(oe);
		services.setDescription("Design and develop new requests as well as support already available projects");
		services.setServiceName("CustomerService");
		servicesRepository.save(services);

		final Department department = new Department();
		department.setDepartmentCode("CPS");
		department.setDepartmentName("CustomerServicesDepartment");
		departmentRepository.save(department);

		final Portfolio portfolio = new Portfolio();
		portfolio.setDepartment(department);
		portfolio.setServices(services);
		portfolio.setBusinessWeightage(25);
		portfolio.setPortfolioDescription("A portfolio like ontimedelivery");
		portfolio.setPortfolioName("ABBS");
		portfolio.setPortfolioOwner(5L);
		portfolio.setSolution("a solution");
		portfolio.setStrategy("a strategy");
		portfolioRepository.save(portfolio);

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