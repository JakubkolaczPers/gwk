package pl.edu.wszib.gwk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "gamers_table")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String vin;
    private int numberOfRandom = (int) (Math.random() * 6) + 1;
    private int usersChoice;
    private int usersBet;
    private int moneyResult;
}
