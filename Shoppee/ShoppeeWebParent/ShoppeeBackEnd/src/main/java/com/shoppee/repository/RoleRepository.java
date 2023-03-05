package com.shoppee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppee.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}
