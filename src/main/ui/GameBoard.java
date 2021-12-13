package ui;

import model.AIOpponent;
import model.GameState;
import model.SquareState;
import model.TicTacToeGame;
import model.exceptions.OccupiedPositionException;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static model.SquareState.O;
import static model.SquareState.X;

// Tic-Tac-Toe game
public class GameBoard {

    private TicTacToeGame game;
    private AIOpponent ai;
    private Scanner input;
    private SquareState player = X;
    private SquareState opponent = O;
    private static final String SPACE = "   ";

    // EFFECTS:runs the
    public GameBoard() throws InterruptedException {
        runGame();
    }

    private void runGame() throws InterruptedException {
        init();

        displayGameBoard();
        while (game.getGameState() == GameState.PLAYING) {
            doPlayerMove();
            displayGameBoard();
            if (game.getGameState() == GameState.PLAYING) {
                TimeUnit.MILLISECONDS.sleep(1000);
                doAIMove();
                displayGameBoard();
            }
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        endMessage();
    }

    private void init() {
        game = new TicTacToeGame();
        ai = new AIOpponent(game);
        ai.setPiece(opponent);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void displayGameBoard() {
        List<SquareState> board = game.getBoard();
        for (int i = 0; i < 9; i++) {
            SquareState next = board.get(i);
            System.out.print(next.piece + SPACE);
            if ((i + 1) % 3 == 0) {
                System.out.println("\n");
            }
        }
    }

    private void doPlayerMove() {
        System.out.println("Place next piece at position:");
        String command = input.next();
        int position = Integer.parseInt(command);
        try {
            game.placePiece(player, position);
        } catch (OccupiedPositionException e) {
            System.out.println("That position is occupied.");
            doPlayerMove();
        }
    }

    private void doAIMove() {
        System.out.println("Opponent's move");
        ai.move(game.getBoard());
    }

    private void endMessage() {
        System.out.println(game.getGameState().message);
    }
}
