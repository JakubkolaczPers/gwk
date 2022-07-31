package pl.edu.wszib.gwk.service;

public interface MoneyService {
    boolean verifyBalance(Integer id);

    void updateBalance(Integer id, int prize);

    int checkUserBalance(Integer id);
}
