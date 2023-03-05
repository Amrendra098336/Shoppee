package com.shoppee.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shoppee.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

	@Autowired
	private RoleRepository roleRepo;

	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin", "Manage Everything");
		Role saveRole = roleRepo.save(roleAdmin);
		assertThat(saveRole.getId()).isGreaterThan(0);
	}

	@Test
	public void testCreateOtherRole() {
		Role roleSalesperson = new Role("Salesperson", "Sales Report, Product Line, Customers, Shipping and Orders 	");
		Role roleEditor = new Role("Editors", "Categories, Brands, Products, article,and  Menus 	");
		Role roleShipper = new Role("Shipper", "view Products, View Orders , and, Orders Status");
		Role roleAssistant = new Role("Assistant", "Questions, Reviews ");
		roleRepo.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
	}

}
