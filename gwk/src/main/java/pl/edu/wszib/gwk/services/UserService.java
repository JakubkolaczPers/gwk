package pl.edu.wszib.gwk.services;

import org.springframework.stereotype.Service;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String login, String password, String email, String numberOfBankingCard, String cvvCod, int balance, String checkbox){
        if (login == null || password == null || numberOfBankingCard == null || cvvCod == null || balance == 0 || checkbox == null) {
            return  null;
        } else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setBalance(balance);
            user.setNumberOfBankingCard(numberOfBankingCard);
            user.setCvvCod(cvvCod);
            user.setCheckbox(checkbox);
            return userRepository.save(user);
        }
    }

    public User authenticate(String login, String password){
        return  userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
