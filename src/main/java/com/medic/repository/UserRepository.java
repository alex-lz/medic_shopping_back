package com.medic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medic.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
