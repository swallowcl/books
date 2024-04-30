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
    
    private int MAX_LIKES = 999999999; // max likes for a book
    private int MIN_LIKES = 0; /// min likes for a book
    
    private boolean validLikes= false;

    

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
         validLikes = false;
         String name = UI.askString("Title: ");
         if (books.findBook(name)){ // error check for duplicates
             UI.println("This book is already in the library!");
            }
        else{
         String author = UI.askString("Author: ");
         // checks that user has entered feasable number
         while (validLikes == false){ 
         int likes = UI.askInt("Likes: ");
         if (likes > MIN_LIKES && likes < MAX_LIKES) {
        // add a book image
        String imgFileName = UIFileChooser.open("Choose image file: ");
        // add a book to the hashmap
         books.addBook(name, author, likes, imgFileName);
         break;
        }
         else{
        // repeats loop until valid like number
         UI.println("Please enter a valid number");
        } 
        }
    }
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
                
            } 
    }
}