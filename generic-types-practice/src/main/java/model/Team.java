package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team<T extends Player> implements Comparable<Team> {

    private String name;
    private Integer won = 0;
    private Integer estimatedYear;
    private ArrayList<T> players;

    public Team(String name, Integer estimatedYear) {
        this.name = name;
        this.won = 0;
        this.estimatedYear = estimatedYear;
        players = new ArrayList<>();
    }

    public boolean addPlayer(T player) {
        players.add(player);
        return true;
    }

    public void playMatch(Team<T> opponentTeam, Integer ourScore, Integer theirScore) {

        if(ourScore > theirScore) {
            won++;
        }
        else if(ourScore == theirScore) {
            System.out.println("It was a draw");
            return;
        }
        else {
//            opponentTeam.setWon(opponentTeam.getWon()+1);
        }

    }


    @Override
    public int compareTo(Team team) {
        if(this.getWon() < team.getWon()) {
            return -1;
        }
        else if(this.getWon() > team.getWon()) {
            return 1;
        }
        return 0;
    }
}
