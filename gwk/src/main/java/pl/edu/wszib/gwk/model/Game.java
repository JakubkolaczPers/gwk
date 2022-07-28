package pl.edu.wszib.gwk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gamers_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vin;
    private int numberOfRandom =(int)(Math.random()*6) + 1;
    private int numberOfYourChoice;
    private int yourBet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return numberOfRandom == game.numberOfRandom && numberOfYourChoice == game.numberOfYourChoice && yourBet == game.yourBet && Objects.equals(id, game.id) && Objects.equals(vin, game.vin);
    }
}
