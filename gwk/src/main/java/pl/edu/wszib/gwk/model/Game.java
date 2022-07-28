package pl.edu.wszib.gwk.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gamers_table")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vin;
    private int numberOfRandom =(int)(Math.random()*6) + 1;
    private int numberOfYourChoice;
    private int yourBet;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumberOfRandom() {
        return numberOfRandom;
    }

    public void setNumberOfRandom(int numberOfRandom) {
        this.numberOfRandom = numberOfRandom;
    }

    public int getNumberOfYourChoice() {
        return numberOfYourChoice;
    }

    public void setNumberOfYourChoice(int numberOfYourChoice) {
        this.numberOfYourChoice = numberOfYourChoice;
    }

    public int getYourBet() {
        return yourBet;
    }

    public void setYourBet(int yourBet) {
        this.yourBet = yourBet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return numberOfRandom == game.numberOfRandom && numberOfYourChoice == game.numberOfYourChoice && yourBet == game.yourBet && Objects.equals(id, game.id) && Objects.equals(vin, game.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, numberOfRandom, numberOfYourChoice, yourBet);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", numberOfRandom=" + numberOfRandom +
                ", numberOfYourChoice=" + numberOfYourChoice +
                ", yourBet=" + yourBet +
                '}';
    }

    public Game(String vin, int numberOfRandom, int numberOfYourChoice, int yourBet) {
        this.vin = vin;
        this.numberOfRandom = numberOfRandom;
        this.numberOfYourChoice = numberOfYourChoice;
        this.yourBet = yourBet;
    }

    public Game() {
    }
}
