/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import mortalkombatbversion.Characters.*;
import mortalkombatbversion.Characters.Character;
import mortalkombatbversion.Fabrics.EnemyFabric;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Мария
 */
public class CharacterAction {

    private final int experience_for_next_level[] = {40, 90, 180, 260, 410, 1000};

    private final int kind_fight[][] = {{1, 0}, {1, 1, 0}, {0, 1, 0}, {1, 1, 1, 1}};

    private Character enemyes[] = new Character[6];

    EnemyFabric fabric = new EnemyFabric();

    private Character enemyy = null;

    public void setEnemyes() {
        enemyes[0] = fabric.create(0, 0);
        enemyes[1] = fabric.create(1, 0);
        enemyes[2] = fabric.create(2, 0);
        enemyes[3] = fabric.create(3, 0);
        enemyes[4] = fabric.create(4, 0);
        enemyes[5] = fabric.create(4, 0);
    }

    public Character[] getEnemyes() {
        return this.enemyes;
    }

    public Character ChooseEnemy(JLabel label, JLabel label2, JLabel text, JLabel label3) {
        int i = (int) (Math.random() * 4);
        ImageIcon icon1 = null;
        switch (i) {
            case 0:
                enemyy = enemyes[0];
                icon1 = new ImageIcon("Baraka.jpg");
                label2.setText("Baraka (танк)");
                break;
            case 1:
                enemyy = enemyes[1];
                icon1 = new ImageIcon("Sub-Zero.jpg");
                label2.setText("Sub-Zero (маг)");
                break;
            case 2:
                enemyy = enemyes[2];
                icon1 = new ImageIcon("Liu Kang.jpg");
                label2.setText("Liu Kang (боец)");
                break;
            case 3:
                enemyy = enemyes[3];
                icon1 = new ImageIcon("Sonya Blade.jpg");
                label2.setText("Sonya Blade (солдат)");
                break;
        }
        label.setIcon(icon1);
        text.setText(Integer.toString(enemyy.getDamage()));
        label3.setText(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }

    public Character ChooseBoss(JLabel label, JLabel label2, JLabel text, JLabel label3, int i) {
        ImageIcon icon1 = null;
        icon1 = new ImageIcon("Shao Kahn.png");
        label2.setText("Shao Kahn (босс)");
        switch (i) {
            case 2:
                enemyy = enemyes[4];
                break;
            case 4:
                enemyy = enemyes[5];
                break;
        }
        label.setIcon(icon1);
        text.setText(Integer.toString(enemyy.getDamage()));
        label3.setText(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }

    public int[] EnemyBehavior(int k1, int k2, int k3, int k4, double i) {
        int arr[] = null;
        if (i < k1 * 0.01) {
            arr = kind_fight[0];
        }
        if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            arr = kind_fight[1];
        }
        if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            arr = kind_fight[2];
        }
        if (i >= (k1 + k2 + k3) * 0.01 & i < 1) {
            arr = kind_fight[3];
        }
        return arr;
    }

    public int[] ChooseBehavior(Character enemy, CharacterAction action) {
        int arr[] = null;
        double i = Math.random();
        if (enemy instanceof Baraka) {
            arr = action.EnemyBehavior(15, 15, 60, 10, i);
        }
        if (enemy instanceof SubZero) {
            arr = action.EnemyBehavior(25, 25, 0, 50, i);
        }
        if (enemy instanceof LiuKang) {
            arr = action.EnemyBehavior(13, 13, 10, 64, i);
        }
        if (enemy instanceof SonyaBlade) {
            arr = action.EnemyBehavior(25, 25, 50, 0, i);
        }
        if (enemy instanceof ShaoKahn) {
            arr = action.EnemyBehavior(10, 45, 0, 45, i);
        }
        return arr;
    }

    public void HP(Character character, JProgressBar progress) {

        if (character.getHealth() >= 0) {
            progress.setValue(character.getHealth());
        } else {
            progress.setValue(0);
        }
    }

    public void AddPoints(Player player, Character[] enemyes) {
        switch (player.getLevel()) {
            case 0:
                player.setExperience(20);
                player.setPoints(25 + player.getHealth() / 4);
                break;
            case 1:
                player.setExperience(25);
                player.setPoints(30 + player.getHealth() / 4);
                break;
            case 2:
                player.setExperience(30);
                player.setPoints(35 + player.getHealth() / 4);
                break;
            case 3:
                player.setExperience(40);
                player.setPoints(45 + player.getHealth() / 4);
                break;
            case 4:
                player.setExperience(50);
                player.setPoints(55 + player.getHealth() / 4);
                break;
        }
        for (int i = 0; i < 5; i++) {
            if (experience_for_next_level[i] == player.getExperience()) {
                player.setLevel();
                player.setNextExperience(experience_for_next_level[i + 1]);
                NewHealthHuman(player);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], player);
                }
            }
        }
    }

    public void AddPointsBoss(Player player, Character[] enemyes) {
        switch (player.getLevel()) {
            case 2:
                player.setExperience(30);
                player.setPoints(45 + player.getHealth() / 2);
                break;
            case 4:
                player.setExperience(50);
                player.setPoints(65 + player.getHealth() / 2);
                break;
        }
        for (int i = 0; i < 5; i++) {
            if (experience_for_next_level[i] == player.getExperience()) {
                player.setLevel();
                player.setNextExperience(experience_for_next_level[i + 1]);
                NewHealthHuman(player);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], player);
                }
            }
        }
    }

    public void AddItems(int k1, int k2, int k3, Items[] items) {
        double i = Math.random();
        if (i < k1 * 0.01) {
            items[0].setCount(1);
        }
        if (i >= k1 * 0.01 & i < (k1 + k2) * 0.01) {
            items[1].setCount(1);
        }
        if (i >= (k1 + k2) * 0.01 & i < (k1 + k2 + k3) * 0.01) {
            items[2].setCount(1);
        }
    }

    public void NewHealthHuman(Player player) {
        int hp = 0;
        int damage = 0;
        switch (player.getLevel()) {
            case 1:
                hp = 25;
                damage = 3;
                break;
            case 2:
                hp = 30;
                damage = 3;
                break;
            case 3:
                hp = 30;
                damage = 4;
                break;
            case 4:
                hp = 40;
                damage = 6;
                break;
        }
        player.setMaxHealth(hp);
        player.setDamage(damage);
    }

    public void NewHealthEnemy(Character enemy, Player player) {
        int hp = 0;
        int damage = 0;
        switch (player.getLevel()) {
            case 1:
                hp = 32;
                damage = 25;
                break;
            case 2:
                hp = 30;
                damage = 20;
                break;
            case 3:
                hp = 23;
                damage = 24;
                break;
            case 4:
                hp = 25;
                damage = 26;
                break;
        }
        enemy.setMaxHealth((int) enemy.getMaxHealth() * hp / 100);
        enemy.setDamage((int) enemy.getDamage() * damage / 100);
        enemy.setLevel();
    }

    public void UseItem(Character human, Items[] items, String name, JDialog dialog, JDialog dialog1) {
        switch (name) {
            case "jRadioButton1":
                if (items[0].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.25));
                    items[0].setCount(-1);
                } else {
                    dialog.setVisible(true);
                    dialog.setBounds(300, 200, 400, 300);
                }
                break;
            case "jRadioButton2":
                if (items[1].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.5));
                    items[1].setCount(-1);
                } else {
                    dialog.setVisible(true);
                    dialog.setBounds(300, 200, 400, 300);
                }
                break;
            case "jRadioButton3":
                dialog.setVisible(true);
                dialog.setBounds(300, 200, 400, 300);
                break;
        }
        
        if(dialog.isVisible()==false){
            dialog1.dispose();
        }
    }
}
