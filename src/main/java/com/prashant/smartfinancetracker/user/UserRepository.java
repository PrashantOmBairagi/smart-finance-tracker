package com.prashant.smartfinancetracker.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public User findByUsername(String username);
}
