/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion.Fabrics;

import mortalkombatbversion.Characters.Character;

/**
 *
 * @author Мария
 */
public class EnemyFabric {

    public Character create(int i, int j) {
        EnemyFabricInterface fabric = null;

        switch (i) {
            case 0:
                fabric = new BarakaFabric();
                break;
            case 1:
                fabric = new SubZeroFabric();
                break;
            case 2:
                fabric = new LiuKangFabric();
                break;
            case 3:
                fabric = new SonyaBladeFabric();
                break;
            case 4:
                fabric = new ShaoKahnFabric();
                break;
        }
        Character enemy = fabric.create(j);
        return enemy;
    }
}
