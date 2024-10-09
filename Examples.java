
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Examples {

public Examples(){

    }

    /* ANIMAL TESTS */



    /* tests for eats() */
    @Test
    public void testBirdEats(){
        Bird b = new Bird("Blue",4,12,new Coord2D(2,2),false);
        assertEquals(1,b.eats("seeds"));
    }
    @Test
    public void testBirdDoesntEats(){
        Bird b = new Bird("red",6,16,new Coord2D(6,2),false);
        assertEquals(0,b.eats("tomato"));
    }


    @Test
    public void testChinchillaEatsPellets(){
        Chinchilla ch = new Chinchilla("Chi",4,90,new Coord2D(0,0), 4);
        assertEquals(3,ch.eats("pellets"));
    }
    @Test
    public void testChinchillaEatsHay(){
        Chinchilla ch = new Chinchilla("Chi",4,90,new Coord2D(0,0), 4);
        assertEquals(1,ch.eats("hay"));
    }
    @Test
    public void testChinchillaDoesntEats(){
        Chinchilla ch = new Chinchilla("Block",4,90,new Coord2D(0,0), 4);
        assertEquals(0,ch.eats("Tomato"));
    }



    @Test
    public void testCatEatsCanNotPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(7,2),false);
        assertEquals(1,c.eats("cans"));
    }
    @Test
    public void testCatEatsYesPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(7,2),true);
        assertEquals(2,c.eats("cans"));
    }
    @Test
    public void testCatEatsTreatsBaby(){
        Cat c = new Cat("Kitten",1,6,new Coord2D(0,9),true);
        assertEquals(1,c.eats("treats"));
    }
    @Test
    public void testCatEatsTreatsAdult(){
        Cat c = new Cat("Kitten",4,24,new Coord2D(0,9),true);
        assertEquals(4,c.eats("treats"));
    }
    @Test
    public void testCatDoesntEat(){
        Cat c = new Cat("Kitten",4,6,new Coord2D(8,2),true);
        assertEquals(0,c.eats("brick"));
    }






/* Tests getWeightInOz */

    @Test
    public void testChinchillaWeightInOz(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(24, ch.getWeightInOz());
    }
    @Test
    public void testChinchillaWeightInOzClean() {
        Chinchilla ch = new Chinchilla("cleany", 4, 20, new Coord2D(0, 0), 0);
        assertEquals(20, ch.getWeightInOz());
    }

    @Test
    public void testCatWeightInOz(){
        Cat c = new Cat("Ar",4,19,new Coord2D(7,2),true);
        assertEquals(19, c.getWeightInOz());
    }
    @Test
    public void testBirdWeightInOz(){
        Bird b = new Bird("red",6,16,new Coord2D(6,2),false);
        assertEquals(16, b.getWeightInOz());
    }



    /* Tests getAge */
    @Test
    public void testChinchillaAgeYears(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(4, ch.getAge());
    }
    @Test
    public void testCatAgeYears(){
        Cat c = new Cat("Ar",3,19,new Coord2D(7,2),true);
        assertEquals(3, c.getAge());
    }
    @Test
    public void testBirdAgeYears(){
        Bird b = new Bird("red",6,16,new Coord2D(6,2),false);
        assertEquals(6, b.getAge());
    }



    /* Tests getName */
    @Test
    public void animalGetName(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals("Blue", b.getName());
        assertEquals("Aria", c.getName());
        assertEquals("Dusty", ch.getName());
    }










    /** ZONE Tests */





    /* Tests heaviestPet */
    @Test
    public void birdZoneTestHeaviestBird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Red",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Red", bz.heaviestPet().getName());
    }
    @Test
    public void catZoneTestHeaviestCat(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Aria",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("Bugly",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);
        assertEquals("Bugly", cz.heaviestPet().getName());
    }
    @Test
    public void chinchillaZoneTestHeaviestChinchilla(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add (new Chinchilla("Tup",4,30,new Coord2D(0,0), 4));
        chinchillas.add (new Chinchilla("Tim",4,20,new Coord2D(0,0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Tup", chz.heaviestPet().getName());
    }
    @Test
    public void chinchillaZoneTestNoPets(){
        LinkedList<Chinchilla> noChinchillas = new LinkedList<Chinchilla>();
        ChinchillaZone chz = new ChinchillaZone(noChinchillas);
        assertNull(chz.heaviestPet());
    }
    @Test
    public void birdZoneTestNoPets(){
        LinkedList<Bird> noBirds = new LinkedList<Bird>();
        BirdZone bz = new BirdZone(noBirds);
        assertNull(bz.heaviestPet());
    }
    @Test
    public void catZoneTestNoPets(){
        LinkedList<Cat> noCats = new LinkedList<Cat>();
        CatZone cz = new CatZone(noCats);
        assertNull(cz.heaviestPet());
    }




    /* Tests petsInZone */
    @Test
    public void birdZoneTestPetsInZoneBird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Redo",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(2, bz.petsInZone());
    }
    @Test
    public void catZoneTestPetsInZoneCat(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Aria",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("Bugy",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);
        assertEquals(2, cz.petsInZone());
    }
    @Test
    public void chinchillaZoneTestPetsInZoneChinchilla() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Tu", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Tim", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(2, chz.petsInZone());
    }





    /* Tests inHumanYears */
    @Test
    public void birdZoneTestInHumanYearsBird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Bluey",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Redo",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(81, bz.inHumanYears("Redo"));
    }
    @Test
    public void catZoneTestInHumanYearsCat(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Arian",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("Bugy",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);
        assertEquals(24, cz.inHumanYears("Arian"));
    }
    @Test
    public void chinchillaZoneTestInHumanYearsNoChinchilla() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Tutu", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Tim", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(40, chz.inHumanYears("Tim"));
    }
    @Test
    public void chinchillaZoneTestInHumanYearsChinchilla() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(-1, chz.inHumanYears("Tim"));
    }

    @Test
    public void birdZoneTestInHumanYearsNoBird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        BirdZone bz = new BirdZone(birds);
        assertEquals(-1, bz.inHumanYears("Redo"));
    }
    @Test
    public void catZoneTestInHumanYearsNoCat(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        CatZone cz = new CatZone(cats);
        assertEquals(-1, cz.inHumanYears("Arian"));
    }






    /* Tests restockPetFood */

    @Test
    public void chinchillaZoneTestRestockPetFoodPellets(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Tiu", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Tim", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals(chz, chz.restockPetFood("pellets", 5));
    }
    @Test
    public void chinchillaZoneTestRestockPetFoodHay(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Titi", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Tim", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(chz, chz.restockPetFood("hay", 8));
    }
    @Test
    public void birdZoneTestRestockPetFoodSeed(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Bluet",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Redo",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);

        assertEquals(bz, bz.restockPetFood("seeds", 85));
    }
    @Test
    public void catZoneTestRestockPetFoodCans(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Arian",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("Bugs",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);

        assertEquals(cz, cz.restockPetFood("cans", 6));
    }
    @Test
    public void catZoneTestRestockPetFoodCansTwice(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Arian",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("Bee",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);

        assertEquals("Cat: 42 cans, 0 treats", cz.restockPetFood("cans", 12).restockPetFood("cans", 30).getPantryLabel());
    }
    @Test
    public void catZoneTestRestockPetFoodTreats(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Arian",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("Catness",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);

        assertEquals(cz, cz.restockPetFood("treats", 40));
    }
    @Test
    public void catZoneTestRestockPetFoodTreatsTwice(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Arian",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("man",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);

        assertEquals(cz, cz.restockPetFood("treats", 30).restockPetFood("cans", 40));
    }





    /* Tests feedZone */
    @Test
    public void catZoneTestFeedZone(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add (new Cat("Avy",4,20,new Coord2D(0,0), true));
        cats.add (new Cat("Kit",4,80,new Coord2D(0,0), true));
        CatZone cz = new CatZone(cats);

        assertEquals(cz, cz.feedZone());

    }
    @Test
    public void birdZoneTestFeedZone(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Bullet",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Redone",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);

        assertEquals(bz, bz.feedZone());
    }

    @Test
    public void chinchillaZoneTestFeedZone(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Tiu", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Taco", 4, 20, new Coord2D(0, 0), 0));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals(chz, chz.feedZone());
    }
    @Test
    public void chinchillaZoneTestFeedZoneBug(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Tiu", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Tacoo", 4, 20, new Coord2D(0, 0), 0));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("Chinchilla: 0 pellets, 0 hay", chz.feedZone().getPantryLabel());
    }

    @Test
    public void noChinchillaZoneTestFeedZone(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(chz, chz.feedZone());
    }






    /* Tests getPet */
    @Test
    public void chinchillaZoneTestGetPet(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Tie", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Taco", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("Tie", chz.getPet("Tie").getName());
    }
    @Test
    public void birdZoneTestGetPet(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Brad",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Redone",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);

        assertEquals("Brad", bz.getPet("Brad").getName());
    }

    @Test
    public void catZoneTestGetPet() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Al", 4, 20, new Coord2D(0, 0), true));
        cats.add(new Cat("Kit", 4, 80, new Coord2D(0, 0), true));
        CatZone cz = new CatZone(cats);

        assertEquals("Al", cz.getPet("Al").getName());
    }
    @Test
    public void noChinchillaZoneTestGetPet(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Tioe", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Taco", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertNull( chz.getPet("Tim"));;
    }
    @Test
    public void noBirdZoneTestGetPet(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Brado",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Redone",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);

        assertNull( bz.getPet("Tim"));;
    }

    @Test
    public void noCatZoneTestGetPet() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Ali", 4, 20, new Coord2D(0, 0), true));
        cats.add(new Cat("Kit", 4, 80, new Coord2D(0, 0), true));
        CatZone cz = new CatZone(cats);

        assertNull( cz.getPet("Tim"));
    }




    /* getPantryLabel()*/
    @Test
    public void chinchillaZoneTestGetPantryLabel(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("yams", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Taff", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("Chinchilla: 58 pellets, 9 hay", chz.restockPetFood("pellets", 58).restockPetFood("hay", 9).getPantryLabel());
    }
    @Test
    public void chinchillaZoneTestGetPantryLabelPellets(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("yams", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Taf", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("Chinchilla: 58 pellets, 0 hay", chz.restockPetFood("pellets", 58).getPantryLabel());
    }
    @Test
    public void chinchillaZoneTestGetPantryLabelHay(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("yamsss", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Taff", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("Chinchilla: 0 pellets, 9 hay", chz.restockPetFood("hay", 9).getPantryLabel());
    }
    @Test
    public void birdZoneTestGetPantryLabel(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Brock",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Reese",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);

        assertEquals("Bird: 3 seeds", bz.restockPetFood("seeds", 3).getPantryLabel());
    }

    @Test
    public void catZoneTestGetPantryLabel() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Cal", 4, 20, new Coord2D(0, 0), true));
        cats.add(new Cat("Kim", 4, 80, new Coord2D(0, 0), true));
        CatZone cz = new CatZone(cats);

        assertEquals("Cat: 3 cans, 9 treats", cz.restockPetFood("cans", 3).restockPetFood("treats", 9).getPantryLabel());
    }

    @Test
    public void catZoneTestGetPantryLabelCans() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Call", 4, 20, new Coord2D(0, 0), true));
        cats.add(new Cat("Kim", 4, 80, new Coord2D(0, 0), true));
        CatZone cz = new CatZone(cats);

        assertEquals("Cat: 3 cans, 0 treats", cz.restockPetFood("cans", 3).getPantryLabel());
    }
    @Test
    public void catZoneTestGetPantryLabelTreats() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Call", 4, 20, new Coord2D(0, 0), true));
        cats.add(new Cat("Kimm", 4, 80, new Coord2D(0, 0), true));
        CatZone cz = new CatZone(cats);

        assertEquals("Cat: 0 cans, 9 treats", cz.restockPetFood("treats", 9).getPantryLabel());
    }
    @Test
    public void chinchillaZoneTestGetPantryLabelNoFood(){
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("yams", 4, 30, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Taffy", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("Chinchilla: 0 pellets, 0 hay", chz.getPantryLabel());
    }
    @Test
    public void birdZoneTestGetPantryLabelNoFood(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Brocky",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("Reese",9,98,new Coord2D(9,2),true));
        BirdZone bz = new BirdZone(birds);

        assertEquals("Bird: 0 seeds", bz.getPantryLabel());
    }

    @Test
    public void catZoneTestGetPantryLabelNoFood() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Cal", 4, 20, new Coord2D(0, 0), true));
        cats.add(new Cat("Kimmy", 4, 80, new Coord2D(0, 0), true));
        CatZone cz = new CatZone(cats);

        assertEquals("Cat: 0 cans, 0 treats", cz.getPantryLabel());
    }




    /*closestPet() */

    @Test
    public void birdZoneTestClosest(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        birds.add(new Bird("roo",1,3,new Coord2D(0,1),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.closestPet(4,5));
    }
    @Test
    public void birdZoneTestClosestdNoBird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        BirdZone bz = new BirdZone(birds);
        assertEquals("No Pets Found", bz.closestPet(4,5));
    }

    @Test
    public void catZoneTestClosest(){
    LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Cal", 4, 20, new Coord2D(0, 0), true));
        cats.add(new Cat("Keith", 4, 80, new Coord2D(4, 8), true));
    CatZone cz = new CatZone(cats);

    assertEquals("Keith", cz.closestPet(4,9));
}
    @Test
    public void catZoneTestClosestNoCat(){
        LinkedList<Cat> cats = new LinkedList<Cat>();
        CatZone cz = new CatZone(cats);

        assertEquals("No Pets Found", cz.closestPet(4,9));}

    @Test
    public void chinchillaZoneTestClosest() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("yam", 4, 30, new Coord2D(5, 3), 4));
        chinchillas.add(new Chinchilla("Taffy", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("yam", chz.closestPet(8, 9));
    }
    @Test
    public void chinchillaZoneTestClosestNoChinchilla() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        ChinchillaZone chz = new ChinchillaZone(chinchillas);

        assertEquals("No Pets Found", chz.closestPet(8, 9));
    }






    /* superPet Total */

    @Test
    public void petRescueTestTotalPetsTest(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird( "Blue",1, 3, new Coord2D(10,10),false ));
        birds.add(new Bird("red",5,12,new Coord2D(4,7), true));
        BirdZone bz = new BirdZone(birds);

        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("bandit",4,19,new Coord2D(6,3),false));
        CatZone cz = new CatZone(cats);

        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("sammy", 4, 30, new Coord2D(5, 3), 4));
        chinchillas.add(new Chinchilla("yo", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);


        LinkedList<Zoneable> spr = new LinkedList<>();
        spr.add(bz);
        spr.add(cz);
        spr.add(chz);

        SuperPetRescue superPetRescue = new SuperPetRescue(spr);
        assertEquals("makes sure that there are the right number of pets",5,superPetRescue.totalPets());

    }


    /* getHeaviestPetsName()*/

    @Test
    public void petRescueTestGetHeaviestPetsName() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(10, 10), false));
        birds.add(new Bird("yellow", 5, 12, new Coord2D(4, 7), true));
        BirdZone bz = new BirdZone(birds);

        LinkedList<Cat> cats = new LinkedList<>();
        cats.add(new Cat("bandit", 4, 19, new Coord2D(6, 3), false));
        cats.add(new Cat("toby", 4, 10, new Coord2D(6, 3), false));
        CatZone cz = new CatZone(cats);

        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("sam", 4, 30, new Coord2D(5, 3), 4));
        chinchillas.add(new Chinchilla("Taffy", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);


        LinkedList<Zoneable> spr = new LinkedList<>();
        spr.add(bz);
        spr.add(cz);
        spr.add(chz);

        SuperPetRescue superPetRescue = new SuperPetRescue(spr);
        assertEquals("sam", superPetRescue.getHeaviestPetsName());
    }


}

