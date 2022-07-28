package pl.edu.wszib.gwk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.gwk.model.Game;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.repositories.GameRepository;
import pl.edu.wszib.gwk.services.GameService;

@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public String getStartGame(Model model) {
        model.addAttribute("gameRequest", new Game());
        return "game_page";
    }
    @PostMapping("/game")
    public String login(@ModelAttribute Game game){
        System.out.println("game request: " + game);
        Game startGame = gameService.startGame(game.getNumberOfYourChoice(), game.getYourBet());
        return "result_game_page";

    }


}

