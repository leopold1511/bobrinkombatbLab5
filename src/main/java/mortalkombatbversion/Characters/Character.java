/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Characters;

/**
 * @author Мария
 */
public abstract class Character {

    private int level;
    private int health;
    private int maxHealth;
    private int damage;
    private int attack;

    public Character(int level, int health, int damage, int attack) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.attack = attack;
        this.maxHealth = health;
    }

    public void setLevel() {
        level++;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public void setNewHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage += damage;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttack() {
        return attack;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public abstract String getName();
}
