/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Fabrics;


import mortalkombatbversion.Characters.Character;
import mortalkombatbversion.Characters.LiuKang;

/**
 *
 * @author Мария
 */
public class LiuKangFabric implements EnemyFabricInterface {

    @Override
    public Character create(int i) {
        Character enemy;
        enemy = new LiuKang(1, 70, 20, 1);
        return enemy;
    }
}
