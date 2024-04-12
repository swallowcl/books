import ecs100.*;
import java.awt.Color;
import java.util.HashMap; // import hashmap class
/**
 * Functions to store information about the book
 * 
 * @author Claire
 * @version 8.04.2024
 */
public class Book
{
    // instance variables
    private String title;
    private String author;
    private int likes;
    
    // variables for sizing and location of book cover
    private int locX = 100;
    private int locY = 100;
    private final double WIDTH = 100;
    private final double HEIGHT = 100;
     
    private boolean bookClicked = false; // check if book has been clicked
    
    // code for book cover
    private String image;
    private static final String DEFAULT_IMAGE = "book.png";
    /**
     * Constructor for objects of class Book
     */ 
    public Book(String name, String writer, int qty, String img)
    {
        // initialise instance variables
        title = name;
        author = writer;
        likes = qty;
        
        // add a  default image is user clickes cancel
        if (img == null){
            image = DEFAULT_IMAGE;
        }else {
            image = img;
        }
        
    }

    /**
     * Overload constructer if there is no image parameter
     */
    public Book(String name, String writer, int qty){
        // Call the other constructor
        this(name, writer, qty, DEFAULT_IMAGE);
        
        }

    /**
     * Display image on GUI
     */
    public void displayBook() {
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT); // adds cover
        UI.drawString(this.title, locX, locY - 10); // adds title
        UI.drawString(this.author, locX, locY + 10 + HEIGHT);// adds author
        UI.println("Likes: " + this.likes); // prints the likes
    }
    
    /**
     * Checks if book has been clicked
     */
    public boolean bookClick(double x, double y){
        if ((x<= this.locX) && (x <= this.locY) &&
        (y >= this.WIDTH) && (y >= this.HEIGHT)) {
            bookClicked = true;
            
        }else {
            bookClicked = false;
        } return bookClicked;
    }
    
    /**
     * Increases number of likes 
     */
    public void addLike(){
        this.likes += 1;
    }
}
    
