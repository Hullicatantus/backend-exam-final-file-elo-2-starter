package com.codecool.chessopen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        List<String> raw;
        List<ChessPlayer> chessPlayers = new ArrayList<>();
        try {
            raw = Files.readAllLines(Paths.get(fileName));
            for (int i = 0; i < raw.size(); i++) {
             chessPlayers.add(getChessPlayer(raw.get(i)));
            }
        } catch (IOException ioException) {
            System.out.println("File not found!");
        }
        return chessPlayers.stream()
                .sorted(Comparator.comparingInt(ChessPlayer::getPoint).reversed())
                .map(ChessPlayer::getName)
                .collect(Collectors.toList());
    }

    private static ChessPlayer getChessPlayer(String line) {
        String[] chessPlayerExam = line.split(",");
        return new ChessPlayer(chessPlayerExam[0],
                Integer.parseInt(chessPlayerExam[1]) 
                        + Integer.parseInt(chessPlayerExam[2])
                        + Integer.parseInt(chessPlayerExam[3])
                        + Integer.parseInt(chessPlayerExam[4])
                        + Integer.parseInt(chessPlayerExam[5]));
    }
}
    
