/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Fabrics;


import mortalkombatbversion.Characters.Character;
import mortalkombatbversion.Characters.SonyaBlade;

/**
 *
 * @author Мария
 */
public class SonyaBladeFabric implements EnemyFabricInterface {

    @Override
    public Character create(int i) {
        Character enemy;
        enemy = new SonyaBlade(1, 80, 16, 1);
        return enemy;
    }

}
