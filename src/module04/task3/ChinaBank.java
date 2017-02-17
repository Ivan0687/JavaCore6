package module04.task3;

import module04.task1.Bank;
import module04.task2.Currency;

/**
 * Created by root on 15.02.2017.
 */
public class ChinaBank extends Bank{

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    /** ChinaBank: лимит снятия = 100, если валюта - USD и 150, если EUR
    *
    * лимит пополнения - 5000, если EUR и 10000, если USD
    *
    * месячная ставка - 1% на USD и 0% на EUR
    *
    * комиссия 3%, если USD и до 1000, 5%, если USD и больше 1000
    * 10%, если EUR и до 1000 и 11%, если EUR и больше 1000 */

    @Override
    public int getLimitOfWithdrawal() {

        int limit = 0;

        switch (getCurrency()){
            case USD:
                limit = 100;
                break;

            case EUR:
                limit = 150;
                break;
        }

        return limit;
    }

    @Override
    public int getLimitOfFunding() {

        int limit = 0;

        switch (getCurrency()){
            case EUR:
                limit = 5000;
                break;
            case USD:
                limit = 10000;
                break;
        }

        return limit;
    }

    @Override
    public int getMonthlyRate() {

        int rate = 0;

        switch (getCurrency()){
            case USD:
                rate = 1;
                break;

            case EUR:
                rate = 0;
                break;
        }

        return rate;
    }

    @Override
    public int getCommission(int summ) {

        int commission = 0;

        switch (getCurrency()){
            case USD:
                if (summ < 1000)
                    commission = 3;
                else
                    commission = 2;

                break;

            case EUR:
                if (summ < 1000)
                    commission = 10;
                else
                    commission = 11;

                break;
        }

        return commission;
    }
}
