package pl.edu.wszib.gwk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.service.impl.UserServiceImpl;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register request: " + user);
        User registeredUser = userService.registerUser(user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getNumberOfBankingCard(),
                user.getCvvCod(),
                user.getBalance(),
                user.getCheckbox());

        return registeredUser == null ? "error_page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login request: " + user);
        User authenticated = userService.authenticate(user.getLogin(), user.getPassword());
        if(authenticated != null){
            model.addAttribute("userLogin", authenticated.getLogin());
            model.addAttribute("userBalance", authenticated.getBalance());
            return "/game_page";
        }else {
            return "error_page";
        }
    }
}
