package pl.edu.wszib.gwk.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="u_id")
    private Integer id;
    private String login;
    private String password;
    private String email;
    private String numberOfBankingCard;
    private String cvvCod;
    private int balance;
    private String checkbox;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_u_id", referencedColumnName = "u_id")
    private Set<Game> gamer = new HashSet<>();

    public Set<Game> getGamer() {
        return gamer;
    }

    public void setGamer(Set<Game> gamer) {
        this.gamer = gamer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberOfBankingCard() {
        return numberOfBankingCard;
    }

    public void setNumberOfBankingCard(String numberOfBankingCard) {
        this.numberOfBankingCard = numberOfBankingCard;
    }

    public String getCvvCod() {
        return cvvCod;
    }

    public void setCvvCod(String cvvCod) {
        this.cvvCod = cvvCod;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return balance == user.balance && Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(numberOfBankingCard, user.numberOfBankingCard) && Objects.equals(cvvCod, user.cvvCod) && Objects.equals(checkbox, user.checkbox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, numberOfBankingCard, cvvCod, balance, checkbox);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", checkbox='" + checkbox + '\'' +
                '}';
    }
}
