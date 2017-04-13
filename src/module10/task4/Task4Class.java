package module10.task4;

import module10.MyOwnException;

/**
 * Created by root on 13.04.2017.
 */
public class Task4Class {

    public static void f() throws MyOwnException2 {
        try {
            g();
        } catch (MyOwnException e) {
            System.out.println(e.getMessage());
            throw new MyOwnException2("Exception in method f()");
        }
    }

    public static void g() throws MyOwnException {
        throw new MyOwnException("Exception in method g()");
    }
}
