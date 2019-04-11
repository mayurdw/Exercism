import java.util.Arrays;
import java.util.Random;

class DnDCharacter {
    private int ability = AssignPoints();
    private int strength = AssignPoints();
    private int dexterity = AssignPoints();
    private int constitution = AssignPoints();
    private int intelligence = AssignPoints();
    private int wisdom = AssignPoints();
    private int charisma = AssignPoints();
    private int HitPoints = 10 + this.modifier(this.constitution);

    private int AssignPoints(){
        int[] diceNumber = new int[4];
        Random dice = new Random();

        for ( int i = 0; i < diceNumber.length; i++ ){
            // random number generator code from https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
            diceNumber[i] = dice.nextInt((6-1) + 1) + 1;
        }

        Arrays.sort(diceNumber);
        return diceNumber[1] + diceNumber[2] + diceNumber[3];
    }
    int ability() {
        return this.ability;
    }

    int modifier(int input) {
        return Math.floorDiv( (input - 10 ), 2 );
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity(){
        return this.dexterity;
    }

    int getConstitution(){
        return this.constitution;
    }

    int getIntelligence(){
        return this.intelligence;
    }

    int getWisdom(){
        return this.wisdom;
    }

    int getCharisma(){
        return this.charisma;
    }

    int getHitpoints(){
        return this.HitPoints;
    }

}
