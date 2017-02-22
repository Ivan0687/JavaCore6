package module04.task5;

import module04.task4.User;


public class BankSystemImpl implements BankSystem{


    @Override
    public void withdrawOfUser(User user, int amount) {

        System.out.println("User " + user.getName() + " is trying to withdraw " + amount + " " + user.getBank().getCurrency());

        if (user.getBalance() < (double) amount + amount * user.getBank().getCommission(amount) / 100) {
            System.out.println("User " + user.getName() + " don't have enough money. Available amount = " +
                    user.getBalance() / (1 + user.getBank().getCommission(amount) / 100) +" "+ user.getBank().getCurrency());

        } else if (amount < 0) {
            System.out.println("User " + user.getName() + " is trying to withdraw negative amount");

        } else if (amount > user.getBank().getLimitOfWithdrawal()) {
            System.out.println("User " + user.getName() + " has exceeded the limit of withdrawal, limit = " + user.getBank().getLimitOfWithdrawal());

        } else {
            // вывод баланса можно было бы сделать методом у юзера например как user.showBalance
            System.out.println("User " + user.getName() + ": balance = " + user.getBalance() + " " + user.getBank().getCurrency());

            System.out.println("User " + user.getName() + " withdraws " + amount + " " + user.getBank().getCurrency() +
                    " with commission " + (double)amount * user.getBank().getCommission(amount) / 100 + " " + user.getBank().getCurrency());

            user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount) / 100);

            System.out.println("User " + user.getName() + ": balance = " + user.getBalance() + user.getBank().getCurrency());

//          комиссия уходит банку
            user.getBank().setTotalCapital(user.getBank().getTotalCapital() + amount * user.getBank().getCommission(amount) / 100);
        }

        System.out.println();

    }

    @Override
    public void fundUser(User user, int amount) {

        System.out.println("User " + user.getName() + " is trying to fund " + amount + " " + user.getBank().getCurrency());
        if (amount >=0) {
            if (amount < user.getBank().getLimitOfFunding()) {
                System.out.println("User " + user.getName() + ": balance = " + user.getBalance() +" "+ user.getBank().getCurrency());

                System.out.println("User " + user.getName() +  " funds " + amount +" "+ user.getBank().getCurrency());

                user.setBalance(user.getBalance() + amount);

                System.out.println("User " + user.getName() + ": balance = " + user.getBalance() +" "+ user.getBank().getCurrency());

            } else {
                System.out.println("User " + user.getName() + " has exceeded limit of funding, limit = " + user.getBank().getLimitOfFunding());
            }
        } else{
            System.out.println("User " + user.getName() + " is trying to fund negative amount");
        }
        System.out.println();

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        /** Здесь можно было бы еще устроить механику перевода с разными валютами пользователей,
         * но для этого я бы сделал еще один класс с курсами валют
         **/

        System.out.println("User " + fromUser.getName() + " is trying to transfer " +
                amount + " " + fromUser.getBank().getCurrency() + " to user " + toUser.getName());

        if (fromUser.getBalance() < (double) amount + amount * fromUser.getBank().getCommission(amount)/100){
            System.out.println("User " + fromUser.getName() + " haven't enough money. Available amount = " +
                    fromUser.getBalance() / (1 + fromUser.getBank().getCommission(amount)/100) +" "+ fromUser.getBank().getCurrency());

        } else if (amount < 0){
            System.out.println("User " + fromUser.getName() + " is trying to transfer negative amount to " + toUser.getName());

        } else if (amount > fromUser.getBank().getLimitOfWithdrawal()){
            System.out.println("User " + fromUser.getName() + " has exceeded the limit of withdrawal, limit = " + fromUser.getBank().getLimitOfWithdrawal());

        } else if (amount > toUser.getBank().getLimitOfFunding()){
            System.out.println("User " + toUser.getName() + " has exceeded limit of funding, limit = " + toUser.getBank().getLimitOfFunding());

        } else{

            System.out.println("User " + fromUser.getName() + ": balance = " + fromUser.getBalance() + " " + fromUser.getBank().getCurrency());
            System.out.println("User " + toUser.getName() + ": balance = " + toUser.getBalance() + " " + toUser.getBank().getCurrency());

            System.out.println("User " + fromUser.getName() + " transfers " + amount + " " + fromUser.getBank().getCurrency() + " to " + toUser.getName() +
                    " with commission " + (double)amount * fromUser.getBank().getCommission(amount) / 100 + " " + fromUser.getBank().getCurrency());

            fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount) / 100);
            toUser.setBalance(toUser.getBalance() + amount);

            System.out.println("User " + fromUser.getName() + ": balance = " + fromUser.getBalance() + " " + fromUser.getBank().getCurrency());
            System.out.println("User " + toUser.getName() + ": balance = " + toUser.getBalance() + " " + toUser.getBank().getCurrency());

            fromUser.getBank().setTotalCapital(fromUser.getBank().getTotalCapital() + amount * fromUser.getBank().getCommission(amount) / 100);
        }

        System.out.println();
    }

    @Override
    public void paySalary(User user) {

        System.out.println("User " + user.getName() + ": balance = " + user.getBalance() +" "+ user.getBank().getCurrency());
        System.out.println("Paying " + user.getSalary() + " " + user.getBank().getCurrency() + " of salary to user " + user.getName());
        user.setBalance(user.getBalance() + user.getSalary());
        System.out.println("User " + user.getName() + ": balance = " + user.getBalance() +" "+ user.getBank().getCurrency());
        System.out.println();
    }
}
