package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(8);
        List<Player> players = new ArrayList<>();

        Player player1 = new Player("Vladut", board);
        Player player2 = new Player("Ionut", board);
        Player player3 = new Player("Mihut", board);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        Thread thread3 = new Thread(player3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        player1.printPlayer();
        player2.printPlayer();
        player3.printPlayer();

        players.add(player1);
        players.add(player2);
        players.add(player3);
        board.displayWinner(players);
    }
}