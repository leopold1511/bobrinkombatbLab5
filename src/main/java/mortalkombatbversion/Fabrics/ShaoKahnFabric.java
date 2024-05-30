/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Fabrics;

import mortalkombatbversion.Characters.Character;
import mortalkombatbversion.Characters.ShaoKahn;

/**
 *
 * @author Мария
 */
public class ShaoKahnFabric implements EnemyFabricInterface {
    
    @Override
    public Character create(int i) {
        Character enemy;
        if(i==0){
            enemy = new ShaoKahn(3, 100, 30, 1);
        }
        else{
           enemy = new ShaoKahn(3, 145, 44, 1); 
        }
        return enemy;
    }
}
