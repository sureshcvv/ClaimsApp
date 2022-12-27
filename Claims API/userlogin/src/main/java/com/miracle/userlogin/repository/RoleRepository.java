package com.miracle.userlogin.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miracle.userlogin.beans.ERole;
import com.miracle.userlogin.beans.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
