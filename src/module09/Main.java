package module09;

import module07.Order;

import java.util.List;
import java.util.Set;

/**
 * Created by root on 01.04.2017.
 */
public class Main {

    public static void main(String[] args) {

        List<Order> ordersList = HomeWork9.createList();
        Set<Order> orderSet = HomeWork9.createSet();


        ordersList.forEach(System.out::println);
        System.out.println();


        System.out.println("Sort by decrease order prices");
        HomeWork9.sortOrdersByDecreasePrice(ordersList).forEach(System.out::println);
        System.out.println();


        System.out.println("Sort by increase order price and city");
        HomeWork9.sortByIncreasePriceAndUserCity(ordersList).forEach(System.out::println);
        System.out.println();


        System.out.println("отсортируйте список за наименованием товара, идентификатором заказа, и городом пользователя");
        HomeWork9.sortOrdersByNameAndIdentifierAndUsersCity(ordersList).forEach(System.out::println);
        System.out.println();


        System.out.println("удалите дублированные данные со списка");
        HomeWork9.deleteDuplicates(ordersList).forEach(System.out::println);
        System.out.println();


        System.out.println("-удалите объекты, где цена меньше 1500");
        int priceToCompare = 1500;
        HomeWork9.deleteOrdersWithPriceLessThan(ordersList, priceToCompare).forEach(System.out::println);
        System.out.println();


        System.out.println("-разделите список на 2 списка - заказы в долларах и в гривнах");
        HomeWork9.separateByCurrencies(ordersList, Order.Currency.UAH, Order.Currency.USD).forEach((currency, list) -> {
            System.out.println("Orders in " + currency);
            list.forEach(System.out::println);
            System.out.println();
        });


        System.out.println("-разделите список на столько списков, сколько уникальных городов в User");
        HomeWork9.separateByUsersCity(ordersList).forEach((city, list) -> {
            System.out.println(city);
            list.forEach(System.out::println);
            System.out.println();
        });


        System.out.println("-проверьте, содержит ли сет заказ, где фамилия пользователя - “Petrov”");
        String lastNameToCheck = "Petrov";
        System.out.println("User with last name" + lastNameToCheck + " is present? :" + (HomeWork9.checkIfLastName(orderSet, lastNameToCheck) ? "Yes" : "No"));
        System.out.println();


        System.out.println("-удалите заказы в USD");
        Order.Currency currencyToDelete = Order.Currency.USD;
        HomeWork9.deleteOrdersWithCurrency(orderSet, currencyToDelete).forEach(System.out::println);
        System.out.println();

    }

}
