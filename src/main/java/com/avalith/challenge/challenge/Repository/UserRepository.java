package com.avalith.challenge.challenge.Repository;

import com.avalith.challenge.challenge.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("userJpa")
public interface UserRepository extends JpaRepository<User, UUID> {
}
