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
