// Name: Eitan Klass
// USC NetID: eklass
// CSCI455 PA2
// Fall 2024

import java.util.ArrayList;

public class BookshelfTester {
  public static void main(String[] args) {
    
    Bookshelf bookshelf1 = new Bookshelf();
    System.out.println("Constructor:" + bookshelf1.toString());

    ArrayList<Integer> books2 = new ArrayList<>();
    books2.add(5);
    books2.add(3);
    books2.add(8);
    Bookshelf bookshelf2 = new Bookshelf(books2);
    System.out.println("Constructor w/ predefined array: " + bookshelf2.toString());

    bookshelf2.addFront(9);
    System.out.println("Add to front of shelf: " + bookshelf2.toString());

    bookshelf2.addLast(23);
    System.out.println("Add to the end of shelf: " + bookshelf2.toString());

    bookshelf2.removeFront();
    System.out.println("Remove book from front of shelf: " + bookshelf2.toString());

    bookshelf2.removeLast();
    System.out.println("Remove book from end of shelf: " + bookshelf2.toString());

    System.out.println("Height @ index 2: " + bookshelf2.getHeight(2));

    System.out.println("Size of shelf: " + bookshelf2.size());

    System.out.println("Sorted? " + bookshelf2.isSorted());

    ArrayList<Integer> books3 = new ArrayList<>();
    books3.add(5);
    books3.add(8);
    books3.add(19);
    Bookshelf bookshelf3 = new Bookshelf(books3);
    System.out.println("Sorted? " + bookshelf3.isSorted());

    // Make a book with a height of -1
    ArrayList<Integer> books4 = new ArrayList<>();
    books4.add(6);
    books4.add(1);
    books4.add(-6);
    Bookshelf bookshelf4 = new Bookshelf(books4);
    System.out.println(bookshelf4.toString());
  }
}
