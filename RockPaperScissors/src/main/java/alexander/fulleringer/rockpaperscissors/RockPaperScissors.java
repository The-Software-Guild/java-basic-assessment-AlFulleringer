 /**
  *@author Alexander Fulleringer
  *email: alexander.fulleringer@mail.mcgill.ca
  *date: 2021-07-27
  *purpose: RPS Assessment Code
  */
package alexander.fulleringer.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    
    public static void main(String[] args){
        
        System.out.println("Let's play Rock Paper Scissors!");
        do{
            playGame(getRounds());
        }while(keepPlaying());
        System.out.println("Thanks for playing!");
        
    }
    
    public static void playGame(int numRounds){
        int ties = 0;
        int playerWins = 0;
        int compWins = 0;
        int playerMove;
        int compMove;
        
        for( int i =0; i < numRounds; i++){
            
            playerMove = getMove();
            compMove = r.nextInt(3)+1;
            
            if (playerMove == compMove){
                ties++;
                System.out.println("It was a tie!");
                
            }
            else if (playerMove == 1 && compMove == 3){
                playerWins++;
                System.out.println("You win!");
                
            }
            else if (playerMove == 2 && compMove == 1){
                playerWins++;
                System.out.println("You win!");
                
            }
            else if (playerMove == 3 && compMove == 2){
                playerWins++;
                System.out.println("You win!");
                ;
            }
            else{
                System.out.println("You lose! :(");
                compWins++;
            }
        }
        printResults(ties, playerWins, compWins);
    }
    
    public static int getRounds(){
        System.out.println("How many rounds would you like to play? Please input a number from 1 to 10.");
        
        int numRounds = sc.nextInt();
        
        if (numRounds > 10 || numRounds < 1){
            System.out.println("Invalid input value for the number of rounds. Exiting now.");
            System.exit(0);
        }
        
        return numRounds;
    }
    
    public static int getMove(){
        System.out.println("What's your move? Input a 1 for Rock, 2 for Paper, and 3 for Scissors.");
        int move = sc.nextInt();
        if (move > 3 || move < 1){
            System.out.println("Invalid input value for your move. Exiting now.");
        }
        return move;
    }
    
    public static void printResults(int ties, int playerWins, int compWins){
        System.out.println("Ties: " + ties);
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + compWins);
        
        if( playerWins > compWins){
            System.out.println("You win!");
        }
        else if( playerWins < compWins){
            System.out.println("The computer wins!");
        }
        else{
            System.out.println("It was a tie!");
        }
    }
    public static boolean keepPlaying(){
        System.out.println("Would you like to keep playing? Please say Yes or No");
        String s = sc.next();
        return s.equals("Yes");
    }
    
}
