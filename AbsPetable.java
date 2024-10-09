public abstract class AbsPetable implements Petable {
    public String name;
    public int age;
    public int weightinOz;
    public Coord2D location;

    public AbsPetable (String name, int age, int weightinOz, Coord2D location) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.weightinOz = weightinOz;
    }

        /**
         * Produces the name of this pet in the rescue
         *
         * @return the pet's name as a string
         */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * the weight of the pet in Oz
     *
     * @return the weight rounded to the nearest oz
     */
    @Override
    public int getWeightInOz() {
        return this.weightinOz;
    }

    /**
     * get the age of the pet
     *
     * @return the age of the pet in years
     */
    @Override
    public int getAge() {
        return this.age;
    }
    @Override
    public abstract int eats(String foodLabel);


}
