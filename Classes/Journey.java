package Classes;
import Enums.Location;

public class Journey {
    Location startPoint;
    Location endPoint;
    private final static int pricePerKilometer = 10;

    public Journey(Location loc1, Location loc2){
        this.setStartPoint(loc1);
        this.setEndPoint(loc2);
    }
    public void setStartPoint(Location startPoint){ this.startPoint = startPoint;}
    public void setEndPoint(Location end_point){ this.endPoint = end_point;}
    public static int cost(Location A, Location B){
        return Location.distance(A, B)*pricePerKilometer;
    }

    public boolean equals(Object obj){
        if (obj==null) {return false;}
        if (obj.getClass() != this.getClass()){ return false; }
        Journey journey = (Journey) obj;
        if (this.hashCode() != journey.hashCode()){ return false; }
        return (this.startPoint == journey.startPoint && this.endPoint == journey.endPoint);
    }
    public int hashCode(){
        return Location.distance(this.startPoint, this.endPoint);
    }
    public String toString(){
        return "start point: " + this.startPoint.toString() + "; end point: " + this.endPoint.toString();
    }

}
