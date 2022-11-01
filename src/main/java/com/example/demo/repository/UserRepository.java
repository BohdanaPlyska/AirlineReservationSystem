package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByFirstName(String username);

    @Query("SELECT o FROM User o where o.firstName = ?1 and o.lastName = ?2")
    Optional<User> findByUserFirstNameAndLastName(String firstName, String lastName);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

}
