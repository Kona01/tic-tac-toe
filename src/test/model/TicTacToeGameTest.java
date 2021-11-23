package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {
    private TicTacToeGame game;
    private List<SquareState> board;

    @BeforeEach
    void setup() {
        game = new TicTacToeGame();
        board = game.getBoard();
    }

    @Test
    void testPlacePieceFirstX() {
        game.placePiece(SquareState.X, 0);
        assertEquals(9, board.size());
        assertTrue(board.contains(SquareState.X));
    }

    @Test
    void testPlacePieceFirstO() {
        game.placePiece(SquareState.O, 0);
        assertEquals(9, board.size());
        assertTrue(board.contains(SquareState.O));
    }

    @Test
    void testPlacePieceMany() {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                game.placePiece(SquareState.X, i);
            } else {
                game.placePiece(SquareState.O, i);
            }
        }
        assertEquals(9, board.size());
        assertTrue(board.contains(SquareState.X));
        assertTrue(board.contains(SquareState.O));
        assertEquals(3, game.getXPieces().size());
        assertEquals(3, game.getOPieces().size());
    }

    @Test
    void testPlacePieceOccupied() {
        game.placePiece(SquareState.X, 0);
        List<SquareState> old = board;
        game.placePiece(SquareState.O, 0);
        assertEquals(old, board);
        assertFalse(board.contains(SquareState.O));
        assertTrue(game.getOPieces().isEmpty());

    }

}
