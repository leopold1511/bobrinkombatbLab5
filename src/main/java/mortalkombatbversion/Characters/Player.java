/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Characters;

/**
 *
 * @author Мария
 */
public class Player extends Character {
    

    private int points;
    private int experience;
    private int win;
    private int nextExperience;
    
    
    
    public Player(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
        this.points=0;
        this.experience=0;
        this.nextExperience =40;
        this.win=0;
    }
    

    public int getPoints(){
        return this.points;
    }
    public int getExperience(){
        return this.experience;
    }
    public int getNextExperience(){
        return this.nextExperience;
    }
    public int getWin(){
        return this.win;
    }

    public void setPoints(int p){
        this.points+=p;
    }
    public void setExperience(int e){
        this.experience+=e;
    }
    public void setNextExperience(int e){
        this.nextExperience =e;
    }
    public void setWin(){
        this.win++;
    }
    
    @Override
    public String getName(){
        return "You";
    }

    
}
