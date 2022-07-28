package pl.edu.wszib.gwk.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return balance == user.balance && Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(numberOfBankingCard, user.numberOfBankingCard) && Objects.equals(cvvCod, user.cvvCod) && Objects.equals(checkbox, user.checkbox);
    }
}
