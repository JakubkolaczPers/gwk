package pl.edu.wszib.gwk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.gwk.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginAndPassword(String login, String password);
}
