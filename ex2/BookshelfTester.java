import java.util.ArrayList;

public class BookshelfTester {
  public static void main(String[] args) {
    
    Bookshelf bookshelf1 = new Bookshelf();
    System.out.println(bookshelf1.toString());

    ArrayList<Integer> books = new ArrayList<>();
    books.add(5);
    books.add(3);
    books.add(8);
    Bookshelf bookshelf2 = new Bookshelf(books);
    System.out.println(bookshelf2.toString());
  }
}
