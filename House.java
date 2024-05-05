/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building {
  // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /**
   * Class Constructor for building a House
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors for house
   * @param hasDiningRoom boolean for whether the house has a Dining Room or not
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Getter for hasDiningRoom
   * @return result of whether or not the house has a dining room or not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Getter for the number of residents in the house
   * @return the number of residents residing in the house
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Lets user know if the person is a resident of the house
   * @param person person to check if they are in the house
   * @return true/false if the given person is a resident of the house
   */
  public boolean isResident (String person){
    return this.residents.contains(person);
  }

  /**
   * Adds a new resident to the house if they are not in it already.
   * @param name name of new resident
   */
  public void moveIn(String name){
    if (!isResident(name)){
      this.residents.add(name);
      System.out.println("Resident"+ name + " has moved into " + this.getName());
    } else {
      throw new RuntimeException (name + " is already a resident here!");
    }
  }
  
  /**
   * remove a resident and return the name of the person
   * @param name name of resident to remove from house 
   * @return name of the resident who has moved out from the house
   */
  public String moveOut(String name){
    if (residents.contains(name)){
      this.residents.remove(name);
      System.out.println(name + "has moved out of " + this.getName());
      return name;
    } else {
      throw new RuntimeException(name + " is not a resident here");
    }
  }
}