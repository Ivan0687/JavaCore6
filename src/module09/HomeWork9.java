package module09;

import module07.MainList;
import module07.MainTreeSet;
import module07.Order;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Используйте структуры с HW модуля 7 (User и Order) и выполните задания, используя Java 8 instruments
 * <p>
 * -отсортируйте список за ценой заказа по убыванию
 * -отсортируйте список за ценой заказа по возрастанию и за городом пользователя
 * -отсортируйте список за наименованием товара, идентификатором заказа, и городом пользователя
 * <p>
 * -удалите дублированные данные со списка
 * -удалите объекты, где цена меньше 1500
 * -разделите список на 2 списка - заказы в долларах и в гривнах
 * -разделите список на столько списков, сколько уникальных городов в User
 * <p>
 * -проверьте, содержит ли сет заказ, где фамилия пользователя - “Petrov”
 * -удалите заказы в USD
 * <p>
 * Ограничения:
 * -нельзя использовать итератор
 * -нельзя использовать циклы
 * <p>
 * Определите каждую подзадачу в отдельный метод.
 * Создайте класс Main и протестируйте каждый метод на тестовых данных.
 */
public class HomeWork9<T> {

    public static <T> List<T> createList() {
        return (List<T>) MainList.createArrayList();
    }

    public static <T> Set<T> createSet() {
        return (Set<T>) MainTreeSet.createSet();
    }

    // -отсортируйте список за ценой заказа по убыванию
    public static <T extends Order> Collection<T> sortOrdersByDecreasePrice(Collection<T> collection) {
//        return collection.stream().sorted((o1, o2) -> -Integer.compare(o1.getPrice(), o2.getPrice()))
//                .collect(Collectors.toList());

        return collection.stream()
                .sorted(Comparator.comparingInt(Order::getPrice).reversed())
                .collect(Collectors.toList());

    }

    // -отсортируйте список за ценой заказа по возрастанию и за городом пользователя
    public static <T extends Order> Collection<T> sortByIncreasePriceAndUserCity(Collection<T> collection) {

//        return collection.stream()
//                .sorted((o1, o2) -> {
//                    if (Integer.compare(o1.getPrice(), o2.getPrice()) != 0) {
//                        return Integer.compare(o1.getPrice(), o2.getPrice());
//                    } else
//                        return o1.getUser().getCity().compareTo(o2.getUser().getCity());
//                })
//                .collect(Collectors.toList());

        return collection.stream()
                .sorted(Comparator.comparingInt(Order::getPrice)
                        .thenComparing(order -> order.getUser().getCity()))
                .collect(Collectors.toList());
    }

    // -отсортируйте список за наименованием товара, идентификатором заказа, и городом пользователя
    public static <T extends Order> Collection<T> sortOrdersByNameAndIdentifierAndUsersCity(Collection<T> collection) {
//        return collection.stream().sorted((o1, o2) -> {
//            if (o1.getItemName().compareTo(o2.getItemName()) != 0) {
//                return o1.getItemName().compareTo(o2.getItemName());
//
//            } else if (o1.getShopIdentificator().compareTo(o2.getShopIdentificator()) != 0) {
//                return o1.getShopIdentificator().compareTo(o2.getShopIdentificator());
//
//            } else
//                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
//        }).collect(Collectors.toList());

        return collection.stream()
                .sorted(Comparator.comparing(Order::getItemName)
                        .thenComparing(Order::getShopIdentificator)
                        .thenComparing(Comparator.comparing(o -> o.getUser().getCity())))
                .collect(Collectors.toList());
    }

    // -удалите дублированные данные со списка
    public static <T extends Order> Collection<T> deleteDuplicates(Collection<T> collection) {
        return collection.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //   -удалите объекты, где цена меньше 1500
    public static <T extends Order> List<T> deleteOrdersWithPriceLessThan(List<T> list, int price) {
        return list.stream()
                .filter(order -> order.getPrice() >= price)
                .collect(Collectors.toList());
    }

    //   -разделите список на 2 списка - заказы в долларах и в гривнах
    public static <T extends Order> Map<Order.Currency, List<T>> separateByCurrencies(List<T> list, Order.Currency currency1, Order.Currency currency2) {
        return list.stream()
                .filter(order -> order.getCurrency().equals(currency1) || order.getCurrency().equals(currency2))
//                .filter(((Predicate<T>) order -> order.getCurrency().equals(currency1))
//                        .and(order -> order.getCurrency().equals(currency2)))
                .collect(Collectors.groupingBy(order -> order.getCurrency()));
    }


    //  -разделите список на столько списков, сколько уникальных городов в User
    public static <T extends Order> Map<String, List<T>> separateByUsersCity(List<T> list) {

        return list.stream().collect(Collectors.groupingBy(order -> order.getUser().getCity()));

//        Set<List<T>> set = new HashSet<>();
//        list.forEach(order -> set
//                .add(list.stream()
//                        .filter(order1 -> order1.getUser().getCity().equals(order.getUser().getCity()))
//                        .collect(Collectors.toList())));

//        Map<String, List<T>> map = new HashMap<>();
//        list.forEach(orderKey -> map
//                .putIfAbsent(orderKey.getUser().getCity(),
//                        list.stream()
//                                .filter(orderValue -> orderValue.getUser().getCity().equals(orderKey.getUser().getCity()))
//                                .collect(Collectors.toList())));
//        return map;
    }


    // -проверьте, содержит ли сет заказ, где фамилия пользователя - “Petrov”
    public static <T extends Order> boolean checkIfLastName(Collection<T> collection, String lastName) {
        return collection.stream()
                .anyMatch(order -> order.getUser().getLastName().equals(lastName));
    }


    // -удалите заказы в USD
    public static <T extends Order> Collection<T> deleteOrdersWithCurrency(Collection<T> collection, Order.Currency currency) {
        return collection.stream()
                .filter(order -> !(order.getCurrency() == currency))
                .collect(Collectors.toList());
    }

}
