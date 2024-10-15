// Name: Eitan Klass
// USC NetID: eklass
// CSCI455 PA2
// Fall 2024

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This program simulates a bookshelf keeper system where books can be added (put) or removed (pick)
 * from a bookshelf while maintaining non-decreasing order by height.
 *
 * The user initially provides a series of integers representing the heights of the books on the shelf,
 * which are expected to be in non-decreasing order. The user can then interactively issue commands
 * to pick a book from a specified index or put a book of a certain height onto the shelf.
 * The program makes sure that the bookshelf remains valid throughout the operations.
 *
 * To run the program:
 * 1. Enter the initial bookshelf arrangement of book heights, followed by a newline.
 * 2. Use commands to interact with the bookshelf:
 *    - `pick <index>`: to remove a book from the given index (0-based).
 *    - `put <height>`: to add a book of the given height, maintaining order.
 *    - `end`: to exit the program.
**/

public class BookshelfKeeperProg {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in); // create the Scanner
      System.out.println("Please enter initial arrangement of books followed by newline: ");

      BookshelfKeeper bookshelfkeeper = createBookshelf(in);
      if (bookshelfkeeper == null) {
         return;
      }

      System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
      String action = in.next();
      Integer unit = in.nextInt();
      handleCommands(bookshelfkeeper, in, action, unit);
   }

   /**
    * Processes user commands to "put" a book of a given height or "pick" a book at a specified index
    * on the bookshelf, continuing until the user inputs "end".
    *
    * Preconditions:
    * - `bookshelfkeeper` must not be null.
    * - `action` must be "put", "pick", or "end".
    * - `unit` must be non-negative, and within bounds for "pick".
   **/
   private static void handleCommands(BookshelfKeeper bookshelfkeeper, Scanner in, String action, Integer unit) {
      // Check if the provided height or index is negative, if so, exit.
      if (handleNegativeHeight(unit, in)) {
         return;
      }
      while (true) {
         // Handle the "put" command to insert a book of a given height.
         if (action.equals("put")) {
            bookshelfkeeper.putHeight(unit);

         // Handle the "pick" command to remove a book from a specific index.
         } else if (action.equals("pick")) {
            if (unit >= bookshelfkeeper.getNumBooks()) {
               System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
               System.out.println("Exiting program.");
               in.close();
               return;
            }
            bookshelfkeeper.pickPos(unit);
         
         // Handle invalid commands (neither "put" nor "pick").
         } else {
            System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
            System.out.println("Exiting Program.");
            in.close();
            return;
         }
         System.out.println(bookshelfkeeper.toString());
         action = in.next();

         // Exit the program if the user enters "end".
         if (action.equals("end")) {
            System.out.println("Exiting Program.");
            in.close();
            return;
         }
         
         // Check if the provided height or index is negative, if so, exit.
         unit = in.nextInt();
         if (handleNegativeHeight(unit, in)) {
            return;
         }
      }
   }
   
   /**
    * Creates a BookshelfKeeper from user input, which consists of book heights in non-decreasing order.
    * If no input is given, an empty bookshelf is created.
    *
    * Preconditions:
    * - The input must contain non-negative integers in non-decreasing order, or be empty.
   **/
   private static BookshelfKeeper createBookshelf(Scanner in) {
      // Read input
      String input = in.nextLine();
      // Clean input
      ArrayList<String> inputArray = new ArrayList<>(Arrays.asList(input.replaceAll("\\s{2,}", " ").trim().split(" ")));

      BookshelfKeeper bookshelfkeeper;
      if (inputArray.get(0).equals("")) {
         bookshelfkeeper = new BookshelfKeeper();
      } else {
         // Convert input into ArrayList of integers
         ArrayList<Integer> startingBooks = new ArrayList<>();
         for (int i = 0; i < inputArray.size(); i++) {
            startingBooks.add(Integer.parseInt(inputArray.get(i)));
         }
         if (handleInitialInputErrors(startingBooks, in)) {
            return null;
         }
         Bookshelf bookshelf = new Bookshelf(startingBooks);
         bookshelfkeeper = new BookshelfKeeper(bookshelf);
      }
      System.out.println(bookshelfkeeper.toString());
      return bookshelfkeeper;
   }

   /**
    * Validates the initial input list of book heights to ensure all heights are positive
    * and in non-decreasing order. Prints an error and exits if any violations are found.
    *
    * Preconditions:
    * - The input list must contain non-negative integers.
   **/
   private static Boolean handleInitialInputErrors(ArrayList<Integer> input, Scanner in) {
      Boolean flag = false;
      for (int i = 0; i < input.size(); i++) {
         if (input.get(i) < 0) {
            System.out.println("ERROR: Height of a book must be positive.");
            flag = true;
         } else if (i > 0 && input.get(i - 1) >= input.get(i)) {
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");
            flag = true;
         }
         if (flag) {
            System.out.println("Exiting Program.");
            in.close();
            return true;
         }
      }
      return false;
   }

   /**
    * Checks if the given height (unit) is negative. If it is, prints an error message and exits the program.
    *
    * Preconditions:
    * - The height `unit` must be an integer.
   **/
   private static Boolean handleNegativeHeight(Integer unit, Scanner in) {
      if (unit < 0) {
         System.out.println("ERROR: Height of a book must be positive.");
         System.out.println("Exiting Program.");
         in.close();
         return true;
      }
      return false;
   }
}
