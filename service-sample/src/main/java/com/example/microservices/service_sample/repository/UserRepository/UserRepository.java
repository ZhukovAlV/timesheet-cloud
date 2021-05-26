package com.example.microservices.service_sample.repository.UserRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
