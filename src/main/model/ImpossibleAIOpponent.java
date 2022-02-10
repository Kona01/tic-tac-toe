package model;

import model.exceptions.OccupiedPositionException;

import java.util.ArrayList;
import java.util.List;

public class ImpossibleAIOpponent extends AIOpponent {

    public ImpossibleAIOpponent(TicTacToeGame game) {
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
        Integer choice = chooseMove(game, positions);
        try {
            game.placePiece(piece, choice);
        } catch (OccupiedPositionException e) {
            System.out.println("Should never get here...");
        }
    }

    private Integer chooseMove(TicTacToeGame game, List<Integer> positions) {
        if (positions.size() == 1) {
            return positions.get(0);
        }
        int choice;
        for (int pos : positions) {
            TicTacToeGame attempt = new TicTacToeGame();
        }
        return -1;
    }
}
