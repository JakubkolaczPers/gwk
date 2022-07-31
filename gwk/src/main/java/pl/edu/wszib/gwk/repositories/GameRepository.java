package pl.edu.wszib.gwk.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.gwk.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
