public class Cat extends AbsPetable{
    public boolean hasBeenPetToday;

    public Cat(String name, int age, int weightinOz, Coord2D location, boolean hasBeenPetToday){
        super(name,age,weightinOz,location);
        this.hasBeenPetToday = hasBeenPetToday;
    }


    /**
     * how much of a particular food a pet will eat
     *
     * @param foodLabel the type of food being asked
     * @return a number (0 if the pet does not eat that food)
     */
    @Override
    public int eats(String foodLabel) {
        if ((foodLabel.equals("cans")) & this.hasBeenPetToday) {
            return 2;
        } else if ((foodLabel.equals("cans")) & (!this.hasBeenPetToday)) {
            return 1;
        } else if ((foodLabel.equals("treats"))) {
            return (1 + this.weightinOz / 8);
        }
        else return 0;
    }

}
