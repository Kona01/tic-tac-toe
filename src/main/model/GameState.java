package model;

// Represents the four possible states of a game
public enum GameState {
    PLAYING ("Still playing..."), X_WINS ("You win!"), O_WINS ("You lose..."), DRAW ("It's a draw.");

    public String message;

    GameState(String s) {
        message = s;
    }

    public void setMessage(String s) {
        message = s;
    }
}
