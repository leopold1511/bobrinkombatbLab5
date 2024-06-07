package mortalkombatbversion.Actions;


import mortalkombatbversion.Components.GameCharacter;

public class Debuff extends Action {

    @Override
    public String getType() {
        return "Debuff";
    }

    @Override
    public void realisation(GameCharacter human, GameCharacter enemy, String enemyActionType) {
        switch (enemyActionType) {
            case "Hit", "Debuff", "Heal" -> {
            }
            case "Block" -> {
                if (Math.random()<0.75){
                    enemy.setDebuffTurns(enemy.getLevel());
                }
            }
        }
    }
}
