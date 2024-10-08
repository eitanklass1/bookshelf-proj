// Name: Eitan Klass
// USC NetID: eklass
// CSCI455 PA2
// Fall 2024

import java.util.ArrayList;

public class TestAssert {
  public static void main(String[] args) {
    ArrayList<Integer> books1 = new ArrayList<>();
    books1.add(5);
    books1.add(3);
    books1.add(8);
    Bookshelf bookshelf1 = new Bookshelf(books1);
    System.out.println("Sorted? " + bookshelf1.isSorted());


    ArrayList<Integer> books2 = new ArrayList<>();
    books2.add(7);
    books2.add(9);
    books2.add(-2);
    Bookshelf bookshelf2 = new Bookshelf(books2);
    System.out.println("String: " + bookshelf2.toString());
  }
}
