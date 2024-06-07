package mortalkombatbversion.Components;

public class Player extends GameCharacter {

    private int points;
    private int experience;
    private int nextexperience;
    private Items[] items;

    public Player(int level, int health, int damage, CharacterName name) {
        super(level, health, damage, name);
        this.points = 0;
        this.experience = 0;
        this.nextexperience = 40;
    }
    
    public void setItems(Items[] items){
        this.items = items;
    }
    public Items[] getItems(){
        return this.items;
    }
    public int getPoints() {
        return this.points;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getNextExperience() {
        return this.nextexperience;
    }
    
    public void resetPoints() {
        this.points = 0;
    }
    
    public void setPoints(int p) {
        this.points += p;
    }

    public void resetExperience() {
        this.experience = 0;
    }

    public void setExperience(int e) {
        this.experience += e;
    }

    public void setNextExperience(int e) {
        this.nextexperience = e;
    }

}
