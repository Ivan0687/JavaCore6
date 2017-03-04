package module06;

import java.util.Arrays;

/**
 * Created by root on 04.03.2017.
 */
public class UserUtils {

    public UserUtils() {
    }

    public static User[] uniqueUsers(User[] users){

        User[] unique = new User[0];

        for (int i = 0; i < users.length - 1; i++) {

            int count = 0;

            if (users[i] != null) {
                for (int i1 = i; i1 < users.length - 1; i1++) {
                    if (users[i].equals(users[i1 + 1])) {
                        count++;
                        break;
                    }
                }

                if (count == 0)
                    unique = addUsersToArray(unique, users[i]);
            }
        }

        if (users[users.length - 1] != null)
            unique = addUsersToArray(unique, users[users.length - 1]);

        return unique;
    }

    public static User[] usersWithContitionalBalance(User[] users, int balance){

        User[] conditionalUsers = new User[0];

        for (User user : users) {
            if (user != null && user.getBalance() == balance)
                conditionalUsers = addUsersToArray(conditionalUsers, user);
        }

        return conditionalUsers;
    }

    public static final User[] paySalaryToUsers(User[] users){

        for (User user : users) {
            if (user != null)
            user.setBalance(user.getBalance() + user.getSalary());
        }
        return users;
    }

    public static final long[] getUsersId(User[] users){

        long[] idS = new long[users.length];

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
            idS[i] = users[i].getId();
        }

        return idS;
    }

    public static User[] deleteEmptyUsers(User[] users){

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null){
                System.arraycopy(users, i + 1, users, i, users.length - i - 1);
                users = Arrays.copyOfRange(users, 0, users.length - 1);
            }
        }

        return users;
    }

    private static User[] addUsersToArray(User[] oldUsers, User user) {
        User[] newUsers = Arrays.copyOf(oldUsers, oldUsers.length + 1);
        newUsers[newUsers.length - 1] = user;
        return newUsers;
    }

}
