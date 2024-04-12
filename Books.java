import ecs100.*;
import java.util.HashMap;
/**
 * Holds a collection of the books, a hashmap
 * Allows user to add, find, print, edit, and delete
 * Check to prevent adding duplicates
 * @author Claire
 * @version 10.04.24
 */
public class Books
{
    // instance variables
    private HashMap<String,Book> library ; // declearing the hashmap
    private Book currBook; // store instance of current book

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        library = new HashMap<String, Book>(); // initalise hashmap
        
        // create books - sample data
        Book b1 = new Book("The Narrow Corridor", "James A. Robinson", 10);
        library.put("The Narrow Corridor", b1);
        
        // same as above but no variable
        library.put("Hairy Mclary", new Book("Hairy Mclarey","Margaret Mahey", 1000));
        library.put("Dune", new Book("Dune","Frank Herbert", 50));
        
    }

    /**
     * Add a book to the Hashmap
     * 
     */
    public void addBook(String name, String author, int likes, String img) {
        library.put(name, new Book (name, author, likes, img));
    }
    
    /**
     * Finds book baseds on name
     * Set current book if found
     */
    public boolean findBook(String name){
        // Search for book in hashmap
        for (String bookName : library.keySet()){
            if (bookName.equals(name)){ // if book key is found
                currBook = library.get(bookName); // set current book
                // show book cover
                currBook.displayBook();
                return true;
            }
        }
        return false;
    }
}
