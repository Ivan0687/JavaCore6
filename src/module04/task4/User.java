package module04.task4;

import module04.task1.Bank;

/**
 * Created by root on 15.02.2017.
 */
public class User {

    private long id;
    private String name;
    private double balance;
    private int monthsOfEmployment;
    private  String companyName;
    private int salary;
    private Bank bank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
    }

    public void setMonthsOfEmployment(int monthsOfEmployment) {
        this.monthsOfEmployment = monthsOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public User(long id, String name, double balance, int monthsOfEmployment, String companyName, int salary, Bank bank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "User{" +
                "id= " + id +
                ", name='" + name + '\'' +
                ", balance= " + balance +
                ", monthsOfEmployment= " + monthsOfEmployment +
                ", companyName='" + companyName + '\'' +
                ", salary= " + salary +
                ", bank=" + bank.getBankCountry() +
                '}';
    }


}
