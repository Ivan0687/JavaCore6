package module07;


import java.util.Comparator;

/**
 * Created by root on 07.03.2017.
 */
public class Order implements Comparable<Order> {

    private long id;
    private int price;
    private Currency currency;
    private String itemName;
    private String shopIdentificator;
    private User user;
    private static long countOrders;

    enum Currency {EUR, USD, UAH, RUB}


    public Order(int price, Currency currency, String itemName, String shopIdentificator, User user) {
        countOrders++;
        id = countOrders;
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        this.user = user;
    }

    @Override
    public int compareTo(Order orderToCompare) {

        if (price != orderToCompare.getPrice()){
            return Integer.compare(price, orderToCompare.getPrice());
        }

        return Long.compare(id, orderToCompare.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return true;
        if (price != order.price) return false;
        if (currency != order.currency) return false;
        if (!itemName.equals(order.itemName)) return false;
        if (!shopIdentificator.equals(order.shopIdentificator)) return false;
        return user.equals(order.user);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + price;
        result = 31 * result + currency.hashCode();
        result = 31 * result + itemName.hashCode();
        result = 31 * result + shopIdentificator.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    public static Comparator<Order> comparatorDecreasePrice = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return -Integer.compare(o1.getPrice(), o2.getPrice());
        }
    };

    public static Comparator<Order> comparatorIncreasePriceAndUserCity = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            if (Integer.compare(o1.getPrice(), o2.getPrice()) != 0) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            } else
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
        }
    };

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getItemName() {
        return itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public User getUser() {
        return user;
    }

    public static long getCountOrders() {
        return countOrders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", currency=" + currency +
                ", itemName='" + itemName + '\'' +
                ", shopIdentificator='" + shopIdentificator + '\'' +
                ", user=" + user +
                '}';
    }
}
