package Classes;
import Enums.Location;
import Enums.ObjectType;

public class WalkingStick extends Obj {
    private final int standardPrice = 100;
    public WalkingStick(){
        this.setType (ObjectType.WALKING_STICK);
        this.setCost(standardPrice);
        this.setLocation(Location.STORE);
    }
}
