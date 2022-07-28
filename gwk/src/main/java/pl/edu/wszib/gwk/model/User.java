package pl.edu.wszib.gwk.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_table", indexes = {
        @Index(name = "idx_user_billingdetails", columnList = "billingDetails")
})
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
    private String checkbox;
    private String numberOfBankingCard;
    private String cvvCod;
    private int balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_u_id", referencedColumnName = "u_id")
    private Set<Game> gamer = new HashSet<>();
}
