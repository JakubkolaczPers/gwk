package pl.edu.wszib.gwk.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.service.MoneyService;
import pl.edu.wszib.gwk.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MoneyService moneyService;

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {
        System.out.println("register request: " + user);
        User registeredUser = userService.registerUser(user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getNumberOfBankingCard(),
                user.getCvvCod(),
                user.getBalance(),
                user.getCheckbox());
        System.out.println(user);
        model.addAttribute("userLogin", registeredUser.getLogin());
        model.addAttribute("userBalance", moneyService.checkUserBalance(registeredUser.getId()));
        return registeredUser == null ? "error_page" : "game_page";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, Model model) {
        System.out.println("login request: " + login);
        User authenticated = userService.authenticate(password, password);
        if (authenticated != null) {
            model.addAttribute("userLogin", login);
            model.addAttribute("userBalance", moneyService.checkUserBalance(authenticated.getId()));
            return "game_page";
        }
        return "error_page";

    }
}
