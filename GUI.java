import java.util.HashMap;
import ecs100.*;
/**
 * Handles the GUI
 *
 * @author Claire
 * @version 11.04.2024
 */
public class GUI
{
    // instance variables 
    private Books books; // declares the books instancts that holds the collection
    

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Books(); // instantiate the books class 
        UI.initialise();
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Quit", UI::quit);
        
        UI.setMouseListener(this::doMouse); // set up mouse listner 
        
    }

    /**
     * Add book to collection
     **/
     public void addBook(){
         // Ask user for details
         String name = UI.askString("Title: "); // error check for duplicates here
         String author = UI.askString("Author: ");
         
         // need to add boundary/error checking, constants
         int likes = UI.askInt("Likes: ");
         
         // add a book image
         String imgFileName = UIFileChooser.open("Choose image file: ");
         
         // add a book to the hashmap
         books.addBook(name, author, likes, imgFileName);
     }
     
     /**
      * Finds book based on name
      */
     public void findBook() {
         // Ask user for title, need to clean up title
         String bookName = UI.askString("Name of book: ");
         UI.clearGraphics();
         // look for book in hashmap
         if (books.findBook(bookName)){
             UI.println("Found book!");
         }else {
             UI.println("Book does not exist!");
         }
         
     }
     
     private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            // check x and y location of the object
            if (bookClicked.bookClick(x, y)) {
                
            }
                
            } 
    }
}
