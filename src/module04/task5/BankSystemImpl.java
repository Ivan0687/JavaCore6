package module04.task5;

import module04.task4.User;

/**
 * Created by root on 15.02.2017.
 */
public class BankSystemImpl implements BankSystem{


    @Override
    public void withdrawOfUser(User user, int amount) {

        if (amount < user.getBank().getLimitOfWithdrawal()){
            user.setBalance(user.getBalance() - amount - user.getBank().getCommission(amount));
            user.getBank().setTotalCapital(user.getBank().getTotalCapital() + user.getBank().getCommission(amount));
        } else {
            System.out.println("Exceeded limit of withdrawal");
        }
    }

    @Override
    public void fundUser(User user, int amount) {

        if (amount <  user.getBank().getLimitOfFunding()){
            user.setBalance(user.getBalance() + amount);
        } else {
            System.out.println("Exceeded limit of funding");
        }

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (amount < fromUser.getBank().getLimitOfWithdrawal()){
            if (amount <  toUser.getBank().getLimitOfFunding()){
                fromUser.setBalance(fromUser.getBalance() - amount - fromUser.getBank().getCommission(amount));
                toUser.setBalance(toUser.getBalance() + amount);
                fromUser.getBank().setTotalCapital(fromUser.getBank().getTotalCapital() + fromUser.getBank().getCommission(amount));
            } else {
                System.out.println("Exceeded limit of funding");
            }
        } else {
            System.out.println("Exceeded limit of withdrawal");
        }

    }

    @Override
    public void paySalary(User user) {

        user.setBalance(user.getBalance() + user.getSalary());
    }
}
