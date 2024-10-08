// Name: Eitan Klass
// USC NetID: eklass
// CSCI455 PA2
// Fall 2024

import java.util.ArrayList;

public class BookshelfKeeperTester {
  public static void main(String[] args) {
    ArrayList<Integer> books1 = new ArrayList<>();
    books1.add(1);
    books1.add(2);
    books1.add(4);
    books1.add(5);
    books1.add(8);
    Bookshelf bookshelf1 = new Bookshelf(books1);
    BookshelfKeeper bookshelfkeeper1 = new BookshelfKeeper(bookshelf1);

    bookshelfkeeper1.putHeight(3);
    System.out.println(bookshelfkeeper1.toString());

    // Add duplicate
    bookshelfkeeper1.putHeight(1);
    System.out.println(bookshelfkeeper1.toString());

    bookshelfkeeper1.putHeight(6);
    System.out.println(bookshelfkeeper1.toString());

    // Add a book that is bigger than the biggest book
    bookshelfkeeper1.putHeight(9);
    System.out.println(bookshelfkeeper1.toString());

    // Add at the midpoint
    bookshelfkeeper1.putHeight(4);
    System.out.println(bookshelfkeeper1.toString());

    // Remove at the begining
    bookshelfkeeper1.pickPos(0);
    System.out.println(bookshelfkeeper1.toString());

    // Remove at the end
    bookshelfkeeper1.pickPos(bookshelfkeeper1.getNumBooks() - 1);
    System.out.println(bookshelfkeeper1.toString());

    // Remove at the end
    bookshelfkeeper1.pickPos(bookshelfkeeper1.getNumBooks() - 1);
    System.out.println(bookshelfkeeper1.toString());

    // Remove in the middle
    bookshelfkeeper1.pickPos(bookshelfkeeper1.getNumBooks() / 2);
    System.out.println(bookshelfkeeper1.toString());

    // ArrayList<Integer> books2 = new ArrayList<>();
    // books2.add(1);
    // books2.add(2);
    // books2.add(9);
    // books2.add(5);
    // books2.add(8);
    // Bookshelf bookshelf2 = new Bookshelf(books2);
    // BookshelfKeeper bookshelfkeeper2 = new BookshelfKeeper(bookshelf2);
    // System.out.println(bookshelfkeeper2.toString());

  }
}
