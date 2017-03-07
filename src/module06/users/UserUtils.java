package module06.users;

import java.util.Arrays;

/**
 * Created by root on 04.03.2017.
 */
public class UserUtils {

    public static User[] uniqueUsers(User[] users) {

        User[] uniqueUsers = new User[0];

        for (User user : users) {
            if (user != null) {
                boolean check = true;

                for (User unique : uniqueUsers) {

                    if (user.equals(unique))
                        check = false;
                }

                if (check)
                    uniqueUsers = addUsersToArray(uniqueUsers, user);
            }
        }
        return uniqueUsers;
    }


    // очень длинный и запутанный код, который добавляет последнего из одинаковых юзеров

//    public static User[] uniqueUsers(User[] users) {
//
//        User[] uniqueUsers = new User[0];
//
//        if (users.length == 1)
//            return users;
//
//        for (int i = 0; i < users.length - 1; i++) {
//
//            int count = 0;
//
//            if (users[i] != null) {
//
//                for (int i1 = i + 1; i1 < users.length; i1++) {
//                    if (users[i].equals(users[i1])) {
//                        count++;
//                        break;
//                    }
//                }
//                if (count == 0)
//                    uniqueUsers = addUsersToArray(uniqueUsers, users[i]);
//            }
//        }
//        if (users[users.length - 1] != null)
//            uniqueUsers = addUsersToArray(uniqueUsers, users[users.length - 1]);
//
//        return uniqueUsers;
//    }

    public static User[] usersWithConditionalBalance(User[] users, int balance) {

        User[] conditionalUsers = new User[0];

        for (User user : users) {
            if (user != null && user.getBalance() == balance)
                conditionalUsers = addUsersToArray(conditionalUsers, user);
        }

        return conditionalUsers;
    }

    public static final User[] paySalaryToUsers(User[] users) {

        for (User user : users) {
            if (user != null)
                user.paySalary();
        }
        return users;
    }

    public static final long[] getUsersId(User[] users) {

        long[] idS = new long[0];

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                idS = Arrays.copyOf(idS, idS.length + 1);
                idS[idS.length - 1] = users[i].getId();
            }
        }

        return idS;
    }

    public static User[] deleteEmptyUsers(User[] users) {

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
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
