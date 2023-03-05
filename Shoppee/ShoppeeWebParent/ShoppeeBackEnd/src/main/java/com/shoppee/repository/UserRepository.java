package com.shoppee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppee.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
