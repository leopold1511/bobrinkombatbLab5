package mortalkombatbversion.Actions;


import mortalkombatbversion.Components.GameCharacter;

public class Heal extends Action {

    @Override
    public String getType() {
        return "Heal";
    }

    @Override
    public void realisation(GameCharacter human, GameCharacter enemy, String enemyActionType) {
        switch (enemyActionType) {
            case "Hit", "Heal", "Debuff" -> {
            }
            case "Block" -> {
                human.addHealth((human.getMaxHealth() - human.getHealth()) / 2);
            }
        }
    }
}
