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
public class Pokemon{
    private String name;
    private String type;
    private int level = 1;
    private int health;
    private int attackDamage = 10;

    // Constructor 

    Pokemon(){

    }

    Pokemon(String nameIn, String typeIn){
        this.name = nameIn;
        this.type = typeIn;
    }

    Pokemon(String nameIn, String typeIn, int levelIn, int healthIn, int attackDamageIn){
        this.name = nameIn;
        this.type = typeIn;
        this.level = levelIn;
        this.health = healthIn;
        this.attackDamage = attackDamageIn;
    }

    // Setters
    void setName(String nameIn){
        this.name = nameIn;
    }

    void setType(String typeIn){
        this.type = typeIn;
    }

    void setLevel(int levelIn){
        this.level = levelIn;
    }

    void setHealth(int healthIn){
        this.health = healthIn;
    }

    void setAttackDamage(int attackDamageIn){
        this.attackDamage = attackDamageIn;
    }

    // Getters

    String getName(){
        return this.name;
    }

    String getType(){
        return this.type;
    }

    int getLevel(){
        return this.level;
    }

    int getHealth(){
        return this.health;
    }

    int getAttackDamage(){
        return this.attackDamage;
    }

    // Methods
    void levelUp(){
        this.level += 1;
        this.health += 14;
        this.attackDamage += 1;
    }

    void speak(){
        System.out.println(getName() + "!" + " " + getName() + "!");
    }

    void getDetails(){
        System.out.println("**************************");
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getType());
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack Damage: " + getAttackDamage());
        System.out.println("**************************");
    }
}