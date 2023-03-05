package com.shoppee.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shoppee.common.entity.Role;
import com.shoppee.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User amar = new User("Amrendra", "Singh", "Amrendr07@gmail.com", "12345");
		amar.addRole(roleAdmin);
		User savedUser = userRepo.save(amar);

		assertThat(savedUser.getId()).isGreaterThan(0);
	}

	@Test
	public void testCreateUserWithTwoRole() {

		User ram = new User("Ram", "Singh", "Ram 07@gmail.com", "12345");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);

		ram.addRole(roleEditor);
		ram.addRole(roleAssistant);
		User savedUser = userRepo.save(ram);

		assertThat(savedUser.getId()).isGreaterThan(0);
	}

	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = userRepo.findAll();
		listUsers.forEach(user -> System.out.println(user));

	}

	@Test
	public void testGetUserById() {
		User userAmre = userRepo.findById(1).get();
		System.out.println(userAmre);
		assertThat(userAmre).isNotNull();
	}

	@Test
	public void testUpdateUserDetail() {
		User userAmre = userRepo.findById(1).get();
		userAmre.setEnabled(true);
		userAmre.setEmail("Amrendra8336@gmail.com");
		userRepo.save(userAmre);

	}

	@Test
	public void testUpdateUserRole() {
		User userRam = userRepo.findById(2).get();
		Role roleEditor = new Role(3);
		Role rolesalesPerson = new Role(2);
		userRam.getRoles().remove(roleEditor);
		userRam.addRole(rolesalesPerson);
		userRepo.save(userRam);

	}

	@Test
	public void testDeleteUserById() {
		Integer userId = 2;
		userRepo.deleteById(userId);
		;
	}

}
