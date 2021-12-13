package model;

import model.exceptions.OccupiedPositionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIOpponent {

    private TicTacToeGame game;
    private SquareState piece;

    public AIOpponent(TicTacToeGame game) {
        this.game = game;
    }

    public void setPiece(SquareState piece) {
        this.piece = piece;
    }

    public void move(List<SquareState> board) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board.get(i) == SquareState.BLANK) {
                positions.add(i);
            }
        }
        Integer choice = new Random().nextInt(positions.size());
        try {
            game.placePiece(piece, positions.get(choice));
        } catch (OccupiedPositionException e) {
            System.out.println("Should never get here...");
        }
    }

}
