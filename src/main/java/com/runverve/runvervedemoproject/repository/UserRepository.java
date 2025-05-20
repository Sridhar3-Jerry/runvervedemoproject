package com.runverve.runvervedemoproject.repository;

import com.runverve.runvervedemoproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserMailIgnoreCase(String userMail);

}
