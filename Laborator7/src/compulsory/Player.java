package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private List<Token> tokenList;
    private Board board;

    public Player(String name, Board board) {
        this.name = name;
        this.tokenList = new ArrayList<>();
        this.tokenList = Collections.synchronizedList(tokenList);
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public synchronized Token getToken() {
        if (!board.tokenList.isEmpty()) {
            Token token = board.tokenList.get(0);       //tokenii vor fi asezati ca intr-o stiva
            board.tokenList.remove(0);            //se va extrage mereu primul token
            return token;
        }
        return null;
    }

    @Override
    public void run() {
        Token token = getToken();
        while (token != null) {
            System.out.println(this.name + " extrage: " + token.getValue());
            this.tokenList.add(token);
            token = getToken();
        }
    }

    public void printPlayer() {
        System.out.println(this.name + " a extras urmatorii tokeni: ");
        for (Token token : tokenList) {
            System.out.print(token.getValue() + " ");
        }
        System.out.println();
    }
}