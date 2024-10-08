// Name: Eitan Klass
// USC NetID: eklass
// CSCI455 PA2
// Fall 2024

import java.util.ArrayList;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {

   /**
      Representation invariant:

      <put rep. invar. comment here>
      @param height
      the height for each book must be > 0

   */
   
   // <add instance variables here>
   private ArrayList<Integer> shelf;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      this.shelf = new ArrayList<Integer>();
      assert isValidBookshelf();
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      this.shelf = new ArrayList<Integer>(pileOfBooks);
      // this.shelf = pileOfBooks;
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      this.shelf.add(0, height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      this.shelf.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      int removedBookHeight = this.shelf.remove(0);
      assert isValidBookshelf();
      return removedBookHeight;
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      int removedBookHeight = this.shelf.remove(this.shelf.size() - 1);
      assert isValidBookshelf();
      return removedBookHeight; 
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      int bookHeight = this.shelf.get(position);
      assert isValidBookshelf();
      return bookHeight;
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      int shelfSize = this.shelf.size();
      assert isValidBookshelf();
      return shelfSize;

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      StringBuilder shelfString = new StringBuilder();
      if (this.shelf.size() == 0) {
         return "[]";
      }
      shelfString.append("[");
      if (this.shelf.size() > 1) {
         for (int i = 0; i < this.shelf.size(); i++) {
            int curNum = this.shelf.get(i);
            if (i < this.shelf.size() - 1) {
               shelfString.append(curNum + ", ");
            } else {
               shelfString.append(curNum);
            }
         }
      } else {
         shelfString.append(this.shelf.get(0));
      }
      shelfString.append("]");
      assert isValidBookshelf();
      return shelfString.toString();
   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      if (this.shelf.size() > 1) {
         int prev = this.shelf.get(0);
         for (int i = 1; i < this.shelf.size(); i++) {
            if (this.shelf.get(i) < prev) {
               return false;
            }
            prev = this.shelf.get(i);
         }
      }
      assert isValidBookshelf();
      return true;
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      for (int i = 0; i < this.shelf.size(); i++) {
         int height = this.shelf.get(i);
         assert height > 0;
      }
      return true;
   }

}
