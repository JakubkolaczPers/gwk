package pl.edu.wszib.gwk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.gwk.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);

    Optional<User> findById(Integer id);
}
