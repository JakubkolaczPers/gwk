package pl.edu.wszib.gwk.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.gwk.model.Game;
import pl.edu.wszib.gwk.service.GameService;
import pl.edu.wszib.gwk.service.MoneyService;
import pl.edu.wszib.gwk.service.SessionService;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final MoneyService moneyService;
    private final SessionService sessionService;

    @GetMapping("/game")
    public String ge1tStartGame(Model model, @RequestParam int userChoice, @RequestParam int userBet) {

        model.addAttribute("gameRequest", Game.builder()
                        .usersBet(userBet)
                        .usersChoice(userChoice)
                .build());
        model.addAttribute("userBet", userBet);
        model.addAttribute("userChoice", userChoice);
        return "game_page";
    }

    @PostMapping("/game")
    public String login(Model model, @ModelAttribute Game game) {
        System.out.println("game request:" + game);
        int prize = gameService.startGame(
               game.getUsersChoice(), game.getUsersBet());
        model.addAttribute("userLogin", model.getAttribute("userLogin"));
        model.addAttribute("result", prize);
        model.addAttribute("gameRequest", Game.builder()
                .usersBet(1)
                .usersChoice(1)
                .build());
        return "result_game_page";

    }


}

