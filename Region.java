/* Your Full Name
[CS1101] Comprehensive Lab 3
This work is to be done individually. It is not permitted
to. share, reproduce, or alter any part of this assignment
for any purpose. Students are not permitted to share code,
upload this assignment online in any form, or
view/receive/ modifying code written by anyone else. This
assignment is part of an academic course at The University
of Texas at El Paso and a grade will be assigned for the
work produced individually by the student.
*/
import java.util.*;
public class Region{
    private String name;
    private String climate;
    private int difficulty;
    private Trainer [] trainerInRegion = new Trainer[10];
    private Pokemon [] wildPokemon = new Pokemon[20];

    // Constructors 
    Region(){

    }

    Region(String nameIn, int difficultyIn, String climateIn){
        this.name = nameIn;
        this.difficulty = difficultyIn;
        this.climate = climateIn;
    }

    Region(String nameIn, String climateIn, int difficultyIn, Trainer[] trainerInRegionIn){
        this.name = nameIn;
        this.climate = climateIn;
        this.difficulty = difficultyIn;
        this.trainerInRegion = trainerInRegionIn;
    }

    // Setters

    void setName(String nameIn){
        this.name = nameIn;
    }

    void setClimate(String climateIn){
        this.climate = climateIn;
    }

    void setDifficulty(int difficultyIn){
        this.difficulty = difficultyIn;
    }

    void setTrainerInRegionIn(Trainer [] trainerInRegionIn){
        this.trainerInRegion = trainerInRegionIn;
    }

    void setWildPokemon(Pokemon [] wildPokemonIn){
        this.wildPokemon = wildPokemonIn;
    }

    // Getters

    String getName(){
        return this.name;
    }

    String getClimate(){
        return this.climate;
    }

    int getDifficulty(){
        return this.difficulty;
    }

    Trainer [] getTrainerInRegion(){
        return this.trainerInRegion;
    }

    Pokemon [] getWildPokemon(){
        return this.wildPokemon;
    }

    // Methods

    // Look if the trainer arr is not null, and then place the trainer in to the array
    void addTrainer(Trainer t){
        for(int i = 0; i < trainerInRegion.length;i++){
            if(trainerInRegion[i] == null){
                trainerInRegion[i] = t;
                System.out.println(t.getName() + " has been added to the region!");
                break;
            }
        }

    }

    // Look if there match the name with one trainer in the trainerInRegion arr
    void removeTrainer(String name){
        boolean found = false;
        for(int i = 0; i < trainerInRegion.length; i++){
            if(trainerInRegion[i] != null && trainerInRegion[i].getName().equalsIgnoreCase(name)){
                trainerInRegion[i] = null;
                found = true;
                System.out.println("Trainer succesfully removed! ");
                break;
            }
        }
        if(!found){
            System.out.println("This trainer is not part of the region!");
        }

    }

    // It returns a random a wild pokemon at the position of a random num in the range of 20(the lenght of the wildPokemon arr)
    Pokemon generateWildPokemon(){
        Random rand = new Random();
        int randomNum = rand.nextInt(wildPokemon.length);

        if(wildPokemon[randomNum] != null){
            return wildPokemon[randomNum];
        }
    return null;

    }

    void describeRegion(){
        System.out.println("**************************");
        System.out.println("Name: " + getName());
        System.out.println("Climate: " + getClimate());
        System.out.println("Difficulty: " + getDifficulty());
        System.out.println("**************************");

    }

    // Split the interaction in: 
    // Method simulateInteraction
    //Look if the trainers passed in exist
    void simulateInteraction(String TrainerA, String TrainerB){
        Trainer trainerA = null;
        Trainer trainerB = null;

        // Create two temporary trainers, and look if their names math with our trainers in our arr
        for(int i = 0; i < trainerInRegion.length; i++){
            if(trainerInRegion[i] !=null){
                if(trainerInRegion[i].getName().equalsIgnoreCase(TrainerA)){
                    trainerA = trainerInRegion[i];
                }else if(trainerInRegion[i].getName().equalsIgnoreCase(TrainerB)){
                    trainerB = trainerInRegion[i];
                }

            }

        }
        if(trainerA == null || trainerB == null){
            System.out.println("One or both trainers not found in the region!");
            return;
        }

        System.out.println("Simulating interaction between " + trainerA.getName() + " and " + trainerB.getName());

        // Create 2 pokemons, base on the partners of our trainers
        Pokemon pokemonOne = trainerA.getPartner();
        Pokemon pokemonTwo = trainerB.getPartner();

        if(pokemonOne == null){
            System.out.println(trainerA.getName() + " has no partner");
        }else{
            pokemonOne.speak();
        }

        if(pokemonTwo == null){
            System.out.println(trainerB.getName() + " has no partner");
        }else{
            pokemonTwo.speak();
        }

        if(pokemonOne != null && pokemonTwo != null){
            simulateBattle(pokemonOne, pokemonTwo);

        }

        
    }

    // Method simulateBattle
    void simulateBattle(Pokemon pokemonOne, Pokemon pokemonTwo){ // Take in the two pokemon partners
        // Make two temporary Strings for trainers, then assign the real name of the trainers when it enters to the loop
        String trainerA = "Trainer A";
        String trainerB = "Trainer B";
        for(int i = 0; i < trainerInRegion.length; i++){
            if(trainerInRegion[i] != null){
                if(trainerInRegion[i].getPartner() == pokemonOne){
                    trainerA = trainerInRegion[i].getName();
                }else if(trainerInRegion[i].getPartner() == pokemonTwo){
                    trainerB = trainerInRegion[i].getName();
                }
            }
        }

        // loop to simulate the battle
        while(pokemonOne.getHealth() > 0 && pokemonTwo.getHealth() > 0){

            int damageOne = calculateDamage(pokemonOne, pokemonTwo); // calculate the damage from pokemonOne(attack) to pokemonTwo(receive)
            pokemonTwo.setHealth(pokemonTwo.getHealth() - damageOne);

            System.out.println(trainerA + " attacks with " + pokemonOne.getName());
            System.out.println(pokemonTwo.getName() + " health reaches " + pokemonTwo.getHealth());

            int damageTwo = calculateDamage(pokemonTwo, pokemonOne); // calculate the damage from pokemonOne(attack) to pokemonTwo(recieve)
            pokemonOne.setHealth(pokemonOne.getHealth() - damageTwo);

            System.out.println(trainerB + " attacks with " + pokemonTwo.getName());
            System.out.println(pokemonOne.getName() + " health reaches " + pokemonOne.getHealth());

        if (pokemonOne.getHealth() <= 0) {
            System.out.println(pokemonTwo.getName() + " wins!");
        } else if(pokemonTwo.getHealth() <= 0){
            System.out.println(pokemonOne.getName() + " wins!");
        }
        }
        
    }

    // Method calculateDamage
    int calculateDamage(Pokemon attack, Pokemon recieve){ // takes the two pokemons, one as a attacker, and one as a reciever
        int damage = attack.getAttackDamage(); // get the num of damage of the pokemon
        String attackerType = attack.getType(); // the type of the pokemon
        String defenderType = recieve.getType(); // the type of the rival pokemon


        if (attackerType.equalsIgnoreCase(defenderType)) {
        } else if ((attackerType.equalsIgnoreCase("Fire") && defenderType.equalsIgnoreCase("Grass")) ||(attackerType.equalsIgnoreCase("Water") && defenderType.equalsIgnoreCase("Fire")) ||
                (attackerType.equalsIgnoreCase("Grass") && defenderType.equalsIgnoreCase("Water"))) {
            damage *= 2; 
        } else if ((attackerType.equalsIgnoreCase("Fire") && defenderType.equalsIgnoreCase("Water")) ||(attackerType.equalsIgnoreCase("Water") && defenderType.equalsIgnoreCase("Grass")) ||
                (attackerType.equalsIgnoreCase("Grass") && defenderType.equalsIgnoreCase("Fire"))) {
            damage /= 2;
        }
        return damage;


    }

    void getDetails(String name){
        System.out.println("**************************");
        boolean found = false;
        for(int i = 0; i < wildPokemon.length; i++){
            if(wildPokemon[i] != null && wildPokemon[i].getName().equalsIgnoreCase(name)){
                wildPokemon[i].getDetails();
                found = true;
            }
        }
        if(!found){
            System.out.println("This pokemon is not in the region!");
        }

    }

    // Look for an empty space to place the pokemon
    void addWildPokemon(Pokemon p){
        for(int i = 0; i < wildPokemon.length;i++){
            if(wildPokemon[i] == null){
                wildPokemon[i] = p;
                break;
            }
        }       
    }

    void removeWildPokemon(String p){
        boolean found = false;
        for(int i = 0; i < wildPokemon.length; i++){
            if(wildPokemon[i] != null && wildPokemon[i].getName().equalsIgnoreCase(p)){
                wildPokemon[i] = null;
                found = true;
                System.out.println(p + "has fled the region");
                break;
            }
        }
        if(!found){
            System.out.println("This Pokemon is not part of the region!");
        }

    }


}