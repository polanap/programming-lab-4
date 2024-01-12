package Enums;
import java.lang.Math;

import Interfaces.LocationInterface;
public enum Location implements LocationInterface {
    HOLLOW{
        @Override
        public int loc(){ return 0;}
    },
    TRAIN{
        @Override
        public int loc(){ return 1;}
    },
    STORE{
        @Override
        public int loc(){ return 2;}
    };
    public static int distance(Location A, Location B){
        return Math.abs(A.loc() - B.loc());
    }

}
