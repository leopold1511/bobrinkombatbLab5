package mortalkombatbversion.Actions;


import mortalkombatbversion.Components.GameCharacter;

public abstract class Action {
    public abstract String getType();
    public abstract void realisation(GameCharacter gameCharacter, GameCharacter enemy, String enemyActionType);
}
