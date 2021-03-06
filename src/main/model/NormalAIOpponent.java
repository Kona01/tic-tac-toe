package model;

import model.exceptions.OccupiedPositionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NormalAIOpponent extends AIOpponent{

    public NormalAIOpponent(TicTacToeGame game) {
        super(game);
    }

    public void move(TicTacToeGame game) {
        List<SquareState> board = game.getBoard();
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
