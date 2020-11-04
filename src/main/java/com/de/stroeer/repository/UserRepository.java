package com.de.stroeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.de.stroeer.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

}
