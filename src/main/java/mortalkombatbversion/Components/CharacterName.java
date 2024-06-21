package mortalkombatbversion.Components;

public enum CharacterName {
    You("You") ,
    BARAKA ("Baraka"),
    LIU_KANG ("Liu-Kang"),
    SONYA_BLADE ("Sonya-Blade"),
    SUB_ZERO ("Sub-Zero"),
    SHAO_KAHN ("Shao-Kahn");

    private String name;

    CharacterName(String name) {
        this.name = name;
    }

    public String getString() {
        return name;
    }
}
