/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /**
     * Class constructor for building a cafe
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors in cafe
     * @param nCoffeeOunces amount of coffee
     * @param nSugarPackets amount of sugar packets
     * @param nCreams amount of coffee cream
     * @param nCups amount of coffee cups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * getter for canSell, check if there are enough ingredients to operate coffee-making
     * @param size size of coffee 
     * @param nSugarPackets amount of sugar packets required 
     * @param nCreams amount of coffee cream needed
     * @return true if coffee can be sold, false if there are not enough ingredients
     */
    private boolean canSell(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams && this.nCups > 0){
            return true;
        } else {
            return false;
        }
    }


    /**
     * method to restock the coffee making supplies
     * @param nCoffeeOunces amount of coffee
     * @param nSugarPackets amount of sugar packets
     * @param nCreams amount of coffee cream
     * @param nCups amount of coffee cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Process for selling coffee, sell if there are enough ingredients, restock if not enough ingredients
     * @param size size of coffee created
     * @param nSugarPackets amount of Sugar packets used
     * @param nCreams amount of coffee cream used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.canSell(size, nSugarPackets, nCreams)){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        } else {
            this.restock(size * 10, nSugarPackets * 10, nCreams * 10, 10);
        }
    }
    
    // public static void main(String[] args) {
    //     Cafe cafe = new Cafe ("Compass", "10 Elm Street", 2, 50,50,10,10);
    // }
    
}
