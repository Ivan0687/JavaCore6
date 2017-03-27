package module08;

import java.util.*;

/**
 * Created by root on 25.03.2017.
 */
public class IManageSystemFood<T extends Food> implements IManageSystem<T> {

    private Map<T, Double> database = new HashMap<>();


    @Override
    public T save(T food, double price) {
        database.put(food, price);
        return food;
    }

    @Override
    public T save(T food) {
        database.put(food, null);
        return food;
    }

    @Override
    public void delete(T food) {
        System.out.println(food + " with price = " + database.get(food) + " was deleted");
        database.remove(food);
    }

    @Override
    public void deleteById(int id) {
        System.out.println(get(id) + " with price = " + database.remove(get(id)) + " was deleted");
        System.out.println();
    }

    @Override
    public T get(int id) {
        for (Map.Entry<T, Double> foodDoubleEntry : database.entrySet()) {
            if (id == foodDoubleEntry.getKey().getId())
                return foodDoubleEntry.getKey();
        }
        return null;
    }

    @Override
    public Double getPrice(T food) {
        return database.get(food);
    }

    @Override
    public Set<T> getProducts() {
        return database.keySet();
    }

    @Override
    public List<Double> getPrices() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void printProductsSortedByName() {

        Map<T, Double> databaseByNames = new TreeMap<>(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        databaseByNames.putAll(database);

        System.out.println("Products sorted by foods names:");

        for (Map.Entry<T, Double> foodDoubleEntry : databaseByNames.entrySet()) {
            System.out.println(foodDoubleEntry.getKey() + ": price = " + foodDoubleEntry.getValue());
        }
        System.out.println();
    }

    @Override
    public void printProductsSortedByPrice() {

        List<Map.Entry<T, Double>> nullPrices = new ArrayList();
        List<Map.Entry<T, Double>> notNullPrices = new ArrayList();

        for (Map.Entry<T, Double> tDoubleEntry : database.entrySet()) {
            if (tDoubleEntry.getValue() == null)
                nullPrices.add(tDoubleEntry);
            else
                notNullPrices.add(tDoubleEntry);
        }

        notNullPrices.sort(new Comparator<Map.Entry<T, Double>>() {
            @Override
            public int compare(Map.Entry<T, Double> o1, Map.Entry<T, Double> o2) {
                    return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println("Products sorted by prices:");
        for (Map.Entry<T, Double> nullPrice : nullPrices) {
            System.out.println(nullPrice.getKey() + ": price = " + nullPrice.getValue());
        }
        for (Map.Entry<T, Double> notNullPrice : notNullPrices) {
            System.out.println(notNullPrice.getKey() + ": price = " + notNullPrice.getValue());
        }
        System.out.println();
    }
}
