package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {

    public static final char PLAYER_SYMBOL = 'X';
    public static final char COMPUTER_SYMBOL = 'O';

    // Semua kombinasi kemenangan: baris, kolom, diagonal
    private static final int[][] WINNING_PATTERNS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // baris
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // kolom
        {0, 4, 8}, {2, 4, 6}             // diagonal
    };

    private final GameBoard board;
    private final Random random;

    public GameLogic() {
        this.board = new GameBoard();
        this.random = new Random();
    }

    public GameBoard getBoard() {
        return board;
    }

    //Reset board kalau sudah penuh
    public void resetGame() {
        board.reset();
    }


    public boolean makeMove(int index, char symbol) {
        return board.setCell(index, symbol);
    }

    //Cek apakah simbol yg dipilih sudah membentuk garis yg menandakan menang
    public boolean checkWinner(char symbol) {
        char[] cells = board.getCells();
        for (int[] pattern : WINNING_PATTERNS) {
            int a = pattern[0];
            int b = pattern[1];
            int c = pattern[2];
            if (cells[a] == symbol && cells[b] == symbol && cells[c] == symbol) {
                return true;
            }
        }
        return false;
    }

    //Cek seri atau tidak
    public boolean isDraw() {
        return board.isFull() && !checkWinner(PLAYER_SYMBOL) && !checkWinner(COMPUTER_SYMBOL);
    }

    //Buat nentuin langkah dari komputernya
    public int computerMove() {
        char[] cells = board.getCells();
        List<Integer> emptyIndexes = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == GameBoard.EMPTY_CELL) {
                emptyIndexes.add(i);
            }
        }
        if (emptyIndexes.isEmpty()) {
            return -1;
        }
        int randomPick = random.nextInt(emptyIndexes.size());
        return emptyIndexes.get(randomPick);
    }
}
