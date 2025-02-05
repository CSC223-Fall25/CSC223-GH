package csc223.gh;
import java.util.Scanner;

public class WordGuess implements Game {
    Scanner scanner = new Scanner(System.in);
    boolean guessed = false;
    String mysteryWord = "";
    char[] letters = new char[5];
    char[] board = {'_','_','_','_','_'};
    int turns = 5;
    String[] wordbank = {"happy",
    "coder", "stare", "magic",
    "phone", "water", "teach",
    "ready", "buggy", "stand"};

    public void startGame(){
        guessed = false;
        mysteryWord = wordbank[(int)(Math.random()*wordbank.length)];
        letters = mysteryWord.toCharArray();
    }

    public boolean isGameOver(){
        return guessed==true;
    }
    public void printBoard(){
        System.out.println(board);
    }
    public void endGame(){
        if (isGameOver()==true){
            System.out.println("Play again? (y/n):");
            String another_game = scanner.nextLine();
            if (another_game.equals("y")){
                playGame();
            }
            else if (another_game.equals("n")){
                System.out.println("Have a nice day");
                System.exit(0);

            }
        }
        
    }
    public void takeTurn(){
        int lives = turns;
        while (lives>0){
            System.out.println("Tries: " + lives);
            System.out.println("Guess a word:");
            String guess = scanner.nextLine();


            if (guess.equals(mysteryWord)){
                guessed=true;
                System.out.println("You win!");

                endGame();
            }

            else if (guess != mysteryWord){
                lives -= 1;
                char[] guess_array = guess.toCharArray();
                for (int i =0; i<5; i++){
                    for (int j=0; j<5; j++){
                        if (guess_array[i] == letters[j]){
                            board[j] = guess_array[i];
                        }
                    }
                    
                }
            }
            printBoard();
        }
        endGame();

        

        
    }
    public void playGame(){
        startGame();
        takeTurn();
        
    }
    public static void main(String[] args){
        WordGuess test = new WordGuess();
        test.playGame();
        test.scanner.close();
    }
}
