package module10;

import module10.task4.MyOwnException2;
import module10.task5.FirstException;
import module10.task5.SecondException;
import module10.task5.Task5Class;
import module10.task5.ThirdException;
import module10.task4.Task4Class;

/**
 * Created by root on 13.04.2017.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1");
        try{
            throw new Exception("Argument type String in constructor");
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block has been called");
        }
        System.out.println();

        System.out.println("Task 2");
        try{
            throw new MyOwnException("My own exception's massage");
        } catch (MyOwnException e){
            e.printMassage();
        }
        System.out.println();

        System.out.println("Task 3");
        String task3 = null;
        try {
            System.out.println(task3.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException was caught");
        }
        System.out.println();

        System.out.println("Task 4");
        try {
            Task4Class.f();
        } catch (MyOwnException2 e) {

        }
        System.out.println();

        System.out.println("Task 5");
        try{
            Task5Class.someMethod(1);
            Task5Class.someMethod(2);
            Task5Class.someMethod(3);
        } catch ( FirstException | SecondException| ThirdException e){
            e.getMessage();
        }
    }
}
