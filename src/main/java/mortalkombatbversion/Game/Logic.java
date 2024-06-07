package mortalkombatbversion.Game;

import mortalkombatbversion.Components.Player;
import mortalkombatbversion.Components.Items;
import mortalkombatbversion.Components.GameCharacter;
import mortalkombatbversion.Actions.Action;

import java.util.ArrayList;

public class Logic {

    private final int[] experience_for_next_level = {40, 90, 180, 260, 410, 1000};

    public Action chooseEnemyAction(GameCharacter enemy, ArrayList<Action> list) {
        switch (enemy.getName()) {
            case SUB_ZERO -> {
                return list.get((int) (Math.random() * 3));
            }
            case SHAO_KAHN -> {
                list.remove(2);
                return list.get((int) (Math.random() * 3));
            }
            default -> {
                return list.get((int) (Math.random() * 2));
            }
        }
    }

    public void addPoints(Player player) {
        player.setExperience(20 + 5 * player.getLevel());
        player.setPoints(20 + 5 * player.getLevel() + player.getHealth() / 4);
    }

    public boolean checkExperience(Player player) {
        return player.getExperience() >= player.getNextExperience();
    }

    public void levelUp(Player player, GameCharacter[] enemies) {
        player.addLevel();
        int i = 0;
        while (player.getNextExperience() >= experience_for_next_level[i]) {
            i = i + 1;
        }
        player.setNextExperience(experience_for_next_level[i]);
        for (int j = 0; j < 5; j++) {
            newHealthEnemy(enemies[j], player);
        }
    }

    public void addPointsBoss(Player player) {
        player.setExperience(50);
        player.setPoints(65 + player.getHealth() / 2);
    }

    public void addItems(int k1, int k2, int k3, Items[] items) {
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

    public void addHealthToPlayer(Player player) {
        player.addMaxHealth(40 + 5 * player.getLevel());
    }

    public void addDamageToPlayer(Player player) {
        player.addDamage(5 + player.getLevel());
    }

    public void newHealthEnemy(GameCharacter enemy, Player player) {
        enemy.addMaxHealth(enemy.getMaxHealth() * (35 - 3 * player.getLevel()) / 100);
        enemy.addDamage(enemy.getDamage() * (20 + player.getLevel()) / 100);
        enemy.addLevel();
    }

    public void useItem(GameCharacter human, Items[] items, String name, Mediator mediator) {
        switch (name) {
            case "First item" -> {
                if (items[0].getCount() > 0) {
                    human.addHealth((int) (human.getMaxHealth() * 0.25));
                    items[0].setCount(-1);
                } else {
                    mediator.openCantUseItemDialog();
                }
            }
            case "Second item" -> {
                if (items[1].getCount() > 0) {
                    human.addHealth((int) (human.getMaxHealth() * 0.5));
                    items[1].setCount(-1);
                } else {
                    mediator.openCantUseItemDialog();
                }
            }
            case "Third item" -> mediator.openCantUseItemDialog();
        }
    }

    public void resetEnemies(GameCharacter[] enemiesList) {
        for (GameCharacter enemy : enemiesList) {
            enemy.setLevel(1);
            switch (enemy.getName()) {
                case SUB_ZERO -> {
                    enemy.setDamage(16);
                    enemy.setMaxHealth(60);
                }
                case SONYA_BLADE -> {
                    enemy.setDamage(16);
                    enemy.setMaxHealth(80);
                }
                case SHAO_KAHN -> {
                    enemy.setDamage(30);
                    enemy.setMaxHealth(100);
                }
                case LIU_KANG -> {
                    enemy.setDamage(20);
                    enemy.setMaxHealth(70);
                }
                case BARAKA -> {
                    enemy.setDamage(12);
                    enemy.setMaxHealth(100);
                }
            }
        }
    }
}
