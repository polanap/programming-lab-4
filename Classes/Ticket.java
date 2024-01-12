package Classes;
import Enums.Location;
import Enums.ObjectType;

public class Ticket extends Obj {
    public Ticket(Human human, Location endPoint){
        this.setType(ObjectType.TICKET);
        this.setCost(Journey.cost(human.getLocation(), endPoint));
        this.setLocation(Location.STORE);
        this.setOwner(human);
    }
}