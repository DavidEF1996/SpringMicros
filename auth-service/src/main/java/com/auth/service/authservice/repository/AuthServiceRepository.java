package com.auth.service.authservice.repository;

import com.auth.service.authservice.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthServiceRepository extends JpaRepository<AuthUser, Integer> {

        Optional<AuthUser> findByUserName (String userName);

}
