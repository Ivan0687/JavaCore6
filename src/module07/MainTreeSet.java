package module07;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by root on 09.03.2017.
 */
public class MainTreeSet {

    public static void main(String[] args) {

        TreeSet<Order> ordersTreeSet = createSet();

        System.out.println("Initial tree set:");
        printCollection(ordersTreeSet);

        //check if set contains Order where User’s lastName is - “Petrov”
        String lastNameForCheck = "Petrov";
        System.out.println("Set contains Order where User’s lastName is " + lastNameForCheck + ": " + checkLastName(ordersTreeSet, lastNameForCheck));
        System.out.println();

        //print Order with largest price using only one set method - get

        System.out.println("Order with largest price is ");
        System.out.println(ordersTreeSet.last());
        System.out.println();

        // delete orders where currency is USD using Iterator
        Iterator<Order> orderIterator = ordersTreeSet.iterator();

        while (orderIterator.hasNext()) {
            if (orderIterator.next().getCurrency().equals(Order.Currency.USD))
                orderIterator.remove();
        }

        // here Idea offers me another version:
        // ordersTreeSet.removeIf(order -> order.getCurrency().equals(Order.Currency.USD));
        System.out.println("Set without orders with USD currency:");
        printCollection(ordersTreeSet);

    }

    public static TreeSet<Order> createSet() {
        List<User> usersArrayList = MainList.createUsersList();

        TreeSet<Order> ordersTreeSet = new TreeSet<>();

        ordersTreeSet.add(new Order(600, Order.Currency.USD, "IPhone 7", "Apple store", usersArrayList.get(0)));
        ordersTreeSet.add(new Order(1, Order.Currency.RUB, "Lada kalina", "Na doroge", usersArrayList.get(1)));
        ordersTreeSet.add(new Order(50, Order.Currency.UAH, "Samogon", "Kym", usersArrayList.get(2)));
        ordersTreeSet.add(new Order(3, Order.Currency.USD, "Hot dog", "Seller", usersArrayList.get(3)));
        ordersTreeSet.add(new Order(1, Order.Currency.USD, "Crowbar", "Black Mesa", usersArrayList.get(4)));
        ordersTreeSet.add(new Order(100, Order.Currency.EUR, "Wand", "Olivanders Shop", usersArrayList.get(5)));
        ordersTreeSet.add(new Order(100, Order.Currency.EUR, "Wand", "Olivanders Shop", usersArrayList.get(6)));
        ordersTreeSet.add(new Order(50, Order.Currency.UAH, "Item", "Shop", usersArrayList.get(7)));
        ordersTreeSet.add(new Order(50, Order.Currency.RUB, "Vodka", "Larek", usersArrayList.get(8)));
        ordersTreeSet.add(new Order(50, Order.Currency.RUB, "Vodka", "Larek", usersArrayList.get(9)));
        return ordersTreeSet;
    }

    public static boolean checkLastName(Collection<Order> collection, String lastName) {

        for (Order o : collection) {
            if (o.getUser().getLastName().equals(lastName))
                return true;
        }
        return false;
    }

    public static void printCollection(Collection collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
        System.out.println();
    }

}
