import java.util.Scanner;
/**
 * Tic Tac Toe! The Super class for the game containing the main method and the variable tester.
 * 
 * Jakob Wilter
 * March 9, 2018
 */
public class SuperClass {
    public static void main(String[] args) {
        Scanner keyboard =  new Scanner (System.in);
        GameLogic game = new GameLogic (); //calls GameLogic class to SuperClass allowing GameLogic methods and logic to be used.
        
        int row,column; //Initializes row and column to later be used to input coordinates for marker placement.
        char player = 'o'; //Initializes player to be used later for 'x' and 'o'.
        
        //testVariables(player);
        
        game.setArray();
        
        System.out.println("Game set\nStart!\n");
        game.displayBoard(); //Prints the first board to the screen prior to a marker being placed so users can visualize the board prior to inputting coordinates.

        while(true) {
            player = game.changePlayer(player); //Rotates players' turns after a marker has been placed by the prior user. Order: X O X O X O ...
            System.out.print("\n" + player + " turn: Choose your location, row then column!\n");
            row = keyboard.nextInt();
            column = keyboard.nextInt();

            while (game.checkAllowed(row,column)) { //If user input is illegal, statement will print stating so and asking player to try again.
                System.out.println("The slot has already been taken or is out of bounds. Please try again (row, column).");
                game.displayBoard();
                row = keyboard.nextInt();
                column = keyboard.nextInt();
            }
            game.newBoard(player,row,column);
            game.displayBoard();

            if(game.checkIfWinner()) { //Checks if the game is won. If so, outputs a print statement with the winner and ends the program.
                System.out.println("\nThe winner is player "+ player + " !");
                break;
            }
            if(game.checkForTie()) { //Checks if the game has resulted in a tie. If so, outputs a print statement and ends the program.
                System.out.println("\nIt's a tie.");
                break;
            }
        }
    }
    
    //Tests that variables and methods are outputted to screen correctly.
    /**
     * public static void testVariables (char player) { 
     *  GameLogic game = new GameLogic ();
     *  game.displayBoard();
     *  System.out.println(player);
     * }
     **/
}