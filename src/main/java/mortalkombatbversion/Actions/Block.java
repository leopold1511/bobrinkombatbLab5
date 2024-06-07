package mortalkombatbversion.Actions;


import mortalkombatbversion.Components.GameCharacter;

public class Block extends Action {

    @Override
    public String getType() {
        return "Block";
    }

    @Override
    public void realisation(GameCharacter human, GameCharacter enemy, String enemyActionType) {
    }
}
