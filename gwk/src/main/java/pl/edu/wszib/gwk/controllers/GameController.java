package pl.edu.wszib.gwk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.gwk.model.Game;
import pl.edu.wszib.gwk.service.impl.GameServiceImpl;

@Controller
public class GameController {

    private final GameServiceImpl gameService;

    public GameController(GameServiceImpl gameService) {
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

