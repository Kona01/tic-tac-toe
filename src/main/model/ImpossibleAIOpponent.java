package model;

import javafx.util.Pair;
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
        Integer choice;
        if (positions.size() == 1) {
            choice = positions.get(0);
        } else {
            TicTacToeGame test = new TicTacToeGame(game);
            choice = chooseMove(test, positions, piece).getKey();
        }
        try {
            game.placePiece(piece, choice);
        } catch (OccupiedPositionException e) {
            System.out.println("Should never get here...");
        }
    }

    private Pair<Integer,Integer> chooseMove(TicTacToeGame game, List<Integer> positions, SquareState player) {
        if (game.getGameState() == GameState.O_WINS) {
            if (piece == SquareState.O) {
                return new Pair<>(-1, 1); // ai win
            } else {
                return new Pair<>(-1, -1); // ai loss
            }
        } else if (game.getGameState() == GameState.X_WINS) {
            if (piece == SquareState.X) {
                return new Pair<>(-1, 1); // ai win
            } else {
                return new Pair<>(-1, -1); // ai loss
            }
        } else if (game.getGameState() == GameState.DRAW) {
            return new Pair<>(-1,0); // draw
        }

        List<Pair<Integer,Integer>> moves = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            TicTacToeGame attempt = new TicTacToeGame(game);
            List<Integer> remainingPositions = new ArrayList<>(positions);
            Integer pos = positions.get(i);
            remainingPositions.remove(i);
            try {
                attempt.placePiece(player, pos);
            } catch (OccupiedPositionException e) {
                System.out.println("Should never get here...");
            }
            Pair<Integer,Integer> result;
            if (player == piece) {
                SquareState other = piece == SquareState.O ? SquareState.X : SquareState.O;
                result = chooseMove(attempt, remainingPositions, other);
            } else {
                result = chooseMove(attempt, remainingPositions, piece);
            }
            Pair<Integer,Integer> move = new Pair<>(pos, result.getValue());
            moves.add(move);
        }
        int bestScore;
        Pair<Integer,Integer> bestMove = null;
        if (player == piece) {
            bestScore = Integer.MIN_VALUE;
            for (Pair<Integer,Integer> m : moves) {
                if (m.getValue() > bestScore) {
                    bestScore = m.getValue();
                    bestMove = m;
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (Pair<Integer,Integer> m : moves) {
                if (m.getValue() < bestScore) {
                    bestScore = m.getValue();
                    bestMove = m;
                }
            }
        }

        return bestMove;
    }

//    private Integer BestMove(List<Integer> positions) {
//        TicTacToeGame test = new TicTacToeGame(game);
//        List<Pair<Integer,Integer>> moves = chooseMove(test, positions, piece);
//        Pair<Integer,Integer> best = new Pair<>(-1,Integer.MIN_VALUE);
//        for (int i = 0; i < moves.size(); i++) {
//            if (moves.get(i).getValue() > best.getValue()) {
//                best = moves.get(i);
//            }
//        }
//        return best.getKey();
//    }
}
