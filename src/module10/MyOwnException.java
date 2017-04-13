package module10;

/**
 * Created by root on 13.04.2017.
 */
public class MyOwnException extends Exception {

    private String message;

    public MyOwnException(String message) {
        super(message);
        this.message = message;
    }

    public void printMassage(){
        System.out.println(message);
    }
}
