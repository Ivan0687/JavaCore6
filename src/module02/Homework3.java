package module02;

/**
 * Created by root on 28.01.2017.
 */
public class Homework3 {

    public static void main(String[] args) {

        int[] balances = {1200, 250, 2000, 500, 3200};
        String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

        // на много легче эти два массива обьединить в Hashmap

        String ownerName = "Oww";
        double withdrawal = 490;
        double commision = withdrawal * 0.05;

        for (int i = 0; i < ownerNames.length; i++) {

            if (ownerNames[i].equals(ownerName)){

                if ((withdrawal + commision) > balances[i])
                    System.out.println(ownerName + " NO");

                else {
                    balances[i] -= withdrawal - commision;
                    System.out.println(ownerName + " OK " + commision + " " + balances[i]);
                }

                break;
            }
        }
    }
}
