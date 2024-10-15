// Name: Eitan Klass
// USC NetID: eklass
// CSCI455 PA2
// Fall 2024

import java.util.ArrayList;

/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

   /**
      Representation invariant:

      <put rep. invar. comment here>
      @param height
      1. the height for each book must be > 0
      
      2. each book has to be sorted in non-decreasing order
   */
   
   // <add instance variables here>
   private Bookshelf shelf;
   private int totalOperations = 0;
   private int curOperations = 0;

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      this.shelf = new Bookshelf();
      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (int i = 0; i < sortedBookshelf.size(); i++) {
         temp.add(sortedBookshelf.getHeight(i));
      }
      this.shelf = new Bookshelf(temp);
      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: 0 <= position < getNumBooks()
    */
   public int pickPos(int position) {
      int middlePos = this.shelf.size() / 2;
      ArrayList<Integer> tempArray = new ArrayList<>();
      curOperations = 0;

      if (position >= middlePos) {
         // Temporarily remove books until you reach the right position
         while ((this.shelf.size() - 1) > position) {
            int book = this.shelf.removeLast();
            tempArray.add(book);
            curOperations++;
         }

         // Delete the book after the last book on the bookshelf
         this.shelf.removeLast();
         curOperations++;

         // Add back the books that you temporarily removed
         for (int i = tempArray.size() - 1; i >= 0; i--) {
            this.shelf.addLast(tempArray.get(i));
            curOperations++;
         }
      } else {
          // Temporarily remove books until you reach the right position
          int j = 0;
          while (j < position) {
            int book = this.shelf.removeFront();
            tempArray.add(book);
            curOperations++;
            j++;
         }

         // Delete the book after the last book on the bookshelf
         this.shelf.removeFront();
         curOperations++;

         // Add back the books that you temporarily removed
         for (int i = tempArray.size() - 1; i >= 0; i--) {
            this.shelf.addFront(tempArray.get(i));
            curOperations++;
         }
      }
      this.totalOperations += curOperations;
      assert isValidBookshelfKeeper();
      return curOperations;
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
      int middlePos = this.shelf.size() / 2;
      ArrayList<Integer> tempArray = new ArrayList<>();
      curOperations = 0;

      if (this.shelf.size() == 0) {
         this.shelf.addFront(height);
         curOperations++;
         this.totalOperations += curOperations;
         assert isValidBookshelfKeeper();
         return curOperations;
      }

      if (height >= this.shelf.getHeight(middlePos)) {
         // Temporarily remove books until you reach the right position
         while (this.shelf.getHeight(this.shelf.size() - 1) > height) {
            int book = this.shelf.removeLast();
            tempArray.add(book);
            curOperations++;
         }

         // Add the book after the last book on the bookshelf
         this.shelf.addLast(height);
         curOperations++;

         // Add back the books that you temporarily removed
         for (int i = tempArray.size() - 1; i >= 0; i--) {
            this.shelf.addLast(tempArray.get(i));
            curOperations++;
         }
      } else {
         // Temporarily remove books until you reach the right position
         while (this.shelf.getHeight(0) < height) {
            int book = this.shelf.removeFront();
            tempArray.add(book);
            curOperations++;
         }

         // Add the book to the front of the bookshelf
         this.shelf.addFront(height);
         curOperations++;

         // Add back the books that you temporarily removed
         for (int i = tempArray.size() - 1; i >= 0; i--) {
            this.shelf.addFront(tempArray.get(i));
            curOperations++;
         }
      }
      this.totalOperations += curOperations;
      assert isValidBookshelfKeeper();
      return curOperations;
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return this.totalOperations;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert isValidBookshelfKeeper();
      return this.shelf.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {
      StringBuilder shelfString = new StringBuilder();
      if (this.shelf.size() == 0) {
         return "[]" + " " + this.curOperations + " " + this.totalOperations;
      }
      shelfString.append("[");
      if (this.shelf.size() > 1) {
         for (int i = 0; i < this.shelf.size(); i++) {
            int curNum = this.shelf.getHeight(i);
            if (i < this.shelf.size() - 1) {
               shelfString.append(curNum + ", ");
            } else {
               shelfString.append(curNum);
            }
         }
      } else {
         shelfString.append(this.shelf.getHeight(0));
      }
      shelfString.append("]");
      assert isValidBookshelfKeeper();
      return shelfString.toString() + " " + this.curOperations + " " + this.totalOperations;      
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      if (this.shelf.size() == 1) {
         int height = this.shelf.getHeight(0);
         assert height > 0;
         return true;
      }
      for (int i = 0; i < this.shelf.size() - 1; i++) {
         if (i > 0) {
            assert this.shelf.getHeight(i) >= this.shelf.getHeight(i - 1);
         }
         assert this.shelf.getHeight(i) > 0;
      }
      return true;
   }
}
