package module06;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by root on 04.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        User[] users = new User[13];

        users[0] = new User(User.getCount(), "Petia", "Pupkin", 200, 3651);
        users[1] = new User(User.getCount(), "John", "Doe", 250, 6519);
        users[2] = new User(User.getCount(), "Jane", "Roe", 400, 1569);
        users[3] = new User(User.getCount(), "Ivan", "Ivanov", 100, 659);
        users[4] = new User(User.getCount(), "Agent", "Smith", 1, 1000_000);
        users[5] = new User(User.getCount(), "Agent", "Smith", 1, 1000_000);
        users[6] = new User(User.getCount(), "Agent", "Smith", 1, 1000_000);
        users[7] = new User(User.getCount(), "Agent", "Smith", 1, 1000_000);
        users[8] = new User(User.getCount(), "Agent", "Smith", 1, 1000_000);
        users[9] = new User(User.getCount(), "Agent", "Smith", 1, 1000_000);
        users[10] = new User(User.getCount(), "Agent", "Brown", 1, 100_000);
        users[11] = new User(User.getCount(), "Thomas", "Anderson", 1000_000, 1);
        users[12] = new User(User.getCount(), "Agent", "Brown", 1, 100_000);


        System.out.println("Created " + User.getCount() + " users");
        System.out.println();

        /*
        Unique users
         */
        users[0] = null;
        User[] uniqueUsers =  UserUtils.uniqueUsers(users);

        System.out.println("Unique users: ");
        for (User uniqueUser : uniqueUsers) {
            System.out.println(uniqueUser);
        }
        System.out.println();

        /*
        Conditional balance
         */
        User[] usersWithContitionalBalance = UserUtils.usersWithContitionalBalance(users, 1000000);

        System.out.println("Users with balance = " + usersWithContitionalBalance[0].getBalance() + ":");
        for (User user : usersWithContitionalBalance) {
            System.out.println(user);
        }
        System.out.println();

        /*
        Pay salary
         */
        users = UserUtils.paySalaryToUsers(users);

        System.out.println("Users after paying salary:");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();

        /*
        Users id
         */
        long[] idS = UserUtils.getUsersId(users);

        System.out.println("Users ids:" + Arrays.toString(idS));
        System.out.println();


        /*
        Delete users
         */
        users[5] = null;
        users[7] = null;
        users = UserUtils.deleteEmptyUsers(users);

        System.out.println("Users after deleting empty users:");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
    }

}
