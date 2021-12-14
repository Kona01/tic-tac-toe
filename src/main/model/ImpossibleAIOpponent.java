package model;

import java.util.List;

public class ImpossibleAIOpponent {

    private TicTacToeGame game;
    private SquareState piece;

    public ImpossibleAIOpponent(TicTacToeGame game) {
        this.game = game;
    }

    public void setPiece(SquareState piece) {
        this.piece = piece;
    }

    public void move(List<SquareState> board) {

    }
}
