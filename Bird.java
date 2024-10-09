public class Bird extends AbsPetable {
    public boolean wingsClipped;

    public Bird(String name, int age, int weightinOz, Coord2D location, boolean wingsClipped){
      super(name,age,weightinOz,location);
        this.wingsClipped = wingsClipped;

    }


    /**
     * how much of a particular food a pet will eat
     *
     * @param foodLabel the type of food being asked
     * @return a number (0 if the pet does not eat that food)
     */
    @Override
    public int eats(String foodLabel) {
        if(foodLabel.equals("seeds")) {
            return 1;
        }
        else return 0;
     }
}
