package module07;


import java.util.*;
import java.util.function.Predicate;

/**
 * Created by root on 07.03.2017.
 */
public class MainList {

    public static void main(String[] args) {

        ArrayList<Order> ordersArrayList = createArrayList();

        System.out.println("Initial array: ");
        printCollection(ordersArrayList);

        Collections.sort(ordersArrayList);
        System.out.println("Sorted array using compareTo method:");
        printCollection(ordersArrayList);

        // sort list by Order price in decrease order
        ordersArrayList.sort(Order.comparatorDecreasePrice);
        System.out.println("Array after sorting by Order price in decrease order:");
        printCollection(ordersArrayList);

        // sort list by Order price in increase order AND User city
        ordersArrayList.sort(Order.comparatorIncreasePriceAndUserCity);
        System.out.println("Array after sorting by Order price in increase order AND User city:");
        printCollection(ordersArrayList);

        // sort list by Order itemName AND ShopIdentificator AND User city
        ordersArrayList.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getItemName().compareTo(o2.getItemName()) != 0) {
                    return o1.getItemName().compareTo(o2.getItemName());

                } else if (o1.getShopIdentificator().compareTo(o2.getShopIdentificator()) != 0) {
                    return o1.getShopIdentificator().compareTo(o2.getShopIdentificator());

                } else
                    return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
        });
        System.out.println("Array after sorting by Order itemName AND ShopIdentificator AND User city:");
        printCollection(ordersArrayList);

//        Extra (optional):

//        - delete duplicates from the list
        ArrayList<Order> ordersArrayListWithoutDuplicates = deleteDuplicatesFromList(ordersArrayList);
        System.out.println("Orders without duplicates:");
        printCollection(ordersArrayListWithoutDuplicates);



//        - separate list for two lists - orders in USD and UAH


//        - separate list for as many lists as many unique cities are in User
        Map separatedList = separateListByUsersCities(ordersArrayList);
        printMap(separatedList);

//        - delete items where price less than 1500
        ordersArrayList.removeIf(new Predicate<Order>() {
            @Override
            public boolean test(Order order) {
                return order.getPrice() < 1500;
            }
        });
        // or easier
        // ordersArrayList.removeIf(order -> (order.getPrice() < 1500));
        System.out.println("Orders with prices above 1500");
        printCollection(ordersArrayList);

    }


    public static ArrayList<Order> createArrayList() {
        ArrayList<User> usersArrayList = new ArrayList<>();

        usersArrayList.add(new User("John", "Doe", "New York", 6000));
        usersArrayList.add(new User("Vasia", "Pupkin", "Muhosransk", 1000));
        usersArrayList.add(new User("Ivan", "Soloma", "Poltava", 1500));
        usersArrayList.add(new User("Jackie", "Chan", "Hon Kong", 10000));
        usersArrayList.add(new User("Gordon", "Freeman", "Seattle", 5000));
        usersArrayList.add(new User("Harry", "Potter", "Little Whinging", 100_000));
        usersArrayList.add(new User("Sirius", "Black", "London", 10000));
        usersArrayList.add(new User("Name", "Last Name", "City", 500));
        usersArrayList.add(new User("Ivan", "Ivanow", "Zazhopinsk", 300));
        usersArrayList.add(new User("Petr", "Petrov", "Zazhopinsk", 200));

        ArrayList<Order> ordersArrayList = new ArrayList<>();

        ordersArrayList.add(new Order(1600, Order.Currency.USD, "IPhone 7", "Apple store", usersArrayList.get(0)));
        ordersArrayList.add(new Order(1, Order.Currency.RUB, "Lada kalina", "Na doroge", usersArrayList.get(1)));
        ordersArrayList.add(new Order(50, Order.Currency.UAH, "Samogon", "Kym", usersArrayList.get(2)));
        ordersArrayList.add(new Order(3, Order.Currency.USD, "Hot dog", "Seller", usersArrayList.get(3)));
        ordersArrayList.add(new Order(1, Order.Currency.USD, "Crowbar", "Black Mesa", usersArrayList.get(4)));
        ordersArrayList.add(new Order(100, Order.Currency.EUR, "Wand", "Olivanders Shop", usersArrayList.get(5)));
        ordersArrayList.add(new Order(100, Order.Currency.EUR, "Wand", "Olivanders Shop", usersArrayList.get(6)));
        ordersArrayList.add(new Order(50, Order.Currency.UAH, "Item", "Shop", usersArrayList.get(7)));
        ordersArrayList.add(new Order(50, Order.Currency.RUB, "Vodka", "Larek", usersArrayList.get(9)));
        ordersArrayList.add(new Order(50, Order.Currency.RUB, "Vodka", "Larek", usersArrayList.get(9)));
        return ordersArrayList;
    }

    public static void printCollection(Collection collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
        System.out.println();
    }

    public static void printMap (Map<String, List<Order>> map) {

        for (Map.Entry<String, List<Order>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            printCollection(entry.getValue());
        }
    }

    public static ArrayList<Order> deleteDuplicatesFromList(List<Order> ordersIn) {

        ArrayList<Order> ordersOut = new ArrayList<>(ordersIn);

        if (ordersOut.size() == 1)
            return ordersOut;

        for (int i = 0; i < ordersOut.size() - 1; i++) {
            if (ordersOut.get(i) != null)
            for (int i1 = ordersOut.indexOf(ordersOut.get(i)) + 1; i1 < ordersOut.size(); i1++) {
                if (ordersOut.get(i).equals(ordersOut.get(i1)))
                    ordersOut.set(i1, null);
            }
        }
        while (ordersOut.remove(null)){}

        return ordersOut;
    }

    public static Map separateListByUsersCities(List<Order> ordersList) {

        Map<String, List<Order>> map = new HashMap<>();

        for (Order order : ordersList) {
            map.put(order.getUser().getCity(), refiningListByUsersCity(ordersList, order.getUser().getCity()));
        }


        return map;
    }



    public static ArrayList<Order> refiningListByUsersCity(List<Order> orders, String usersCity) {

        ArrayList<Order> refinedOrders = new ArrayList<>(orders);
        refinedOrders.removeIf(new Predicate<Order>() {
            @Override
            public boolean test(Order order) {
                return !order.getUser().getCity().equals(usersCity);
            }
        });

        return refinedOrders;
    }
}
