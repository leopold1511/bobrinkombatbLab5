package mortalkombatbversion.Game;

import mortalkombatbversion.Components.Player;
import mortalkombatbversion.Components.GameCharacter;
import mortalkombatbversion.Components.GameResults;
import mortalkombatbversion.Actions.*;

import java.util.ArrayList;

import static mortalkombatbversion.Components.CharacterName.SHAO_KAHN;

public class Fight {
    Mediator mediator;
    Player player;
    GameCharacter enemy;
    public Location location = new Location();
    public ArrayList<Action> actionsList = new ArrayList<>() {
        {
            add(new Hit());
            add(new Block());
            add(new Debuff());
            add(new Heal());
        }
    };

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setHuman(Player player) {
        this.player = player;
    }

    public void setEnemy(GameCharacter enemy) {
        this.enemy = enemy;
    }

    public Player getHuman() {
        return this.player;
    }

    public GameCharacter getEnemy() {
        return this.enemy;
    }

    public void playerMove(Action enemyAction, Action playerAction) {
        mediator.setActionLabels(enemy, player, enemyAction, playerAction);
        playerAction.realisation(player, enemy, enemyAction.getType());
    }

    public void enemyMove(Action enemyAction, Action playerAction) {
        mediator.setActionLabels(player, enemy, enemyAction, playerAction);
        playerAction.realisation(enemy, player, enemyAction.getType());
    }

    public void checkDebuff() {
        if (!enemy.isDebuffed()) {
            mediator.setDebuffLabel(enemy, false);
        }
        if (enemy.isDebuffed()) {
            mediator.setDebuffLabel(enemy, true);
            enemy.loseDebuffTurn();
        }
        if (!player.isDebuffed()) {
            mediator.setDebuffLabel(player, false);
        }
        if (player.isDebuffed()) {
            mediator.setDebuffLabel(enemy, true);
            player.loseDebuffTurn();
        }

    }

    public void hit(int a, ArrayList<GameResults> gameResults, int locationsNumber, GameCharacter[] enemiesList) {
        Logic action = new Logic();
        Action enemyAction = action.chooseEnemyAction(enemy, new ArrayList<>(actionsList));
        switch (a) {
            case 0 -> {
                playerMove(enemyAction,
                        actionsList.get(1));
                if (enemy.getHealth() > 0) {
                    enemyMove(actionsList.get(1), enemyAction);
                }
            }
            case 1 -> {
                playerMove(enemyAction, actionsList.get(0));
                if (enemy.getHealth() > 0) {
                    enemyMove(actionsList.get(0),
                            enemyAction);
                }
            }
            case 2 -> {
                playerMove(enemyAction, actionsList.get(2));
                if (enemy.getHealth() > 0) {
                    enemyMove(actionsList.get(2),
                            enemyAction);
                }
            }
        }
        mediator.setRoundTexts(player, enemy);
        checkDebuff();
        mediator.setHealthBar(player);
        mediator.setHealthBar(enemy);
        checkDeath(gameResults, locationsNumber, enemiesList);
    }

    public void checkDeath(ArrayList<GameResults> gameResults, int locationsNumber, GameCharacter[] enemiesList) {
        if (player.getHealth() <= 0 & player.getItems()[2].getCount() > 0) {
            player.setHealth((int) (player.getMaxHealth() * 0.05));
            player.getItems()[2].setCount(-1);
            mediator.setHealthBar(player);
            mediator.revive(player, player.getItems());
        }
        if (player.getHealth() <= 0 | enemy.getHealth() <= 0) {
            if (location.getCurrentLocation() == locationsNumber & SHAO_KAHN.equals(enemy.getName())) {
                location.resetLocation(false, 1);
                endFinalRound(gameResults, enemiesList);
            } else {
                endRound(enemiesList);
            }
        }
    }

    public void endRound(GameCharacter[] enemiesList) {
        Logic action = new Logic();
        mediator.makeEndFightDialogVisible();
        if (player.getHealth() > 0) {
            mediator.setRoundEndText("You win");
            if (enemy.getName().equals(SHAO_KAHN)) {
                action.addItems(38, 23, 8, player.getItems());
                action.addPointsBoss(player);
                location.resetLocation(true, player.getLevel());
            } else {
                action.addItems(25, 15, 5, player.getItems());
                action.addPoints(player);
            }
        } else {
            reset(enemiesList);
            mediator.setRoundEndText(enemy.getStringName() + " win");
        }
    }

    public void reset(GameCharacter[] enemiesList) {
        Logic action = new Logic();
        player.setDamage(16);
        player.setHealth(80);
        player.setMaxHealth(80);
        action.resetEnemies(enemiesList);
        player.setLevel(0);
        player.resetPoints();
        player.resetExperience();
        player.setNextExperience(40);
        location.setFullEnemiesList(enemiesList);
        location.resetLocation(false, player.getLevel());
    }

    public void endFinalRound(ArrayList<GameResults> gameResults, GameCharacter[] enemiesList) {
        Logic action = new Logic();
        action.resetEnemies(enemiesList);
        String text = "Победа не на вашей стороне";
        if (player.getHealth() > 0) {
            action.addPoints(player);
            text = "Победа на вашей стороне";
        }
        boolean top = false;
        if (gameResults == null) {
            top = true;
        } else {
            int a = 0;
            for (GameResults results : gameResults) {
                if (player.getPoints() < results.getPoints()) {
                    a++;
                }
            }
            if (a < 10) {
                top = true;
            }
        }
        mediator.gameEnding(text, top);
    }

    public void newRound() {
        mediator.setPlayerMaxHealthBar(player);
        mediator.setEnemyMaxHealthBar(enemy);
        player.setHealth(player.getMaxHealth());
        enemy.setHealth(enemy.getMaxHealth());
        mediator.setHealthBar(player);
        mediator.setHealthBar(enemy);
    }

}
