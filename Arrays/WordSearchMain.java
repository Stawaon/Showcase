// Noah Watson
// 1/24/2024
// Assignment 1: Word Search Generator
// Program allows user to generate a word search, print the word search for the user, and display the solution 

public class WordSearchMain {
    public static void main(String[] args) {
        boolean loop = true; // initialize while loop boolean
        boolean gridExists = false;
        WordSearch puzzle = new WordSearch();
        
        while (loop) { // main method while loop to run program until user quits.
            switch (puzzle.printIntro()) {  
                case 'g':
                    puzzle.generate();
                    gridExists = true;
                    break;
                case 'p':
                    if (gridExists) {
                    puzzle.print();
                    } else {
                        System.out.println("You must generate a word search first.");
                    }
                    break;
                case 's':
                    if (gridExists) {
                        puzzle.printSolution();
                    }
                    break;
                case 'q':
                    loop = false;
                    break;
                default:
                    break;
            }  
        }
    }
}

