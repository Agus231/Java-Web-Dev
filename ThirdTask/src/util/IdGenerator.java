package util;

public class IdGenerator {
    private static final int ID_TOP_BOUND = 1_000_000;
    private static final int ID_LOW_BOUND = 1;

    private static int id = 1;

    public static int getId(){
        if (id == ID_TOP_BOUND){
            id = ID_LOW_BOUND;
        }

        return id++;
    }
}