package model;

public abstract class AIOpponent {

    protected TicTacToeGame game;
    protected SquareState piece;

    public AIOpponent(TicTacToeGame game) {
        this.game = game;
    }

    public void setPiece(SquareState piece) {
        this.piece = piece;
    }

    public abstract void move(TicTacToeGame game);

}
