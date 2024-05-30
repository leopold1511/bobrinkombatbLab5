/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import mortalkombatbversion.Characters.Character;
import mortalkombatbversion.Characters.Player;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

/**
 *
 * @author Мария
 */
public class ChangeTexts {



    public void NewRoundTexts(Character player, Character enemy,
                              JLabel pointLabel, JLabel experienceLabel, JLabel playerLevelLable,
                              JLabel label4, JLabel label5, JLabel label6, JLabel label7, JLabel label8, JLabel label9,
                              int i, Items[] items, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3) {
        pointLabel.setText(Integer.toString(((Player) player).getPoints()));
        experienceLabel.setText(((Player) player).getExperience() + "/" + ((Player) player).getNextExperience());
        playerLevelLable.setText(player.getLevel() + " level");
        label4.setText(enemy.getLevel() + " level");
        label5.setText(player.getMaxHealth() + "/" + player.getMaxHealth());
        label6.setText(enemy.getMaxHealth() + "/" + enemy.getMaxHealth());
        label7.setText(Integer.toString(player.getDamage()));
        if (i % 2 == 1) {
            label8.setText("Your turn");
        }
        else{
            label8.setText(enemy.getName()+"'s turn");
        }
        BagText(items, rb1, rb2, rb3);
        label9.setText("");
    }

    public void RoundTexts(Character player, Character enemy, JLabel label, JLabel label2, int i, JLabel label3) {
        if (enemy.getHealth() >= 0) {
            label.setText(enemy.getHealth() + "/" + enemy.getMaxHealth());
        } else {
            label.setText("0/" + enemy.getMaxHealth());
        }
        if (player.getHealth() >= 0) {
            label2.setText(player.getHealth() + "/" + player.getMaxHealth());
        } else {
            label2.setText("0/" + player.getMaxHealth());
        }
        if (i % 2 == 1) {
            label3.setText("Your turn");
        }
        else{
            label3.setText(enemy.getName()+"'s turn");
        }
    }
    
    public void EndGameText(Player player, JLabel label){
        if(player.getWin()==12){
            label.setText("Победа на вашей стороне");
        }
        else {
            label.setText("Победа не на вашей стороне");
        }
    }
    
    public void BagText( Items[] items, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3){
        rb1.setText(items[0].getName()+", "+items[0].getCount()+" шт");
        rb2.setText(items[1].getName()+", "+items[1].getCount()+" шт");
        rb3.setText(items[2].getName()+", "+items[2].getCount()+" шт");
    }

}
