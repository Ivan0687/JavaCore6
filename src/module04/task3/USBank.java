package module04.task3;

import module04.task1.Bank;
import module04.task2.Currency;

/**
 * Created by root on 15.02.2017.
 */
public class USBank extends Bank{

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    /** USBank: лимит снятия = 1000, если валюта - USD и 1200, если валюта - EUR
    *
    * лимит пополнения - 10000, если EUR, и нет лимита, если USD
    *
    * месячная ставка - 1% на USD и 2% на EUR
    *
    * комиссия 5%, если USD и до 1000, 7%, если USD и больше 1000
    * 6%, если EUR и до 1000 и 8%, если EUR и больше 1000  */

    @Override
    public int getLimitOfWithdrawal() {

        int limit = 0;

        switch (getCurrency()){
            case USD:
                limit = 1000;
                break;

            case EUR:
                limit = 1200;
                break;
        }

        return limit;
    }

    @Override
    public int getLimitOfFunding() {

        int limit = 0;

        switch (getCurrency()){
            case EUR:
                limit = 10000;
                break;
            case USD:
                limit = Integer.MAX_VALUE;
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
                rate = 2;
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
                    commission = 6;
                else
                    commission = 8;

                break;
        }

        return commission;
    }


}
