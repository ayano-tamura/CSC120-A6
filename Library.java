/* This is a stub for the Library class */
import java.util.Hashtable;
import javax.management.RuntimeErrorException;

public class Library extends Building {
  private Hashtable<String, Boolean> collection;

  /**
   * Class constructor for building a Library
   * @param name name of library
   * @param address address of library
   * @param nFloors number of floors in library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }
  /**
   * see if library contatins given book title
   * @param title book title to look up
   * @return true if the title appears as a key in the Libary's collection, false otherwise
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * getter for isAvailable
   * @param title Book title to look up
   * @return  true if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title){
    if (collection.get(title) == true){
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method to add book title to library collection
   * @param title title of book to add to collection
   */
  public void addTitle(String title){
    collection.put(title, true);
    System.out.println(title + " has been added to the collection!");
  }
  
  /**
   * method to remove a title from a collection
   * @param title book title to remove
   * @return title of book that was removed
   */
  public String removeTitle(String title){
    if (collection.contains(title)){
      collection.remove(title);
      System.out.println("You have removed " + title + " from your collection!");
      return title;
    } else {
      throw new RuntimeException("You cannot remove " + title + " from the collection, it doesn't exist in here!");
    }
  }

  /**
   * method for checking out a title from collection, if title is available and exists in the collection
   * @param title title of book to checkout
   */
  public void checkOut(String title){
    if(this.containsTitle(title)){
      if (this.isAvailable(title)){
        collection.replace (title, collection.get(title), false);
        System.out.println("You have checked out the book "+ title);
      } else {
        System.out.println(title + " is currently not available to check out");
      }
    } else {
      throw new RuntimeException("Sorry, this title is currently not available to check out");
    }
  }

  /**
   * method for returning a book title, if it was initially in the library
   * @param title title of book to return
   */
  public void returnBook(String title){
    if (this.containsTitle (title)){
      collection.replace(title, collection.get(title), true);
      System.out.println(title + " has been successfully returned");
    } else {
      throw new RuntimeException(title + " is not in " + this.getName() + ", perhaps you borrowed it from another place?");
    }
  }

  // prints out the entire collection in an easy-to-read way (including checkout status)
  public void printCollection(){
    System.out.println("The Magical Book Collection");
    for (String title : collection.keySet()){
      boolean available = collection.get(title);
      String status;
      if (available){
        status = "Available";
      } else {
        status = "Checked out/Not available";
      }
      System.out.printf(title, status);
    }

  }
  // public static void main(String[] args) {
  //     new library = new Library ("Brook Library", "1 Elm Street", 3);
  //     System.out.println(library);
  //   }
  
  }