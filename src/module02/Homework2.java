package module02;

/**
 * Created by root on 28.01.2017.
 */
public class Homework2 {

    public static void main(String[] args) {

        double balance = 0;
        double withdrawal = 0;

        double commision = withdrawal * 0.05;

        if ((withdrawal + commision) > balance)
            System.out.println("NO");

        else {
            balance -= (withdrawal + commision);
            System.out.println("OK " + commision + " " + balance);
        }

    }
}
