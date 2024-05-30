/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Fabrics;


import mortalkombatbversion.Characters.Baraka;
import mortalkombatbversion.Characters.Character;

/**
 *
 * @author Мария
 */
public class BarakaFabric implements EnemyFabricInterface {

    @Override
    public Character create(int i) {
        Character enemy;
        enemy = new Baraka(1, 100, 12, 1);
        return enemy;
    }
}
