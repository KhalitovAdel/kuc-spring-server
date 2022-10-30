package com.kuc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kuc.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
