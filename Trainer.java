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
public class Trainer{
    private String name;
    private Pokemon [] pokemonTeam = new Pokemon[6];
    private String [] badges;
    private boolean pokemonChampion;
    private Pokemon partner;

    // Constructor 

    Trainer(){

    }

    Trainer(String nameIn){
        this.name = nameIn;
    }

    Trainer(String nameIn, Pokemon[] pokemonTeamIn, String[] badgesIn, boolean pokemonChampionIn) {
        this.name = nameIn;
        this.pokemonTeam = pokemonTeamIn;
        this.badges = badgesIn;
        this.pokemonChampion = pokemonChampionIn;
    }

    // Setters
    void setName(String nameIn){
        this.name = nameIn;
    }

    void setPokemonTeam(Pokemon [] pokemonTeamIn){
        this.pokemonTeam = pokemonTeamIn;
    }

    void setBadges(String [] badgesIn){
        this.badges = badgesIn;
    }

    void setPokemonChampion(boolean pokemonChampionIn){
        this.pokemonChampion = pokemonChampionIn;
    }
    

    // Getters
    String getName(){
        return this.name;
    }

    Pokemon [] getPokemonTeam(){
        return this.pokemonTeam;
    }

    String [] getBadges(){
        return this.badges;
    }

    boolean getPokemonChampion(){
        return this.pokemonChampion;
    }

    Pokemon getPartner(){
        return this.partner;
    }

    // Methods


    // Look for an empty space to place the pokemon, and check if its null
    void addPokemon(Pokemon p){
        int countPokemons = 0;
        for(int i = 0; i < pokemonTeam.length; i++){
            if(pokemonTeam[i] == null){
                pokemonTeam[i] = p;
                System.out.println(p.getName() + " has been added to the team!");
                break;
            }else if(pokemonTeam[i] != null){
                countPokemons++;
                if(countPokemons == 6){
                    System.out.println("This team is full!");
                    break;
                }
            }
        }
    }

    void removePokemon(String name){
        boolean found = false;
        for(int i = 0; i < pokemonTeam.length; i++){
            if(pokemonTeam[i] != null && name.equalsIgnoreCase(pokemonTeam[i].getName())){
                pokemonTeam[i] = null;
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("This pokemon is not part of the team!");
        }
    }

    void getDetails(){
        System.out.println("**************************");
        System.out.println("Name: " + getName());

        System.out.print("Pokemon Team: ");

        if(pokemonTeam != null){
            for(int i = 0; i < pokemonTeam.length; i++){
                if(pokemonTeam[i] != null){
                    System.out.println(pokemonTeam[i].getName() + ", ");
                }
            }
        }else{
            System.out.println("This trainer has no Pokemons on its team");
        }

        System.out.print("Badges: " );
        if(badges != null){
            for(int i = 0; i < badges.length; i++){
                if(badges[i] != null){
                    System.out.println(badges[i] + ", ");

                }
            }
        }else{
            System.out.println("This trainer has no badges");
        }

        System.out.print("Pokemon Champion: ");
        if(pokemonChampion == true){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        System.out.println("Partner: ");
        if(partner != null){
            System.out.print(getPartner().getName());
        }else{
            System.out.println("This trainer does not have partner!");
        }
        System.out.println("**************************");
    }

    // Check if the pokemon team isnt null and if the pokemon the user choose match. Then it place the partner in the pokemon team 
    void choosePartner(String name){
        for(int i = 0; i < pokemonTeam.length; i++ ){
            if (pokemonTeam[i] != null && pokemonTeam[i].getName().equalsIgnoreCase(name)) {
                this.partner = pokemonTeam[i]; 
                break;
            }
        }

    }

    void trainPokemon(){
        for(int i = 0; i < pokemonTeam.length; i++){
            if(pokemonTeam[i] != null){
                pokemonTeam[i].levelUp();
            }
        }
        System.out.println("All pokemon have leveled up!");
    }

    // Method to print the pokemon team arr
    void printPokemonTeam(){
        if(pokemonTeam != null){
            for(int i = 0; i < pokemonTeam.length; i++){
                if(pokemonTeam[i] != null){
                    System.out.println(pokemonTeam[i].getName() + ", ");
                }

            }
        }
    }
}