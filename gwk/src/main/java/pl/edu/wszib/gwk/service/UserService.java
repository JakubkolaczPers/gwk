package pl.edu.wszib.gwk.service;

import pl.edu.wszib.gwk.model.User;

public interface UserService {
    User registerUser(String login,
                      String password,
                      String email,
                      String numberOfBankingCard,
                      String cvvCod,
                      int balance,
                      String checkbox);
    User authenticate(String login, String password);
}
