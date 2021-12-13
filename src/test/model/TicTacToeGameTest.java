package model;

import model.exceptions.OccupiedPositionException;
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
        try {
            game.placePiece(SquareState.X, 0);
        } catch (OccupiedPositionException e) {
            fail("shouldn't get here");
        }
        assertEquals(9, board.size());
        assertTrue(board.contains(SquareState.X));
    }

    @Test
    void testPlacePieceFirstO() {
        try {
            game.placePiece(SquareState.O, 0);
        } catch (OccupiedPositionException e) {
            fail("shouldn't get here");
        }
        assertEquals(9, board.size());
        assertTrue(board.contains(SquareState.O));
    }

    @Test
    void testPlacePieceMany() {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                try {
                    game.placePiece(SquareState.X, i);
                } catch (OccupiedPositionException e) {
                    fail("shouldn't get here");
                }
            } else {
                try {
                    game.placePiece(SquareState.O, i);
                } catch (OccupiedPositionException e) {
                    fail("shouldn't get here");
                }
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
        try {
            game.placePiece(SquareState.X, 0);
        } catch (OccupiedPositionException e) {
            fail("shouldn't get here");
        }
        List<SquareState> old = board;
        try {
            game.placePiece(SquareState.O, 0);
            fail("OccupiedPositionException was never thrown.");
        } catch (OccupiedPositionException e) {
            // Pass
        }
        assertEquals(old, board);
        assertFalse(board.contains(SquareState.O));
        assertTrue(game.getOPieces().isEmpty());

    }

}
