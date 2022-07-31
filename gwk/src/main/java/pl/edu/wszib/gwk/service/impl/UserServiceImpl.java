package pl.edu.wszib.gwk.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.repositories.UserRepository;
import pl.edu.wszib.gwk.service.SessionService;
import pl.edu.wszib.gwk.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SessionService sessionService;

    public User registerUser(String login, String password, String email, String numberOfBankingCard, String cvvCod, int balance, String checkbox) {
        if (login == null || password == null || numberOfBankingCard == null || cvvCod == null || balance == 0 || checkbox == null) {
            return null;
        }
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

    public User authenticate(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null && user.getPassword().equals(password) ) {
            user.setCurrentSessionId((sessionService.createSession(user.getId())).getId());
        }
        return user;
    }
}
