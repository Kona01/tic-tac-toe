package model;

// Represents the three states of a square on the board
public enum SquareState {
    X ("X"), O ("O"), BLANK ("+");

    public final String piece;

    SquareState(String s) {
        piece = s;
    }
}
