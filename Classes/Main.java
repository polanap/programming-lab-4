package Classes;
import Enums.Location;
import Enums.ObjectType;
import Enums.determLvl;

public class Main {
    public static void makeDecition(Obj obj, Human subj){
        System.out.println(subj.getName() + " is making a decition");
        if (obj.getCost()<=Journey.cost(subj.getLocation(), obj.getLocation())){
            script1(determLvl.ALMOST, subj);
            System.out.println("But he decided that it would cost him more, so");
            script2(determLvl.ALREADY, subj);
        }
        else{
            script2(determLvl.ALMOST, subj);
            System.out.println("But he decided that it would cost him more, so");
            script1(determLvl.ALREADY, subj);
        }
    }

    public static void script1(determLvl lvl, Human subj){
        subj.buy(new WalkingStick(), determLvl.DECIDED);
        subj.laid(ObjectType.HEAD, ObjectType.PILLOW, lvl);
        subj.tryToSleep(new Thought("I will have to spend the money to buy a new cane...", 100), lvl);
    }

    public static void script2(determLvl lvl, Human subj){
        subj.buy(new Ticket(subj, Location.HOLLOW), lvl);
        subj.stopTheTrain(lvl);
    }

    public static void main(String[] args) {
        Human man = new Human("Skuperfild", Location.TRAIN);
        man.saveMemory(ObjectType.WALKING_STICK, "I was holding a cane in my hands when I hit my head with it Zhurilo");
        WalkingStick walkingStick = new WalkingStick();
        walkingStick.setOwner(man);
        walkingStick.setLocation(Location.HOLLOW);

        man.scream("Or maybe she stayed in the hollow?", determLvl.ALMOST);
        makeDecition(walkingStick, man);
        man.remember(ObjectType.WALKING_STICK);
        man.think(new Thought("Then I hit the Zhurilo hard", 0), determLvl.ALREADY);
    }
}

// "А может быть, она осталась в дупле?" – чуть не закричал Скуперфильд.
//  Он уже хотел потребовать, чтоб остановили поезд, так как решил ехать обратно на поиски трости, 
//  но сообразил, что это обойдётся ему намного дороже, чем купить новую трость. 
//  Поэтому он снова положил голову на подушку и попытался заснуть.