import java.util.ArrayList;;

public class BookshelfTester {
  public static void main(String[] args) {
    
    Bookshelf bookshelf1 = new Bookshelf();
    System.out.println("Constructor:" + bookshelf1.toString());

    ArrayList<Integer> books = new ArrayList<>();
    books.add(5);
    books.add(3);
    books.add(8);
    Bookshelf bookshelf2 = new Bookshelf(books);
    System.out.println("Constructor w/ predefined array: " + bookshelf2.toString());

    bookshelf2.addFront(9);
    System.out.println("Add to front of shelf: " + bookshelf2.toString());

    bookshelf2.addLast(23);
    System.out.println("Add to the end of shelf: " + bookshelf2.toString());

    bookshelf2.removeFront();
    System.out.println("Remove book from front of shelf: " + bookshelf2.toString());

    bookshelf2.removeLast();
    System.out.println("Remove book from end of shelf: " + bookshelf2.toString());
  }
}
