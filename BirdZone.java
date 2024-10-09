import java.util.LinkedList;

public class BirdZone extends AbsZoneable implements Zoneable{
    public LinkedList<Bird> birds;
    public int seeds;

    public BirdZone(LinkedList<Bird> birds){
        this.birds = birds;
        seeds = 0;
    }

    @Override
    public LinkedList<? extends Petable> getPets() {
        return birds;
    }








    /**
     * Looks up a pet in the zone and computers its age relative to human years
     *
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet calculation
     * or -1 if that pet name is not in this zone
     */
    @Override
    public int inHumanYears(String petName) {
        for (Bird birdList: birds){
            if (birdList.getName().equals(petName)){
                return (birdList.age * 9);
            }
        }
        return -1;
    }

    /**
     * @param foodName The name of a food item expected to be stocked in this zone's pantry
     * @param foodAmt  A non-negative number (>= 0) representing how much of that food is going into the pantry
     * @return `this` zone for the purpose of method chaining
     */
    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        seeds += foodAmt;
        return this;
    }

    /**
     * For each animal in the zone, brings them in to eat
     * Use their eats() method on each type of food in the pantry for them
     *
     * @return `this` zone for the purpose of method chaining
     * If a food item in the zone goes negative, set it to 0. (No need for "unknown" logic).
     */
    @Override
    public Zoneable feedZone() {
        for (Bird birdList: birds){
            seeds -= birdList.eats("seeds");
        }
        if (seeds < 0){
            seeds = 0;
        }
        return this;
    }

    /**
     * Fetch me that pet!
     *
     * @param petName the pet to look up in the zone, you may assume the pet is in the zone
     * @return the pet with that name or null if pet is not in the zone
     */
    @Override
    public Petable getPet(String petName) {
        for (Bird birdList: birds){
            if(birdList.name.equals(petName)){
                return birdList;
            }
        }
        return null;
    }

    /**
     * Returns the stock of the pantry for the zone
     *
     * @return a string printing out the pantry in the format of "Animal: # food1, # food2, ...etc"
     */
    @Override
    public String getPantryLabel() {
        return ("Bird: "+ seeds +" seeds");
    }

    /**
     * Gets the name of the pet that is closest to the given 3D coord
     *
     * @param x the 3D coord that only has the location information
     * @param y
     * @return the name of the pet closest to that coord
     * In the result of a tie, you may return any one
     * (we won't test ties)
     * if there are no pets, return null
     * assume the "z" coordinate we are using is 0 by default
     * (some pets may be up on perches)
     * return "No Pets Found" if there are no pets in the zone.
     */
    @Override
    public String closestPet(int x, int y) {
            double leastDistance = Double.MAX_VALUE;
            String farthestCat = "No Pets Found";
            for (Bird birdList: birds) {
                if (distanceBetweenCoords(x, y,birdList.location.x, birdList.location.y, birdList.wingsClipped) <  leastDistance){
                    leastDistance = distanceBetweenCoords(x, y,birdList.location.x, birdList.location.y, birdList.wingsClipped);
                    farthestCat = birdList.name;
                }
            }
            return farthestCat;
        }

    public double distanceBetweenCoords(int x, int y, int x2, int y2, Boolean clipped) {
        if (clipped){
        return Math.pow(((Math.pow(x2 - x, 2)) + (Math.pow(y2-y, 2))) , 0.5);
        }
        else {
            return Math.pow(((Math.pow(x2 - x, 2)) + (Math.pow(y2-y, 2))) + 4 , 0.5);
        }


    }

}
