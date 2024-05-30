/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Fabrics;


import mortalkombatbversion.Characters.Character;
import mortalkombatbversion.Characters.SubZero;

/**
 *
 * @author Мария
 */
public class SubZeroFabric implements EnemyFabricInterface {

    @Override
    public Character create(int i) {
        Character enemy;
        enemy = new SubZero(1, 60, 16, 1);
        return enemy;
    }

}
