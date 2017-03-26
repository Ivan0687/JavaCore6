package module08;

import java.util.*;

/**
 * Created by root on 25.03.2017.
 */
public class IManageSystemFood <T extends Food> implements IManageSystem<T> {

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

        List<Map.Entry<T, Double>> databaseByPrices = new ArrayList<>();

        databaseByPrices.addAll(database.entrySet());

        databaseByPrices.sort(new Comparator<Map.Entry<T, Double>>() {
            @Override
            public int compare(Map.Entry<T, Double> o1, Map.Entry<T, Double> o2) {
                if (o1.getValue() != null)
                return o1.getValue().compareTo(o2.getValue());
                return -1;
            }
        });

        System.out.println("Products sorted by prices:");
        for (Map.Entry<T, Double> databaseByPrice : databaseByPrices) {
            System.out.println(databaseByPrice.getKey() + ": price = " + databaseByPrice.getValue());
        }
        System.out.println();
    }
}
