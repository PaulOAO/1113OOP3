public class TicTacToe {

    private final char[][] board;
    private char winner;
    private int movesCount;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        winner = ' ';
        movesCount = 0;
    }

    // 玩家下棋
    public boolean set(int row, int col, char player) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3)
            throw new IllegalArgumentException("Invalid position");
        if (player != 'X' && player != 'O')
            throw new IllegalArgumentException("Player must be X or O");
        if (board[row][col] != ' ')
            return false; // 該位置已被佔用

        board[row][col] = player;
        movesCount++;
        evaluate(); // 每下完一子就評估
        return true;
    }

    // 判斷遊戲結果
    public String evaluate() {
        // 檢查橫排
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                winner = board[i][0];
                return winner + "_WINS";
            }
        }

        // 檢查直排
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {
                winner = board[0][j];
                return winner + "_WINS";
            }
        }

        // 檢查對角線
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            winner = board[0][0];
            return winner + "_WINS";
        }
        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            winner = board[0][2];
            return winner + "_WINS";
        }

        // 檢查平手
        if (movesCount == 9) {
            winner = ' ';
            return "DRAW";
        }

        return "CONTINUE";
    }

    public char getWinner() {
        return winner;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}
