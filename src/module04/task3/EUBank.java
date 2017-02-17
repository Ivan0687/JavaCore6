package module04.task3;

import module04.task1.Bank;
import module04.task2.Currency;

/**
 * Created by root on 15.02.2017.
 */
public class EUBank extends Bank{

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }


    /** EUBank: лимит снятия = 2000, если валюта - USD и 2200, если EUR
    *
    * лимит пополнения - 20000, если EUR и 10000, если USD
    *
    * месячная ставка - 0% на USD и 1% на EUR
    *
    * комиссия 5%, если USD и до 1000, 7%, если USD и больше 1000
    * 2%, если EUR и до 1000 и 4%, если EUR и больше 1000 */

    @Override
    public int getLimitOfWithdrawal() {

        int limit = 0;

        switch (getCurrency()){
            case USD:
                limit = 2000;
                break;

            case EUR:
                limit = 2200;
                break;
        }

        return limit;
    }

    @Override
    public int getLimitOfFunding() {

        int limit = 0;

        switch (getCurrency()){
            case EUR:
                limit = 20000;
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
                rate = 0;
                break;

            case EUR:
                rate =  1;
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
                    commission = 5;
                else
                    commission = 7;

                break;

            case EUR:
                if (summ < 1000)
                    commission = 2;
                else
                    commission = 4;

                break;
        }

        return commission;
    }
}
