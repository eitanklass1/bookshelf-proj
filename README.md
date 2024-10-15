# **Bookshelf Keeper**

## **Overview**

This project implements a **BookshelfKeeper** system that allows efficient management of a bookshelf, where books are sorted by height and can only be accessed from either end of the shelf. The main objective was to implement the logic for `put` and `pick` operations, which add or remove books while minimizing the number of operations. The system is interactive, running in a terminal-based environment, and ensures that the bookshelf remains sorted at all times.

This project was a great opportunity for me to explore algorithmic efficiency and separation of concerns in Java. I completed the implementation for the key classes, ensuring that the program met the design and performance requirements outlined.

## **Project Structure**

### **Files Implemented/Modified**

- **Bookshelf.java**  
  I implemented the core functionality of the `Bookshelf` class, which simulates a collection of books. Books can be added or removed from the front or back, and the order of the books can be inspected. The methods implemented ensure that books can be accessed and modified efficiently.

- **BookshelfKeeper.java**  
  This class maintains a `Bookshelf` in sorted order and performs `put` and `pick` operations with minimal book movements. I carefully implemented this class to ensure that every `put` or `pick` operation uses the fewest number of moves, using both front and back access to the bookshelf. The class tracks the total number of operations performed, which was important for performance evaluation.

- **BookshelfKeeperProg.java**  
  I created this terminal-based interactive program to allow users to perform a series of `put` and `pick` operations on a `BookshelfKeeper` object. This file contains the `main` method, and I implemented both interactive and batch processing modes. The program reads user input and prints results, including the current state of the bookshelf and the number of operations performed.

### **Additional Files**
- **README.md**  
  This file documents the project and my approach to the implementation.

## **Key Features**

- **Efficient Book Operations**:  
  The `put` and `pick` operations in the `BookshelfKeeper` class are optimized to minimize the number of mutator calls (i.e., adding/removing books from the bookshelf). I focused on implementing these operations such that the program selects the optimal end (either front or back) to access the book or insert a new one.

- **Interactive and Batch Modes**:  
  The program supports both interactive mode, where the user enters commands directly, and batch mode, which allows commands to be read from an input file and results to be written to an output file.

- **Input Validation and Error Handling**:  
  I incorporated error handling to ensure that all operations are performed on valid inputs, such as preventing picking or removing a book when the bookshelf is empty or inserting a book with an invalid height.

## **How to Run the Program**

To run the program with assertions enabled (which I used extensively for debugging and testing), use the following command in your terminal:

```
java -ea BookshelfKeeperProg
```

For batch mode, where input is read from a file and output is written to another file:

```
java -ea BookshelfKeeperProg < inputFile > outputFile
```

The `-ea` flag ensures that assertions are checked during runtime, helping to catch any potential issues early.
