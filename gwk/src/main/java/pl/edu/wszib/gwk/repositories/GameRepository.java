package pl.edu.wszib.gwk.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.gwk.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
