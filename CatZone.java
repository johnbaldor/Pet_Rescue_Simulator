import java.util.LinkedList;

public class CatZone extends AbsZoneable implements Zoneable {
    public LinkedList<Cat> cats;
    public int cans;
    public int treats;

    public CatZone(LinkedList<Cat> cats) {
        this.cats = cats;
        cans = 0;
        treats = 0;
    }

    @Override
    public LinkedList<? extends Petable> getPets() {
        return cats;
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
        for (Cat catList : cats) {
            if (catList.getName().equals(petName)) {
                return (catList.age * 6);
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
        if (foodName.equals("cans")) {
            cans += foodAmt;
        } else if (foodName.equals("treats")) {
            treats += foodAmt;
        }
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
        for (Cat catList : cats) {
            cans -= catList.eats("cans");
            treats -= catList.eats("treats");
        }
        if (cans < 0) {
            cans = 0;
        }
        if (treats < 0) {
            treats = 0;
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
        for (Cat catList : cats) {
            if (catList.name.equals(petName)) {
                return catList;
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
        return ("Cat: " + cans + " cans, " + treats + " treats");
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
        for (Cat catList : cats) {
            if (distanceBetweenCoords(x, y, catList.location.x, catList.location.y) < leastDistance) {
                leastDistance = distanceBetweenCoords(x, y, catList.location.x, catList.location.y);
                farthestCat = catList.name;
            }
        }
        return farthestCat;
    }

    public double distanceBetweenCoords(int x, int y, int x2, int y2) {

        return Math.pow(((Math.pow(x2 - x, 2)) + (Math.pow(y2 - y, 2))), 0.5);
    }
}


