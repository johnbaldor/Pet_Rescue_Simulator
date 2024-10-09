public class Chinchilla extends AbsPetable{
    public int dustBathResidueInOz;

    public Chinchilla(String name, int age, int weightinOz, Coord2D location, int dustBathResidueInOz){
        super(name,age,weightinOz,location);
        this.dustBathResidueInOz = dustBathResidueInOz;
    }

    /**
     * how much of a particular food a pet will eat
     *
     * @param foodLabel the type of food being asked
     * @return a number (0 if the pet does not eat that food)
     */
    @Override
    public int eats(String foodLabel){
        if (foodLabel.equals("pellets")) {
            return 3;
        }
        else if ((foodLabel.equals("hay"))) {
            return 1;
        }
        else return 0;
    }
}
