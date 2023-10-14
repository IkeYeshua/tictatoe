package Test;

import static Test.Mark.E;

public class Player {
   private String name;
   private Mark playerMark;

   public  Player(String name, Mark playerMark) {
           this.name = name;
           this.playerMark = playerMark;

   }

    public void playGame(int position, Board board) {
       if (position < 1 || position > 9) throw new InvalidPositionException("You can only play between 1 - 9");
       int playersPosition = position - 1;
       int row = playersPosition / 3;
       int col = playersPosition % 3;

         Mark[][] gameBoard = board.getBoard();
         if (gameBoard[row][col] == E) gameBoard[row][col] = playerMark;
              else throw new InvalidPositionException("The position is already occupied");

    }

    public Mark getMark() {
       return playerMark;
    }
}
