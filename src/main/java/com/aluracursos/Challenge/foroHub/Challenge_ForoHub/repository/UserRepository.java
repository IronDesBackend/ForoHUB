package com.aluracursos.Challenge.foroHub.Challenge_ForoHub.repository;

import com.aluracursos.Challenge.foroHub.Challenge_ForoHub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
