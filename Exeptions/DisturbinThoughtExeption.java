package Exeptions;

import Classes.Thought;

public class DisturbinThoughtExeption extends Exception {
    public DisturbinThoughtExeption(Thought thought){
        super("The thought" + thought.getReason() + "is too disturbing");
    }
}
