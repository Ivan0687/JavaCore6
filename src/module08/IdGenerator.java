package module08;


/**
 * Created by root on 25.03.2017.
 */
public abstract class IdGenerator {

    private static int id;

    public static int getId() {
        id++;
        return id;
    }
}
