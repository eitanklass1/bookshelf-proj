// Name: Eitan Klass
// USC NetID: eklass
// CSCI455 PA2
// Fall 2024

import java.util.ArrayList;

public class BookshelfKeeperTester {
   public static void main(String[] args) {
      // Initial bookshelf with ordered books
      ArrayList<Integer> books1 = new ArrayList<>();
      books1.add(1);
      books1.add(2);
      books1.add(4);
      books1.add(5);
      books1.add(8);
      Bookshelf bookshelf1 = new Bookshelf(books1);
      BookshelfKeeper bookshelfkeeper1 = new BookshelfKeeper(bookshelf1);
      System.out.println("Initial Bookshelf: " + bookshelfkeeper1.toString());

      // Insert a book of height 3
      bookshelfkeeper1.putHeight(3);
      System.out.println("After putting height 3: " + bookshelfkeeper1.toString());

      // Insert a duplicate book height (1)
      bookshelfkeeper1.putHeight(1);
      System.out.println("After putting duplicate height 1: " + bookshelfkeeper1.toString());

      // Insert a book of height 6
      bookshelfkeeper1.putHeight(6);
      System.out.println("After putting height 6: " + bookshelfkeeper1.toString());

      // Insert a book larger than the largest book (9)
      bookshelfkeeper1.putHeight(9);
      System.out.println("After putting height 9: " + bookshelfkeeper1.toString());

      // Insert a book at the midpoint (height 4)
      bookshelfkeeper1.putHeight(4);
      System.out.println("After putting height 4 at midpoint: " + bookshelfkeeper1.toString());

      // Remove the book at the beginning (position 0)
      bookshelfkeeper1.pickPos(0);
      System.out.println("After picking from position 0 (beginning): " + bookshelfkeeper1.toString());

      // Remove the book at the end (last position)
      bookshelfkeeper1.pickPos(bookshelfkeeper1.getNumBooks() - 1);
      System.out.println("After picking from last position: " + bookshelfkeeper1.toString());

      // Remove the book again from the end
      bookshelfkeeper1.pickPos(bookshelfkeeper1.getNumBooks() - 1);
      System.out.println("After another pick from last position: " + bookshelfkeeper1.toString());

      // Remove a book from the middle
      bookshelfkeeper1.pickPos(bookshelfkeeper1.getNumBooks() / 2);
      System.out.println("After picking from middle position: " + bookshelfkeeper1.toString());

      // Test invalid bookshelf (not sorted)
      ArrayList<Integer> books2 = new ArrayList<>();
      books2.add(1);
      books2.add(2);
      books2.add(9);
      books2.add(5);
      books2.add(8);
      Bookshelf bookshelf2 = new Bookshelf(books2);
      BookshelfKeeper bookshelfkeeper2 = new BookshelfKeeper(bookshelf2);
      System.out.println("Bookshelf with invalid order: " + bookshelfkeeper2.toString());
   }
}

