package model;

import model.exceptions.OccupiedPositionException;

import java.util.ArrayList;
import java.util.List;

// Represents a tic-tac-toe game
public class TicTacToeGame {

    private List<SquareState> board;
    private List<Integer> xpieces;
    private List<Integer> opieces;
    private GameState gameState;

    // EFFECTS: creates a new tic-tac-toe game with an empty board and a playing state
    public TicTacToeGame() {
        board = new ArrayList<>();
        xpieces = new ArrayList<>();
        opieces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            board.add(SquareState.BLANK);
        }
        gameState = GameState.PLAYING;
    }

    public List<SquareState> getBoard() {
        return board;
    }

    public List<Integer> getXPieces() {
        return xpieces;
    }

    public List<Integer> getOPieces() {
        return opieces;
    }

    public GameState getGameState() {
        return gameState;
    }

    // REQUIRES: piece is either X or O, SquareState at position is BLANK
    // MODIFIES: this
    // EFFECTS: changes SquareState at position to piece, and adds position to list of x or o piece locations
    public void placePiece(SquareState piece, int position) throws OccupiedPositionException {
        if (board.get(position) != SquareState.BLANK) {
            throw new OccupiedPositionException();
        }
        board.set(position, piece);
        if (piece == SquareState.X) {
            xpieces.add(position);
        } else if (piece == SquareState.O) {
            opieces.add(position);
        }
        checkForGameFinished();
    }

    // MODIFIES: this
    // EFFECTS: checks to see if the game is over, and changes gameState accordingly
    private void checkForGameFinished() {
        for (WinCombo wc : WinCombo.values()) {
            if (xpieces.containsAll(wc.getPositions())) {
                gameState = GameState.X_WINS;
                return;
            } else if (opieces.containsAll(wc.getPositions())) {
                gameState = GameState.O_WINS;
                return;
            }
        }
        if (!board.contains(SquareState.BLANK)) {
            gameState = GameState.DRAW;
        }
    }
}
