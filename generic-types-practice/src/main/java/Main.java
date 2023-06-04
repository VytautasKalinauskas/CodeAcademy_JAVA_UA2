import model.BasketballPlayer;
import model.FootballPlayer;
import model.Player;
import model.Team;

public class Main {

    public static void main(String[] args) {
        System.out.println("hey");

        BasketballPlayer sabonis = new BasketballPlayer("Arvydas", "Sabonis", 11, 2.20);
        BasketballPlayer jasikevicius = new BasketballPlayer("Sarunas", "Jasikevicius", 13, 1.92);

        Team<BasketballPlayer> zalgiris = new Team<>("Zalgiris", 1922);
        zalgiris.addPlayer(sabonis);
        zalgiris.addPlayer(jasikevicius);

        Team<BasketballPlayer> rytas = new Team<>("Rytas", 1992);
        BasketballPlayer echodas = new BasketballPlayer("Martynas", "Echodas", 12, 2.10);

//        rytas.playMatch(zalgiris, 80, 69);
//        rytas.getWon() == 1;



        FootballPlayer ronaldo = new FootballPlayer("Cristiano", "Ronaldo", 7, 0.86);
        FootballPlayer benzema = new FootballPlayer("Karim",  "Benzema", 11, 0.90);

        Team<FootballPlayer> realMadrid = new Team<>();
        realMadrid.addPlayer(ronaldo);
        realMadrid.addPlayer(benzema);

        Team<Player> allPlayers = new Team<>();
        allPlayers.addPlayer(sabonis);
        allPlayers.addPlayer(ronaldo);


    }

}
