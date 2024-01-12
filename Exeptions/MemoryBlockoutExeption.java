package Exeptions;

import Enums.ObjectType;

public class MemoryBlockoutExeption extends RuntimeException{
    public MemoryBlockoutExeption(ObjectType association){
        super("Human doesn't remember anything about the " + association);
    }
}
