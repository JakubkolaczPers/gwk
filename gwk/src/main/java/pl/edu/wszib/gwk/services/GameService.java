package pl.edu.wszib.gwk.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.gwk.model.Game;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.repositories.GameRepository;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public Game startGame(int numberOfYourChoice, int yourBet){
        Game game = new Game();
        game.setNumberOfYourChoice(numberOfYourChoice);
        game.setYourBet(yourBet);
        return  gameRepository.save(game);
    }
}
