package csc223.gh;
import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe implements Game {
    Scanner scanner = new Scanner(System.in);
    char[][] grid = {{'-','-','-'},
                     {'-','-','-'},
                     {'-','-','-'}};
    char turn = 'x';
    int x;
    int y;
    String winner = "Tie";

    public void startGame(){
        for(int i=0;i<3;i++){
            Arrays.fill(grid[i],'-');
        }
      
        turn = 'x';
        winner = "Tie";
    }

    public void endGame(){
        if (isGameOver()==true){
            printBoard();
            System.out.println("Winner:" + winner);
            System.exit(0);
        }

    }

    public void printBoard(){
        for (int i=0;i<3;i++){
            System.out.println(grid[i]);
        }

    }

    public boolean isGameOver(){
        boolean isClogged = true;
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (grid[i][j]=='-'){
                    isClogged=false;
                    break;
                }
            }
        }

        if (isClogged==true || winner!="Tie"){
            return true;
        }
        return false;
    }

    public void takeTurn(){
        boolean occ = false;
        while (isGameOver()==false){
            if (turn=='x'){
                printBoard();
                System.out.println("Player X, enter your X coordinate");
                x = scanner.nextInt();
                System.out.println("Player X, enter your Y coordinate");
                y = scanner.nextInt();
                if (grid[y][x]=='-'){
                    grid[y][x] = 'x';
                    occ=false;
                }
                else{
                    System.out.println("Occupied coordinates. Try again.");
                    occ=true;
                }
                if (occ==false){

                
                    if (grid[y][0]==turn && grid[y][1]==turn && grid[y][2]==turn){
                        winner="x";
                        endGame();
                    } 
                    else if (grid[0][x]==turn && grid[1][x]==turn && grid[2][x]==turn){
                        winner="x";
                        endGame();
                    }
                    else if (grid[0][0]==turn && grid[1][1]==turn && grid[2][2]==turn){
                        winner="x";
                        endGame();
                    }
                    else if (grid[0][2]==turn && grid[1][1]==turn && grid[2][0]==turn){
                        winner="x";
                        endGame();
                    }
                    else{
                        turn = 'o';
                    }
                }
            }
            else if (turn=='o'){
                printBoard();
                System.out.println("Player O, enter your X coordinate");
                x = scanner.nextInt();
                System.out.println("Player O, enter your Y coordinate");
                y = scanner.nextInt();
                if (grid[y][x]=='-'){
                    grid[y][x] = 'o';
                    occ=false;
                }
                else{
                    System.out.println("Occupied coordinates. Try again.");
                    occ=true;
                }
                if (occ==false){
                    if (grid[y][0]==turn && grid[y][1]==turn && grid[y][2]==turn){
                        winner="o";
                        endGame();
                    } 
                    else if (grid[0][x]==turn && grid[1][x]==turn && grid[2][x]==turn){
                        winner="o";
                        endGame();
                    }
                    else if (grid[0][0]==turn && grid[1][1]==turn && grid[2][2]==turn){
                        winner="o";
                        endGame();
                    }
                    else if (grid[0][2]==turn && grid[1][1]==turn && grid[2][0]==turn){
                        winner="o";
                        endGame();
                    }
                    else{
                        turn = 'x';
                    }
                }
            }
        }
       
        
    }
    public void playGame(){
        startGame();
        takeTurn();

    }

    public static void main(String[] args){
        TicTacToe test = new TicTacToe();
        test.playGame();
        test.scanner.close();
    }
}