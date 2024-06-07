package mortalkombatbversion.Components;

public class GameResults {
    
    private String name;
    private int points;
    
    public GameResults(String n, int p){
        this.name=n;
        this.points=p;
    }

    public String getName(){
        return this.name;
    }
    public int getPoints(){
        return this.points;
    }
    
}
