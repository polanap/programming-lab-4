package Classes;

import Enums.determLvl;

public class Thought {
    String reason;
    int anxietyLevel;
    final int limitAnxietyLevel = 10;
    public Thought(String reason, int anxietyLevel){
        this.reason = reason;
        this.anxietyLevel = anxietyLevel;
    }
    public void disturb(Human human, determLvl lvl){
        System.out.println("The thought of \"" + reason + "\" bothers " + human.getName() + " (" + lvl + ")");
    }
    public int getAnxietyLevel() {
        return anxietyLevel;
    }
    public String getReason() {
        return reason;
    }
}
