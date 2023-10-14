package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static Test.Mark.*;
import static org.junit.jupiter.api.Assertions.*;

public class TictactoeTest {
   private Player player1;
   private Player player2;
   private Board board;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Joe", X );
        player2 = new Player("John", O);
        board = new Board();
    }

    @Test
    public  void testThatPlayer1Exist() {
        assertNotNull(player1);
    }

    @Test
    public void testThatPlayer2Exist() {
        assertNotNull(player2);
    }
    @Test
    public void testThatPlayer1HasMarkX() {
        assertSame(player1.getMark(), X);
    }

    @Test
    public void testThatPlayer2HasMarkO() {
        assertSame(player2.getMark(), O);
    }
    @Test
    public void testThatBoardExist() {
        assertNotNull(board);
    }
    @Test
    public void testThatBoardIsEmpty(){
        Mark[][] marks = board.getBoard();
//        assertEquals(E, marks[0][0]);
//        assertEquals(E, marks[0][1]);
        for (int row = 0; row < marks.length; row++){
            for (int col = 0; col < marks[row].length; col++){
                assertEquals(E, marks[row][col]);
            }
        }
    }
   @Test
    public void testThatPlayer1CanPlay() {
        player1.playGame(1, board);
        Mark[][] gameBoard = board.getBoard();
        assertEquals(X, gameBoard[0][0]);
    }
    @Test
    public void testThatPlayer2CanPlay() {
        player2.playGame(1, board);
        Mark[][] gameBoard = board.getBoard();
        assertEquals(O, gameBoard[0][0]);
    }
    @Test
    public void testThatAPlayerCanNotPlayOutOfRange() {
        assertThrows(InvalidPositionException .class, () -> player1.playGame(0,board));
        assertThrows(InvalidPositionException .class, () -> player2.playGame(0,board));
    }
    @Test
    public void testThatAPlayerCanNotPlayInANonEmptyPosition() {
        player2.playGame(3,board);
       assertThrows(InvalidPositionException.class, () -> player1.playGame(3,board));

        //Mark[][] gameBoard = board.getBoard();
       // assertEquals(X, gameBoard[0][2]);

    }
}
