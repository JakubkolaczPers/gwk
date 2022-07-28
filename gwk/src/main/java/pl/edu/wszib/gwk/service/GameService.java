package pl.edu.wszib.gwk.service;

import pl.edu.wszib.gwk.model.Game;

public interface GameService {
    Game startGame(int numberOfYourChoice, int yourBet);
}
