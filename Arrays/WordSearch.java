// Noah Watson
// 1/24/2024
// Assignment 1: Word Search Generator
// Program allows user to generate a word search, print the word search for the user, and display the solution 
// The Solution print modifies the grid so that the original print no longer prints with letters. Ran out of time to see if that could be overrode.
// I wasn't sure if I needed to email you beforehand but I forgot to do it anyway. I'm assuming you can guess, but I'm using 2 of my 5 late days for this assignment.
// Extra Credit: I did succeed with the implementation of the words generating in 8 directions. With some possibly redundant code?

import java.util.*;

public class WordSearch {

    private Scanner in = new Scanner(System.in);
    private Random random = new Random();
    private boolean[][] filled;
    private char[][] grid;
    private int gridSize;
    private String word;
    public WordSearch() {}

    public char printIntro() { // this method will print the intro to the program. Acts as our "menu"
            System.out.println("Welcome to my word search generator!");
            System.out.println("This program will allow you to generate your own word search puzzle");
            System.out.println("Please select an option:");
            System.out.println("Generate a new word search (g)");
            System.out.println("Print out your word search (p)");
            System.out.println("Show the solution to your word search (s)");
            System.out.println("Quit the program (q)");
            System.out.print("Your selection: ");
            String input = in.next();
            char selection = input.charAt(0);
            System.out.println();
            return selection;
        }

    public void generate() { // this method will do a bulk of the work, including receiving words from the user as well as placing them into a grid.
        int longestWord = 0; // store length of longest word for grid sizing
        System.out.print("How many words would you like to have in your word search? ");
        int numWords = in.nextInt();
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) { // this section gathers all the user input we will need
            System.out.print("Input word to add to Word Search: ");
            words[i] = in.next();
            this.word = words[i];
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
        }
        longestWord += (longestWord * 2); // variable grid size based on the longest word given by the user
        this.gridSize = longestWord;
        this.grid = letterGrid(); // generate grid with random letters
        this.filled = new boolean[gridSize][gridSize];
        for (int i = 0; i < numWords; i++) {    
            this.word = words[i];
            int attempts = 0;
            int maxAttempts = 100; // limit the attempts of integrating word
            boolean placed = false;
            while (!placed && attempts < maxAttempts) {
                placed = place();
            }
        }
    }


    public void print() { // this method will print the generated word search
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        System.out.println();
        }
    }

    private char[][] letterGrid() { // this method generates a 2D array filled with random letters
        char[][] letterGrid = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                letterGrid[i][j] = (char) ('A' + random.nextInt(25));
            }
        }
        
        return letterGrid;
    }
        
    private boolean place() {  // method places inputted words somewhere random in the letter grid
        int x, y, direction;
        word = word.toUpperCase();
        boolean placed = false;

        do { // do while generates a random starting position and direction and checks to see if any existing words are taking up the space.
            x = random.nextInt(gridSize); // choose random horizontal starting point for word to generate from
            y = random.nextInt(gridSize); // choose random vertical starting point for word to generate from
            direction = random.nextInt(8); // choose random direction for word to generate in
            
        } while (overlapCheck(word, direction, x, y, filled, gridSize) == true);

        switch (direction) { // switch inputs words into grid, and checks to make sure they will not exit the bounds of the array
            case 0: // Horizontal/Right placement case
                if (y + word.length() < gridSize) {                    
                        for (int i = 0; i < word.length(); i++) {
                            grid[x][y + i] = word.charAt(i);
                            filled[x][y + i] = true;
                        }
                        placed = true;
                }
                break;
            case 1: // Down/Right placement case
                if (y + word.length() < gridSize && x + word.length() < gridSize) {
                    for (int i = 0; i < word.length(); i++) {
                        grid[x + i][y + i] = word.charAt(i);
                        filled[x + i][y + i] = true;
                }
                    placed = true;
                }
                break;
            case 2: // Vertical/Down placement case
                if (x + word.length() < gridSize) {                    
                    for (int i = 0; i < word.length(); i++) {
                        grid[x + i][y] = word.charAt(i);
                        filled[x + i][y] = true;
                }
                    placed = true;
                }
                break;
            case 3: // Down/Left placement case
                if (y - word.length() >= 0 && x + word.length() < gridSize) {                    
                    for (int i = 0; i < word.length(); i++) {
                        grid[x + i][y - i] = word.charAt(i);
                        filled[x + i][y - i] = true;
                }
                    placed = true;
                }
                break;            
            case 4: // Horizontal/Left placement case
                if (y - word.length() >= 0) {                         
                    for (int i = 0; i < word.length(); i++) {
                        grid[x][y - i] = word.charAt(i);
                        filled[x][y - i] = true;
                }
                    placed = true;
                }
                break;
            case 5: // Up/Left placement case
                if (y - word.length() >= 0 && x - word.length() >= 0) {                   
                    for (int i = 0; i < word.length(); i++) {
                        grid[x - i][y - i] = word.charAt(i);
                        filled[x - i][y - i] = true;
                }
                    placed = true;
                }
                break;
            case 6: // Vertical/Up placement case
                if (x - word.length() >= 0) {                    
                    for (int i = 0; i < word.length(); i++) {
                        grid[x - i][y] = word.charAt(i);
                        filled[x - i][y] = true;
                }
                    placed = true;
                }
                break;
            case 7: // Up/Right placement case
                if (y + word.length() < gridSize && x - word.length() >= 0) {                    
                    for (int i = 0; i < word.length(); i++) {
                        grid[x - i][y + i] = word.charAt(i);
                        filled[x - i][y + i] = true;
                }
                    placed = true;
                }
                break;
            default:
                break;            
        }    
        return placed;
    }


    private boolean overlapCheck(String word, int direction, int x, int y, boolean[][] filled, int gridSize) { // this method checks to make sure we won't write over any words already on the grid
        boolean overLap = false;
        for (int i = 0; i < word.length(); i++) { 
            switch (direction) { // we also check for each case whether it will go outside the bounds of the array/grid
                case 0:
                    if (y + word.length() < gridSize) {
                        if (filled[x][y + i] == true) {
                            overLap = true;
                        }
                    }
                    break;
                case 1:
                    if (y + word.length() < gridSize && x + word.length() < gridSize) {
                        if (filled[x + i][y + i] == true) {
                            overLap = true;
                        }
                    }
                    break;
                case 2:
                    if (x + word.length() < gridSize) {
                        if (filled[x + i][y] == true) {
                            overLap = true;
                        }
                    }
                    break;
                case 3:
                    if (y - word.length() >= 0 && x + word.length() < gridSize) {
                        if (filled[x + i][y - i] == true) {
                            overLap = true;
                        }
                    } 
                    break;
                case 4:
                    if (y - word.length() >= 0) {
                        if (filled[x][y - i] == true) {
                            overLap = true;
                        }
                    }
                    break;
                case 5:
                    if (y - word.length() >= 0 && x - word.length() >= 0) {
                        if (filled[x - i][y - i] == true) {
                            overLap = true;
                        }
                    }
                    break;
                case 6:
                    if (x - word.length() >= 0) {
                        if (filled[x - i][y] == true) {
                            overLap = true;
                        }
                    }
                    break;
                case 7:
                    if (y + word.length() < gridSize && x - word.length() >= 0) {
                        if (filled[x - i][y + i] == true) {
                            overLap = true;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return overLap;
    }
    public void printSolution() { // this method prints the solution to the word search
        char[][] solution = grid;
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                if (this.filled[i][j] != true) {
                    solution[i][j] = '-';
                } else {
                    solution[i][j] = grid[i][j];
                }
            System.out.print(solution[i][j] + " ");
            }
        System.out.println();
        }
    }
}
