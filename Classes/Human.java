package Classes;
import java.util.HashMap;
import java.util.Map;

import Enums.Location;
import Enums.ObjectType;
import Enums.determLvl;
import Interfaces.GetLocationInterface;
import Interfaces.ScreamInterface;
import Exeptions.DisturbinThoughtExeption;
import Exeptions.MemoryBlockoutExeption;

public class Human{

    private class Memory {
        Map<ObjectType, String> memory;
        private Memory(){
            memory = new HashMap<ObjectType, String>();
        }
        private void addMemory(ObjectType association, String fact){
            memory.put(association, fact);
        }
        private String getMemory(ObjectType association){
            if (!memory.containsKey(association)){
                throw new MemoryBlockoutExeption(association);
            }
            return memory.get(association);
        }

    }

    private String humanName;
    private Location humanLocation;
    private int moneySpent;
    private Memory memory;

    public Human(String humanName, Location humanLocation){
        this.humanName = humanName;
        this.humanLocation = humanLocation;
        this.moneySpent = 0;
        this.memory = new Memory();
    }
    public void scream(String phrase, determLvl lvl){
        ScreamInterface screamer = new ScreamInterface() {
            @Override
            public void scream(){
                System.out.println(humanName + " is screaming: " + '"' + phrase + '"' + " (" + lvl + ")");
            }
        };
        screamer.scream();
    }
    public void think (Thought thought, determLvl lvl){
        System.out.println(humanName + " is thinking: " + '"' + thought.reason + '"' + " (" + lvl + ")");
    }
    public void laid (ObjectType object1, ObjectType object2, determLvl lvl ){
        System.out.println(humanName + " laid " + object1 + " on the " + object2 + " (" + lvl + ")");
    }
    private void sleep(Thought thought, determLvl lvl) throws DisturbinThoughtExeption{
        if (thought.anxietyLevel >= thought.limitAnxietyLevel){
            throw new DisturbinThoughtExeption(thought);
        }
        else{
            this.think(thought, lvl);
            System.out.println(humanName + "is sleaping (" + lvl + ")");
        }
    }
    // private void sleep(determLvl lvl){
    //     System.out.println(humanName + "is sleaping (" + lvl + ")");
    // }

    public void tryToSleep(Thought thought, determLvl lvl){
        System.out.println(humanName + " try to sleep (" + lvl + ")");
        try{
            this.sleep(thought, lvl);
        }
        catch(DisturbinThoughtExeption e){
            thought.disturb(this, lvl);
        }
    }
    public void remember(ObjectType assotiation){
        System.out.println(humanName + " remembers everything about the " + assotiation +":");
        System.out.println('\t' + this.memory.getMemory(assotiation));
    }
    public void saveMemory (ObjectType assotiation, String fact){
        this.memory.addMemory(assotiation, fact);
    }
    public void buy(Obj obj, determLvl lvl){
        if (lvl == determLvl.ALREADY){ this.moneySpent += obj.getCost(); }
        System.out.println(this.getName() + " buy a new " + obj.getType() + " (" + lvl + ")");
    }

    public void stopTheTrain(determLvl lvl){
         System.out.println(this.getName() + " demands to stop the train (" + lvl + ")");
    }

    public int getMoneySpent(){
        return this.moneySpent;
    }
    public String getName(){
        return this.humanName;
    }

    public Location getLocation(){
        class LocationGetter implements GetLocationInterface {
            final Location location = Human.this.humanLocation;
            @Override 
            public Location getLocation(){
                return this.location;
           } 
        }
        LocationGetter locationGetter = new LocationGetter();
        return locationGetter.getLocation();
    }

    public void Move(Location loc, determLvl lvl){
        System.out.println(this.getName() + " moves to " + loc + " (" + lvl + ")");
    }
    
    public boolean equals(Object obj){
        if (obj==null) {return false;}
        if (obj.getClass() != this.getClass()){ return false; }
        Human human = (Human) obj;
        if (this.hashCode() != human.hashCode()){ return false; }
        return (this.humanLocation == human.getLocation() && this.humanName == human.getName());
    }
    public int hashCode(){
        return this.moneySpent * this.humanName.length();
    }
    public String toString(){
        return "name: " + this.getName() + "; location: " + this.getLocation() + "; spent money: " + this.getMoneySpent();
    }

}
