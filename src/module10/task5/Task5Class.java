package module10.task5;

/**
 * Created by root on 13.04.2017.
 */
public class Task5Class {
    public static void someMethod(int i) throws FirstException, SecondException, ThirdException{
        if (i == 1)
            throw new FirstException("First Exception");
        if (i == 2)
            throw  new SecondException("Second exception");
        if (i == 3)
            throw new ThirdException("Third exception");
    }
}
