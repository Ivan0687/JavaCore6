package module04.task6;

import module04.task1.Bank;
import module04.task2.Currency;
import module04.task3.ChinaBank;
import module04.task3.EUBank;
import module04.task3.USBank;
import module04.task4.User;
import module04.task5.BankSystemImpl;

/**
 * Created by root on 15.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        Bank USBankUSD = new USBank(1, "USA", Currency.USD, 2654, 2654.45, 62, 100100100);
        Bank USBankEUR = new USBank(2, "USA", Currency.EUR, 1654, 3654.45, 52, 150100100);

        Bank EUBankUSD = new EUBank(3, "UK", Currency.USD, 3657, 3785.62, 40, 200100100);
        Bank EUBankEUR = new EUBank(4, "Belgium", Currency.EUR, 6982, 6214.6, 32, 250100100);

        Bank ChinaBankUSD = new ChinaBank(3, "China", Currency.USD, 12036, 564.32, 632, 50100100);
        Bank ChinaBankEUR = new ChinaBank(4, "China", Currency.EUR, 15360, 589.91, 631, 50100100);


        User userUSBankUSD = new User(1, "USA USD", 265789.63, 6, "Google", 15000, USBankUSD);
        User userUSBankEUR = new User(2, "USA EUR", 189642.45, 8, "Facebook", 16000, USBankEUR);

        User userEUBankUSD = new User(3, "EU USD", 36541.35, 5, "Google", 13000, EUBankUSD);
        User userEUBankEUR = new User(4, "EU EUR", 19642.45, 2, "Facebook", 12000, EUBankEUR);

        User userChinaBankUSD = new User(5, "China USD", 2351.3, 12, "Chau-Chiu", 165, ChinaBankUSD);
        User userChinaBankEUR = new User(6, "China EUR", 268.65, 11, "Fiau-Hou", 149, ChinaBankEUR);


        BankSystemImpl bankSystem = new BankSystemImpl();

        System.out.println("Users before operations:");
        System.out.println(userUSBankUSD.toString());
        System.out.println(userUSBankUSD.toString());
        System.out.println(userEUBankUSD.toString());
        System.out.println(userEUBankEUR.toString());
        System.out.println(userChinaBankUSD.toString());
        System.out.println(userChinaBankEUR.toString());
        System.out.println();


        System.out.println("Operations:");
        System.out.println();

        bankSystem.withdrawOfUser(userUSBankUSD, 500);
        bankSystem.fundUser(userUSBankUSD, 200);
        bankSystem.transferMoney(userUSBankUSD, userEUBankUSD, 100);
        bankSystem.paySalary(userUSBankUSD);
        System.out.println();

        bankSystem.withdrawOfUser(userUSBankEUR, 200);
        bankSystem.fundUser(userUSBankEUR, 100);
        bankSystem.transferMoney(userUSBankEUR, userEUBankEUR, 300);
        bankSystem.paySalary(userUSBankEUR);
        System.out.println();

        bankSystem.withdrawOfUser(userEUBankUSD, 500);
        bankSystem.fundUser(userEUBankUSD, 200);
        bankSystem.transferMoney(userEUBankUSD, userEUBankUSD, 100);
        bankSystem.paySalary(userEUBankUSD);
        System.out.println();

        bankSystem.withdrawOfUser(userEUBankEUR, 200);
        bankSystem.fundUser(userEUBankEUR, 100);
        bankSystem.transferMoney(userEUBankEUR, userEUBankEUR, 300);
        bankSystem.paySalary(userEUBankEUR);
        System.out.println();

        bankSystem.withdrawOfUser(userChinaBankUSD, 500);
        bankSystem.fundUser(userChinaBankUSD, 200);
        bankSystem.transferMoney(userChinaBankUSD, userEUBankUSD, 100);
        bankSystem.paySalary(userChinaBankUSD);
        System.out.println();

        bankSystem.withdrawOfUser(userChinaBankEUR, 200);
        bankSystem.fundUser(userChinaBankEUR, 11100);
        bankSystem.transferMoney(userChinaBankEUR, userChinaBankEUR, 300);
        bankSystem.paySalary(userChinaBankEUR);
        System.out.println();


        System.out.println("Users after operations:");
        System.out.println(userUSBankUSD.toString());
        System.out.println(userUSBankUSD.toString());
        System.out.println(userEUBankUSD.toString());
        System.out.println(userEUBankEUR.toString());
        System.out.println(userChinaBankUSD.toString());
        System.out.println(userChinaBankEUR.toString());

    }

}
