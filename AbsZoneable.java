import java.util.LinkedList;

public abstract class AbsZoneable implements Zoneable {


    public abstract LinkedList<? extends Petable> getPets();

    /**
     * Produces the number of pets in the zone
     *
     * @return the number of total pets in the zone
     */
    @Override
    public int petsInZone() {
        int counter = 0;
        for (Petable Pet: getPets()){
            counter += 1;
        }
        return counter;
    }

    /**
     * finds and produces the fattest animal available
     *
     * @return the heaviest pet (the one with the greatest weight according to its getWeightInOz() method)
     * @return null if there are no pets
     */
    @Override
    public Petable heaviestPet() {
        int biggestWeight = 0;
        Petable biggestPet = null;
        for (Petable Pet : getPets()) {
            if ( Pet.getWeightInOz() >biggestWeight){
                biggestWeight = Pet.getWeightInOz();
                biggestPet = Pet;
            }
        }
        return biggestPet;


    }

    /**
     * Looks up a pet in the zone and computers its age relative to human years
     *
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet calculation
     * or -1 if that pet name is not in this zone
     */
    @Override
    public abstract int inHumanYears(String petName);

    /**
     * @param foodName The name of a food item expected to be stocked in this zone's pantry
     * @param foodAmt  A non-negative number (>= 0) representing how much of that food is going into the pantry
     * @return `this` zone for the purpose of method chaining
     */
    @Override
    public abstract Zoneable restockPetFood(String foodName, int foodAmt);

    /**
     * For each animal in the zone, brings them in to eat
     * Use their eats() method on each type of food in the pantry for them
     *
     * @return `this` zone for the purpose of method chaining
     * If a food item in the zone goes negative, set it to 0. (No need for "unknown" logic).
     */
    @Override
    public abstract Zoneable feedZone();

    /**
     * Fetch me that pet!
     *
     * @param petName the pet to look up in the zone, you may assume the pet is in the zone
     * @return the pet with that name or null if pet is not in the zone
     */
    @Override
    public Petable getPet(String petName) {
        for (Petable Pet: getPets()){
            if(Pet.getName().equals(petName)){
                return Pet;
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
    public abstract String getPantryLabel();

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
    public abstract String closestPet(int x, int y);
}
