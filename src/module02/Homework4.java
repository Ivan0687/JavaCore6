package module02;

/**
 * Created by root on 28.01.2017.
 */
public class Homework4 {

    public static void main(String[] args) {

        int[] balances = {1200, 250, 2000, 500, 3200};
        String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};



        String ownerName = "Oww";
        double withdrawal = 490;
        // наверное всетаки double fund1


        for (int i = 0; i < ownerNames.length; i++) {

            if (ownerNames[i].equals(ownerName)){

                balances[i] += withdrawal;
                System.out.println(ownerName + " " + balances[i]);

                break;
            }
        }

    }
}
