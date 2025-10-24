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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CL3_Garcia{
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon(); // new pokemon
        Pokemon [] pokedex = new Pokemon[20]; //pokedex
        int count = 0;
        int numOfTrainersInRegion = 0; //curr trainers in region
        int numOfPokemonsInRegion = 0; // curr pokemons in region
        Region region = new Region("Johto", 1, "Tropical");
        Random rand = new Random();
        Pokemon [] newArrPokemon = new Pokemon[20]; // new Array of pokemons
        Trainer [] newATrainers = new Trainer[10]; // new array of trainers
        
        try {
            File file = new File("pokedex.txt");
            Scanner scann = new Scanner(file);

            while(scann.hasNextLine()){
                // each pokemon, their attributes are set by the scanner
                pokemon  = new Pokemon(scann.next(), scann.next(), 1, scann.nextInt(), scann.nextInt()); 
                pokedex[count] = pokemon;
                count++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Not found " + e);
        }
        System.out.println();
        Scanner userIn = new Scanner(System.in);
		boolean finish = false;

        while(!finish){
        System.out.println("****************************** \n * Welcome to Poke-Miner * \n ******************************");
        System.out.println("Options:");
        System.out.println("1. Modify Region");
        System.out.println("2. Add/Remove Trainer to Region");
        System.out.println("3. Add/Remove Wild Pokemon to Region");
        System.out.println("4. Modify Trainer");
        System.out.println("5. Add/remove Pokemon From Trainer ");
        System.out.println("6. List Pokemon in Trainer");
        System.out.println("7. Simulate interaction between two trainers");
        System.out.println("8. Exit");
        System.out.println("**************************");
        System.out.println("Select Option: ");
         
		int menuChoice;
        try {
		    menuChoice = userIn.nextInt();
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input. Please enter an integer between 1 and 8");
            userIn.next();
            continue;
        }
        userIn.nextLine();


        switch (menuChoice) {
            case 1:
                boolean endModify = false;
                region.describeRegion();

                // Start a loop that ends when the user inputs continue
                while(!endModify){
                    System.out.println("Would you like to modify region name, climate, difficulty(1-5) or continue?");
                    String modify = userIn.nextLine();

                        // Modify name
                        if(modify.equalsIgnoreCase("name")){
                            System.out.println("Input the new name: ");
                            modify = userIn.nextLine();
                            region.setName(modify);
                            region.describeRegion();
                        
                        // Modify climate
                        }else if(modify.equalsIgnoreCase("climate")){
                            System.out.println("Input the new climate: ");
                            modify = userIn.nextLine();
                            region.setClimate(modify);
                            region.describeRegion();
                            
                        // Modify difficulty
                        }else if(modify.equalsIgnoreCase("difficulty")){
                            System.out.println("Input the new difficulty (1-5): ");
                            int modifyDifficulty = userIn.nextInt();
                            while(!(modifyDifficulty >= 1 && modifyDifficulty <= 5)){
                                System.out.println("Invalid difficulty, please enter a valid one from 1 to 5: ");
                                modifyDifficulty = userIn.nextInt();
                            }
                            userIn.nextLine();
                            region.setDifficulty(modifyDifficulty);
                            region.describeRegion();
                            
                        
                        }else if (modify.equalsIgnoreCase("continue")) {
                            endModify = true;
                            break;
                            
                        }else {
                            System.out.println("Invalid option! ");
                            break;
                        }  

                }

                System.out.println();
                break;

            case 2:
                
                System.out.println("Would you like to add or remove a trainer to/from the region?");
                String addOrRemoveTrainer = userIn.nextLine();

                // If the user select add
                if(addOrRemoveTrainer.equalsIgnoreCase("add")){
                    System.out.println("Trainer Name: ");
                    addOrRemoveTrainer = userIn.nextLine();
                    Trainer trainer = new Trainer(addOrRemoveTrainer); // create a new Trainer
                    region.addTrainer(trainer);
                    newATrainers[numOfTrainersInRegion] = trainer; // Populate the new Array of trainers with the new trainers
                    numOfTrainersInRegion++; // add one each time a trainer is created
                    
                }else if(addOrRemoveTrainer.equalsIgnoreCase("remove")){
                    System.out.println("Trainer name: ");
                    addOrRemoveTrainer = userIn.nextLine();
                    region.removeTrainer(addOrRemoveTrainer);
                }

                System.out.println();
                break;

            case 3:
                System.out.println("Would you like to add or remove wild Pokémon to/from the region? ");
                String addOrRemovePokemon = userIn.nextLine();
                if(addOrRemovePokemon.equalsIgnoreCase("add")){
                    if(numOfPokemonsInRegion < 20){
                        Pokemon newPokemon = new Pokemon();
                        int randomPokemon = rand.nextInt(pokedex.length);

                        // The new pokemon added use the same values from the pokemon at the random number in the pokedex Array
                        newPokemon.setName(pokedex[randomPokemon].getName());
                        newPokemon.setType(pokedex[randomPokemon].getType());
                        newPokemon.setLevel(pokedex[randomPokemon].getLevel());
                        newPokemon.setHealth(pokedex[randomPokemon].getHealth());
                        newPokemon.setAttackDamage(pokedex[randomPokemon].getAttackDamage());
                        region.addWildPokemon(newPokemon);
                        newArrPokemon[numOfPokemonsInRegion] = newPokemon; // Populate the new Array of pokemons with the new pokemons
                        numOfPokemonsInRegion++;

                        
                        System.out.println("There's a new wild Pokemon called " + newPokemon.getName() + " in the region!");
                        break;
                    }else{
                        System.out.println("This region is full!");
                    }

                }else if(addOrRemovePokemon.equalsIgnoreCase("remove")){
                    System.out.println("Wild pokemon to remove: ");
                    addOrRemovePokemon = userIn.nextLine();
                    region.removeWildPokemon(addOrRemovePokemon);
                } else{
                    System.out.println("Invalid option! ");
                }


                System.out.println();
                break;

            case 4:
                for(int i = 0; i < numOfTrainersInRegion; i++){
                    if(newATrainers[i] == null){
                        System.out.println("There are no trainers in this region, please add one to modify!");
                        break;
                    }

                    System.out.println("Which Trainer? ");
                    String modifyTrainer = userIn.nextLine();
                    Trainer trainerToModify = null;
                    boolean finishModifyTrainer = false;
                            if(modifyTrainer.equalsIgnoreCase(newATrainers[i].getName())){
                                trainerToModify = newATrainers[i]; // We selected the trainer to modifiy, from the new array of trainers
                                newATrainers[i].getDetails();
                                while(!finishModifyTrainer){
                                    System.out.println("Would you like to modify name, champ status, partner or continue? ");
                                    modifyTrainer = userIn.nextLine();

                                    if(modifyTrainer.equalsIgnoreCase("name")){
                                        System.out.println("New Trainer Name: ");
                                        modifyTrainer = userIn.nextLine();
                                        newATrainers[i].setName(modifyTrainer);
                                        trainerToModify.setName(modifyTrainer);
                                        newATrainers[i].getDetails();

                                    }else if(modifyTrainer.equalsIgnoreCase("champ status")){
                                        System.out.println("New Champ Status (yes/no): ");
                                        modifyTrainer = userIn.nextLine();
                                        if(modifyTrainer.equalsIgnoreCase("yes")){
                                            newATrainers[i].setPokemonChampion(true);
                                            newATrainers[i].getDetails();
                                        }else if(modifyTrainer.equalsIgnoreCase("no")){
                                            newATrainers[i].setPokemonChampion(false);
                                            newATrainers[i].getDetails();
                                        }

                                    }else if(modifyTrainer.equalsIgnoreCase("partner")){
                                            System.out.println("New Partner: ");
                                            modifyTrainer = userIn.nextLine();

                                            if(modifyTrainer.equalsIgnoreCase("continue")){
                                                finishModifyTrainer = true;
                                                i = 100;
                                            }else{
                                                boolean partnerExists = false; //check if the partner exist
                                                // Check if the partner exists
                                                for (int j = 0; j < numOfPokemonsInRegion; j++) {
                                                    if (newArrPokemon[j] != null && newArrPokemon[j].getName().equalsIgnoreCase(modifyTrainer)) {
                                
                                                        trainerToModify.choosePartner(modifyTrainer);
                                                        partnerExists = true; 
                                                        System.out.println(trainerToModify.getName() + " is now partnered with " + modifyTrainer);
                                                        finishModifyTrainer = true;
                                                        break;  // Exit loop after finding the partner
                                                    
                                                }

                                                // If partner does not exist after the loop
                                                if (!partnerExists) {
                                                    System.out.println("Partner does not exist. Please try again.");
                                                }
                                                }
                                            }



                                    }else if(modifyTrainer.equalsIgnoreCase("continue")){
                                        finishModifyTrainer = true;
                                        i = 100;
                                        break;
                                        
                                    }

                                }

                            }else if(!(modifyTrainer.equalsIgnoreCase(newATrainers[i].getName()))){
                                System.out.println("This trainer doesnt exist! ");
                                    break;
                            }
                        
                    
            }

                System.out.println();
                break;
            case 5:
                // check if there are trainers
                if (numOfTrainersInRegion == 0) {
                    System.out.println("There are no trainers in this region, please add one first!");
                } else {
                    System.out.println("Which Trainer?");
                    String pokemonInTrainer = userIn.nextLine();
                    Trainer selectedTrainer = null; // create a new trainer as a temporary trainer

                    // check if there are trainers that match with the input
                    for (int i = 0; i < numOfTrainersInRegion; i++) {
                        if (newATrainers[i] != null && newATrainers[i].getName().equalsIgnoreCase(pokemonInTrainer)) {
                            selectedTrainer = newATrainers[i];
                            break;
                        }
                    }

                    if (selectedTrainer == null) {
                        System.out.println("This trainer doesnt exist!");
                    } else {
                        System.out.println("Would you like to add or remove Pokemon for Trainer?");
                        String addOrRemove = userIn.nextLine();

                        if (addOrRemove.equalsIgnoreCase("add")) {
                            if (numOfPokemonsInRegion > 0) {
                                Random random = new Random();
                                int randomIndex = random.nextInt(numOfPokemonsInRegion);
                                Pokemon pokemonToAdd = newArrPokemon[randomIndex];

                                //Look for a pokemon to add, using a random num
                                System.out.println("Pokemon Encountered:");
                                pokemonToAdd.getDetails();
                                selectedTrainer.addPokemon(pokemonToAdd);
                                System.out.println("There's a new team addition for " + selectedTrainer.getName() + "!");
                            } else {
                                System.out.println("No wild Pokemon available to add!");
                            }
                        } else if (addOrRemove.equalsIgnoreCase("remove")) {
                            System.out.print("Which pokemon would you like to remove? ");
                            String pokemonToRemove = userIn.nextLine();
                            selectedTrainer.removePokemon(pokemonToRemove);
                        } else {
                            System.out.println("Invalid option! ");
                        }
                    }
                }

                System.out.println();
                break;
            case 6:
                if (numOfTrainersInRegion == 0) {
                    System.out.println("There are no trainers in this region, please add one to modify!");
                } else {
                    System.out.println("Which trainer? ");
                    String listTrainerPokemons = userIn.nextLine();
                    Trainer trainerToList = null;

                    for (int j = 0; j < numOfTrainersInRegion; j++) {
                        if (newATrainers[j] != null && newATrainers[j].getName().equalsIgnoreCase(listTrainerPokemons)) {
                            trainerToList = newATrainers[j];
                            break;
                        }
                    }

                    if (trainerToList != null) {
                        System.out.println(trainerToList.getName() + "'s Pokemon Team: ");
                        trainerToList.printPokemonTeam();
                    } else {
                        System.out.println("Trainer not found!");
                    }
                }

                System.out.println();
                break;
            case 7:
                    System.out.println("Simulate interaction between two Trainers");
                    System.out.print("First Trainer: ");
                    String trainerAName = userIn.nextLine();
                    System.out.print("Second Trainer: ");
                    String trainerBName = userIn.nextLine();

                    // Find the trainers
                    Trainer trainerA = null;
                    Trainer trainerB = null;
                    for (int i = 0; i < numOfTrainersInRegion; i++) {
                        if (newATrainers[i] != null && newATrainers[i].getName().equalsIgnoreCase(trainerAName)) {
                            trainerA = newATrainers[i];
                        }
                        if (newATrainers[i] != null && newATrainers[i].getName().equalsIgnoreCase(trainerBName)) {
                            trainerB = newATrainers[i];
                        }
                    }

                    if(trainerA != null && trainerB != null){
                        region.simulateInteraction(trainerAName, trainerBName);
                    }
                System.out.println();
                break;
            case 8:
                System.out.println("Thank you for play Poke-Miner !");
                finish = true;
                System.out.println();
                break;
            default:
                System.out.println("That is not a valid choice. \n Back to menu! \n");
        }

        }
    }


}