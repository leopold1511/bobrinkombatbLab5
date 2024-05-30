/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Characters;

/**
 * @author Мария
 */
public class Player extends Character {


    private int points;
    private int experience;
    private int win;
    private int nextExperience;

    public Player(int level, int health, int damage, int attack) {
        super(level, health, damage, attack);
        this.points = 0;
        this.experience = 0;
        this.nextExperience = 40;
        this.win = 0;
    }


    public int getPoints() {
        return points;
    }

    public int getExperience() {
        return experience;
    }

    public int getNextExperience() {
        return nextExperience;
    }

    public int getWin() {
        return win;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public void setNextExperience(int experience) {
        this.nextExperience = experience;
    }

    public void setWin() {
        win++;
    }

    @Override
    public String getName() {
        return "You";
    }


}
