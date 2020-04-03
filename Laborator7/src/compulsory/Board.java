package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    List<Token> tokenList;
    List<Player> players;
    private int tokens;

    public Board(int tokeni) {
        this.tokens = tokeni;
        this.tokenList = new ArrayList<>(tokeni);
        for (int i = 1; i <= tokens; i++) {
            tokenList.add(new Token(i));
        }
        this.tokenList = Collections.synchronizedList(tokenList);
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void displayWinner(List<Player> players) {
        for (Player player : players) {
            int flag = 1;
            if (player.getTokenList().size() <= 2) {
                flag = 0;       //necastigator, a extras prea putine numere pentru a forma o progresie aritmetica
            } else {
                Token first = player.getTokenList().get(0);
                Token second = player.getTokenList().get(1);
                player.getTokenList().remove(0);
                player.getTokenList().remove(0);
                int predecesor = second.getValue();
                int ratia = second.getValue() - first.getValue();

                for (int i = 0; i < player.getTokenList().size(); i++) {
                    int r = player.getTokenList().get(i).getValue() - predecesor;
                    predecesor = player.getTokenList().get(i).getValue();
                    if (ratia != r) {
                        flag = 0;
                    }
                }
            }
            if (flag == 0) {
                System.out.println(player.getName() + " - necastigator!");
            } else System.out.println(player.getName() + " - castigator, a format o progresie aritmetica!");
        }
    }

}
