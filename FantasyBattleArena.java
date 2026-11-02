import java.util.*;

// Interface
interface SpecialAbility {
    void useSpecialAbility();
}

// Parent class
class Character {
    protected String name;
    protected int health;

    // Parameterized constructor
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }
    

    // Display character details
    public void displayDetails() {
        System.out.println("Character: " + name);
        System.out.println("Health: " + health);
    }

    // General attack method
    public void attack() {
        System.out.println(name + " performs a general attack!");
    }

    // Bonus method
    public void takeDamage(int damage) {
        health -= damage;

        if (health < 0) {
            health = 0;
        }

        System.out.println(name + " takes " + damage + " damage!");
        System.out.println("Remaining health: " + health);
    }
}

// Warrior class
class Warrior extends Character implements SpecialAbility {
    private String weapon;

    // Parameterized constructor
    public Warrior(String name, int health, String weapon) {
        super(name, health);
        this.weapon = weapon;
    }

    // Method overriding
    @Override
    public void attack() {
        System.out.println(name + " attacks using a " + weapon + "!");
    }

    // Interface method implementation
    @Override
    public void useSpecialAbility() {
        System.out.println(name + " performs a powerful sword attack!");
    }
}

// Mage class
class Mage extends Character implements SpecialAbility {
    private int magicPower;

    // Parameterized constructor
    public Mage(String name, int health, int magicPower) {
        super(name, health);
        this.magicPower = magicPower;
    }

    // Method overriding
    @Override
    public void attack() {
        System.out.println(name + " attacks using magic!");
    }

    // Interface method implementation
    @Override
    public void useSpecialAbility() {
        System.out.println(name + " casts a powerful magic spell!");
    }
}

// Archer class
class Archer extends Character implements SpecialAbility {
    private int arrows;

    // Parameterized constructor
    public Archer(String name, int health, int arrows) {
        super(name, health);
        this.arrows = arrows;
    }

    // Method overriding
    @Override
    public void attack() {
        System.out.println(name + " attacks using arrows!");
    }

    // Interface method implementation
    @Override
    public void useSpecialAbility() {
        System.out.println(name + " fires multiple arrows!");
    }
}

// Main class
public class FantasyBattleArena {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get Warrior details
        System.out.print("Enter Warrior name: ");
        String warriorName = scanner.nextLine();

        System.out.print("Enter Warrior health: ");
        int warriorHealth = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        // Get Mage details
        System.out.print("Enter Mage name: ");
        String mageName = scanner.nextLine();

        System.out.print("Enter Mage health: ");
        int mageHealth = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        // Get Archer details
        System.out.print("Enter Archer name: ");
        String archerName = scanner.nextLine();

        System.out.print("Enter Archer health: ");
        int archerHealth = scanner.nextInt();

        System.out.println();

        // Create objects using fixed values for additional fields
        Warrior warrior = new Warrior(warriorName, warriorHealth, "sword");
        Mage mage = new Mage(mageName, mageHealth, 100);
        Archer archer = new Archer(archerName, archerHealth, 20);

        // Parent-class references demonstrating polymorphism
        Character character1 = warrior;
        Character character2 = mage;
        Character character3 = archer;

        // Warrior
        character1.displayDetails();
        character1.attack();
        ((SpecialAbility) character1).useSpecialAbility();

        System.out.println();

        // Mage
        character2.displayDetails();
        character2.attack();
        ((SpecialAbility) character2).useSpecialAbility();

        System.out.println();

        // Archer
        character3.displayDetails();
        character3.attack();
        ((SpecialAbility) character3).useSpecialAbility();

        scanner.close();
    }
}