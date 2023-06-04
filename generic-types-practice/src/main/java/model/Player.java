package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {

    private String name;
    private String surname;
    private Integer number;

    static Long uniquePlayersCount(List<Player> team1, List<Player> team2) {

        return Stream.of(team1, team2)
                .flatMap(List::stream)
                .distinct()
                .count();
    }


    public static Long uniquePlayersWithoutStreams(List<Player> players1, List<Player> players2) {

        Long uniquePlayersCount = 0L;
        for(Player player : players1) {
            if(!players2.contains(player)) {
                uniquePlayersCount++;
            }
        }
        for(Player player : players2) {
            uniquePlayersCount++;
        }

        return uniquePlayersCount;
    }
















}
