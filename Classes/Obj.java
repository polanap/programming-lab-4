package Classes;
import Enums.Location;
import Enums.ObjectType;
import Interfaces.GetLocationInterface;

public abstract class Obj implements GetLocationInterface{
    private int cost;
    private Human owner;
    private Location location;
    private ObjectType type;
    
    protected void setType(ObjectType type){ this.type = type; }
    public void setOwner(Human owner){ this.owner = owner; }
    public void setCost(int cost){ this.cost = cost; }
    
    public void setLocation(Location location){ this.location = location; }
    public Human getOwner() { return this.owner; }
    public int getCost(){ return this.cost;}
    @Override
    public Location getLocation(){ return this.location;}
    public ObjectType getType(){ return this.type; }

    public boolean equals(Object obj){
        if (obj==null) {return false;}
        if (obj.getClass() != this.getClass()){ return false; }
        Obj obj2 = (Obj) obj;
        if (this.hashCode() != obj2.hashCode()){ return false; }
        return (this.type == obj2.getType() && this.cost == obj2.getCost());
    }
    public int hashCode(){
        return this.cost % 27;
    }
    public String toString(){
        return "type: " + this.getType() + "; location: " + this.getLocation()
         + "; cost: " + this.getCost();
    }
}
