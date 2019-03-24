import java.util.*;

/**
 * Tic Tac Toe! The GameLogic class contains all necessary logic based method the main method needs to 
 * run the program. Including the creation of the array which is what is used to create the game board.
 * 
 * Jakob Wilter
 * March 9, 2018
 * CSS 142
 */

public class GameLogic {
    char [][] gameBoard = new char[3][3]; //Creates array for game board. 3x3.
    public void newBoard(char player, int row, int column) { //Resets and changes the board after a player has inputted coordinates.
        gameBoard[row][column] = player;
    }
    
    public void setArray() { //Creates empty values in each index within the array to hold coordinates for the game board. 
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                gameBoard[i][j]= ' ';
    }

    public boolean checkAllowed(int row, int column) { //Checks to see if the inputted coordinates are within the array and that the inputted coordinates haven't already been filled.
        if((row < 0 || column < 0) ||  (row > 2 || column > 2))
            return true;

        else if(gameBoard[row][column] == 'x' || gameBoard[row][column] == 'o')
            return true;
            
        return false;
    }
    
    public char changePlayer(char player) { //Method which changes players turn per marker placement.
        char nextTurn='n';
        if (player == 'o') {
            nextTurn='x';
        }
            
        if (player == 'x') {
            nextTurn='o';
        }
        
        return nextTurn;
    }

    public void displayBoard() //Game board outputted to console.
    {
        System.out.println("  0  " + gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2] + "\n    ~~|~|~~" + "\n  1  " + gameBoard[1][0] + "|" 
                            + gameBoard[1][1] + "|" + gameBoard[1][2] + "\n    ~~|~|~~" + "\n  2  " + gameBoard[2][0] + "|" + gameBoard[2][1] + "|" 
                            + gameBoard[2][2] + "\n  -  0 1 2 ");
    }
    
    public boolean checkForTie() { //If boolean method checkIfWinner() does not return true, boolean checkTie will end system if the players tie.
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if(gameBoard[i][j] == ' ')
                    return false;
        return true;
    }

    public boolean checkIfWinner() { //Checks for three marks in a row by the same player. If no statements return true, program continues.
        if(gameBoard [0][0] == gameBoard[1][0] && gameBoard[1][0] == gameBoard[2][0] && (gameBoard [0][0]=='x' || gameBoard [0][0] == 'o'))
            return true;
        else if(gameBoard [0][1] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][1] && (gameBoard [0][1]=='x' || gameBoard [0][1] == 'o'))
            return true;
        else if(gameBoard [0][2]== gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][2] && (gameBoard [0][2]=='x' || gameBoard[0][2] == 'o'))
            return true;
        else if(gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][1] == gameBoard[0][2] && (gameBoard[0][0]=='x' || gameBoard[0][0] == 'o'))
            return true;
        else if(gameBoard[1][0]== gameBoard[1][1] && gameBoard[1][1] == gameBoard[1][2] && (gameBoard[1][0]=='x' || gameBoard[1][0] == 'o'))
            return true;
        else if(gameBoard[2][0]== gameBoard[2][1] && gameBoard[2][1] == gameBoard[2][2] && (gameBoard[2][0]=='x' || gameBoard[2][0] == 'o'))
            return true;
        else if(gameBoard[0][0]== gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && (gameBoard[0][0] == 'x' || gameBoard[0][0] == 'o'))
            return true;
        else if(gameBoard[2][0]== gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && (gameBoard[2][0] == 'x' || gameBoard[2][0] == 'o'))
            return true;
        else
            return false;
    }
}