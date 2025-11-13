import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    @Test
    public void testOWins() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'O');
        game.set(1, 0, 'X');
        game.set(0, 1, 'O');
        game.set(1, 1, 'X');
        game.set(0, 2, 'O'); // O 勝利

        assertEquals("O_WINS", game.evaluate());
        assertEquals('O', game.getWinner());
    }

    @Test
    public void testXWinsDiagonal() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        game.set(0, 1, 'O');
        game.set(1, 1, 'X');
        game.set(0, 2, 'O');
        game.set(2, 2, 'X'); // X 對角勝利

        assertEquals("X_WINS", game.evaluate());
        assertEquals('X', game.getWinner());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        game.set(0, 1, 'O');
        game.set(0, 2, 'X');
        game.set(1, 1, 'O');
        game.set(1, 0, 'X');
        game.set(1, 2, 'O');
        game.set(2, 0, 'O');
        game.set(2, 2, 'X');
        game.set(2, 1, 'O');
        assertEquals("DRAW", game.evaluate());
    }

    @Test
    public void testInvalidMove() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0, 'X');
        assertFalse(game.set(0, 0, 'O')); // 該格已被佔用
    }
}
