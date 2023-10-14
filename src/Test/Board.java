package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Test.Mark.*;

public class Board {
    private static Mark[][] board = new Mark[3][3];

    public Board( ){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                board[row][col] = E;
            }
        }
    }


    public Mark[][] getBoard() {
        return board;
    }


    public static void main(String[] args) {
        showGameBoard();
    }

    public static void showGameBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (j == board[i].length - 1) {
                    System.out.print(board[i][j]);
               }else {
                    System.out.print(board[i][j]);
                    System.out.print(" | ");
               }
            }
            System.out.println();
        }
    }

    public boolean checkRowZero() {
        if (board[0][0] == X && board[0][1] == X && board[0][2] == X){
            return true;
        }else if(board[0][0] == O && board[0][1] == O && board[0][2] == O){
            return true;
        }
        return false;
    }
    public boolean checkRowOne() {
        if (board[1][0] == X && board[1][1] == X && board[1][2] == X){
            return true;
        }else if(board[1][0] == O && board[1][1] == O && board[1][2] == O){
            return true;
        }
        return false;
    }
    public boolean checkRowTwo() {
        if (board[2][0] == X && board[2][1] == X && board[2][2] == X){
            return true;
        }else if (board[2][0] == O && board[2][1] == O && board[2][2] == O){
            return true;
        }
        return false;
    }

    public boolean checkColumnZero() {
        if (board[0][0] == X && board[1][0] == X && board[2][0] == X){
            return true;
        }else if(board[0][0] == O && board[1][0] == O && board[2][0] == O){
            return true;
        }
        return false;
    }

    public boolean checkColumnOne() {
        if (board[0][1] == X && board[1][1] == X && board[2][1] == X){
            return true;
        }else if(board[0][1] == O && board[1][1] == O && board[2][1] == O){
            return true;
        }
        return false;
    }

    public boolean checkColumnTwo() {
        if (board[0][2] == X && board[1][2] == X && board[2][2] == X){
            return true;
        }else if(board[0][2] == O && board[1][2] == O && board[2][2] == O){
            return true;
        }
        return false;
    }

    public boolean checkFirstDiagonal() {
        if (board[0][0] == X && board[1][1] == X && board[2][2] == X){
            return true;
        }else if(board[0][0] == O && board[1][1] == O && board[2][2] == O){
            return true;
        }
        return false;
    }

    public boolean checkSecondDiagonal() {
        if (board[0][2] == X && board[1][1] == X && board[2][0] == X){
            return true;
        }else if(board[0][2] == O && board[1][1] == O && board[2][0] == O){
            return true;
        }
        return false;
    }

    public boolean determineWinner(){
        if (checkRowZero()) return true;
        else if (checkRowOne()) return true;
        else if (checkRowTwo()) return true;
        else if (checkColumnZero()) return true;
        else if (checkColumnOne()) return true;
        else if (checkColumnTwo()) return true;
        else if (checkFirstDiagonal()) return true;
        else return checkSecondDiagonal();
    }
    public boolean gameIsATie(){
        boolean value = false;
        Mark[][] board = getBoard();
        List<Mark> arr = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            Collections.addAll(arr, board[i]);
        }
        if (!(arr.contains(E))) value = true;
        return value;
    }
    public void resetBoard(){
        for (Mark[] marks : board) {
            Arrays.fill(marks, E);
        }
    }

}
