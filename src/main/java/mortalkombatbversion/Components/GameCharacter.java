package mortalkombatbversion.Components;

import javax.swing.ImageIcon;

public class GameCharacter {

    private int level;
    private int health;
    private int maxhealth;
    private int damage;
    private int turnsWithDebuff;
    public ImageIcon icon;
    private final CharacterName name;

    public GameCharacter(int level, int health, int damage, CharacterName name) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.maxhealth = health;
        this.name=name;
    }

    public boolean isDebuffed() {
        return turnsWithDebuff > 0;
    }

    public void loseDebuffTurn() {
        if (turnsWithDebuff > 0) {
            turnsWithDebuff--;
        }
    }

    public void setDebuffTurns(int i) {
        turnsWithDebuff = i;
    }

    public int getDebuffTurns() {
        return turnsWithDebuff;
    }

    public void setPhoto(String path) {
        icon = new ImageIcon(path);
    }

    public ImageIcon getPhoto() {
        return icon;
    }
    public void setLevel(int i) {
        this.level = i;
    }
    public void addLevel() {
        this.level++;
    }

    public void addHealth(int h) {
        this.health += h;
    }

    public void setHealth(int h) {
        this.health = h;
    }
    public void setDamage(int d) {
        this.damage = d;
    }

    public void addDamage(int d) {
        this.damage += d;
    }

    public void setMaxHealth(int h) {
        this.maxhealth = h;
    }

    public void addMaxHealth(int h) {
        this.maxhealth += h;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getMaxHealth() {
        return this.maxhealth;
    }

    public CharacterName getName() {
        return name;
    }
    public String getStringName(){
       return name.getString();
    }

}
