package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BasketballPlayer extends Player{

    private Double height;

    public BasketballPlayer(String name, String surname, Integer number, Double height) {
        super(name, surname, number);
        this.height = height;
    }


}
