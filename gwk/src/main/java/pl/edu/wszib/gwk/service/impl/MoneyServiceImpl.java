package pl.edu.wszib.gwk.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.gwk.model.User;
import pl.edu.wszib.gwk.repositories.UserRepository;
import pl.edu.wszib.gwk.service.MoneyService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoneyServiceImpl implements MoneyService {
    private final UserRepository userRepository;

    @Override
    public boolean verifyBalance(Integer id) {
        return checkUserBalance(id) > 0;
    }

    @Override
    public void updateBalance(Integer id, int balance) {
        Optional<User> user = userRepository.findById(id);
        int userBalance = user.get().getBalance();
        user.get().setBalance(userBalance + balance);
    }

    @Override
    public int checkUserBalance(Integer id) {
        return userRepository.findById(id).get().getBalance();
    }
}
