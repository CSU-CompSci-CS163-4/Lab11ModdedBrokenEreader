import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EReader {
    Scanner fileReader;
    Scanner userInput = new Scanner(System.in);
    ArrayList<String> books;

    public EReader(ArrayList<String> books){
        this.books = books;
    }

    public void listBooks(){
        System.out.println("Choose from the following list of books: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ": " + books.get(i));
        }
        System.out.println();
        System.out.println("Enter the number for the entry you would like to read or X to exit.");
    }

    public void options(){
        System.out.println("Enter X to turn off ereader at any time.");
        listBooks();
    }

    public void loadBook(String book){
        try {
            //Paste code from lab 9
        }
        catch (FileNotFoundException e){
            System.out.println("Uh oh! I couldn't find that file!");
        }
    }
    public String displayLine(){
        //paste code from lab 9
        return "";
    }

    public void openBook(){
        //Paste code from lab 9
        System.out.println(displayLine());
    }

    /**
     * You modded your broken e-reader to do your math homework for you.
     *
     * To do this, mathReader needs to take the name of the output file to write the results to.
     * You are in third grade, so all of your math homework is in the form "int operator int".
     * Read each line at a time, do the math using mathHelper, then write the solution to the solution file.
     *
     * There is provided pseudocode to help you write the method.
     *
     * @param outputFile
     */

    public void mathReader(String outputFile){
        try {
            PrintWriter output = new PrintWriter(outputFile);
        /*
        For each line in fileReader
            Send that line to helper method
            Take result and output it to file
         */
            output.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! I couldn't find that file!");
        }
    }

    /**
     * mathHelper's job is to take in a string equation, read each part of the equation, and then solve the problem.
     *
     * Some pseudocode has been provided to help you write your code.
     *
     * @param equation
     * @return result of the equation
     */
    public int mathHelper(String equation){
        /*
         Make string into a scanner
         get (and cast) left item and store to a variable
         get operator item and store to a variable
         get (and cast) right item and store to a variable
         do some checks to figure out what the operator is
            when you find a match, do the appropriate math and return the result
         */
        return -1;
    }




    public void go(){
        options();
        String input = userInput.nextLine();
        while(!input.equalsIgnoreCase("x")){
            String bookName = books.get(Integer.parseInt(input) - 1);
            System.out.println("Now opening: " + bookName);
            loadBook(bookName);
            System.out.println("Would you like to read this book or solve the problems? Enter R to read or M for math.");
            input = userInput.nextLine();
            System.out.println();
            if (input.equalsIgnoreCase("r")) {
                System.out.println("Press Enter to go to next line, or enter X to close the book.");
                openBook();
            }
            else if (input.equalsIgnoreCase("m")){
                System.out.println("Please provide an output filename for solutions: ");
                input = userInput.nextLine();
                mathReader(input);
            }
            System.out.println("Closing book...");
            options();
            input = userInput.nextLine();
        }
    }

    public static void main(String[] args){
        ArrayList<String> myBooks = new ArrayList<>();
        myBooks.add("Great_Gatsby.txt");
        myBooks.add("Alice_In_Wonderland.txt");
        myBooks.add("US_Constitution.txt");
        myBooks.add("equations.txt");
        EReader myBrokenEreader = new EReader(myBooks);
        myBrokenEreader.go();
    }
}
