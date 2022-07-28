package pl.edu.wszib.gwk.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.gwk.model.Game;
import pl.edu.wszib.gwk.repositories.GameRepository;
import pl.edu.wszib.gwk.service.GameService;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public Game startGame(int numberOfYourChoice, int yourBet) {
        Game game = new Game();
        game.setNumberOfYourChoice(numberOfYourChoice);
        game.setYourBet(yourBet);
        return gameRepository.save(game);
    }
}
