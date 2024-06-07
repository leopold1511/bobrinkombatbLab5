package mortalkombatbversion.Components;

public class Items {
    
    private final String name;
    private int count;
    
    public Items(String n, int c){
        this.name=n;
        this.count=c;
    }

    public void setCount(int c){
        this.count+=c;
    }
    
    public String getName(){
        return this.name;
    }
    public int getCount(){
        return this.count;
    }
}
