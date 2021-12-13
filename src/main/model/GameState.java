package model;

// Represents the four possible states of a game
public enum GameState {
    PLAYING ("Still playing..."), X_WINS ("You win!"), O_WINS ("You lose..."), DRAW ("It's a draw.");

    public final String message;

    GameState(String s) {
        message = s;
    }
}
