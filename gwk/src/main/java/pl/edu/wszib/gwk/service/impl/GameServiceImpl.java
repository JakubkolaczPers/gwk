package pl.edu.wszib.gwk.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.gwk.model.Game;
import pl.edu.wszib.gwk.repositories.SessionRepository;
import pl.edu.wszib.gwk.service.GameService;
import pl.edu.wszib.gwk.service.MoneyService;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final MoneyService moneyService;
    private final SessionRepository sessionRepository;

    public int startGame(int usersChoice, int usersBet) {
        int numberOfGames = 3;
        int winsAmount = 0;

        while (numberOfGames > 0) {
            --numberOfGames;
            Game game = new Game();
            game.setUsersChoice(usersChoice);
            game.setUsersBet(usersBet);

            if (game.getNumberOfRandom() == usersChoice) {
                winsAmount++;
            }

        }
        moneyService.updateBalance(
                sessionRepository.getById(1L).getUserId(),
                calculatePrize(winsAmount, usersBet)
        );
        return calculatePrize(winsAmount, usersBet);
    }

    private int calculatePrize(int winsAmount, int usersBet) {
        return switch (winsAmount) {
            case 0 -> 0;
            case 1 -> usersBet;
            case 2 -> usersBet * 2;
            case 3 -> usersBet * 4;
            default -> -1;
        };
    }
}
