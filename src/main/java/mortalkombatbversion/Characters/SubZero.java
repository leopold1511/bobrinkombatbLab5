/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Characters;

/**
 *
 * @author Мария
 */
public class SubZero extends Character {
    
    public SubZero(int level, int health, int damage , int attack){
        super(level, health, damage, attack);
    }
    
    @Override
    public String getName(){
        return "Sub-Zero";
    }
}
