package com.codecool.chessopen;

public class ChessPlayer {
   private String name;
   private int point;

    public ChessPlayer(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
