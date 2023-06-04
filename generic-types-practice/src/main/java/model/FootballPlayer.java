package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FootballPlayer extends Player{

    private Double legLength;

    public FootballPlayer(String name, String surname, Integer number, Double legLength) {
        super(name, surname, number);
        this.legLength = legLength;
    }


}
