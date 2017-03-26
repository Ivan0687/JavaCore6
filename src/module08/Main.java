package module08;


/**
 * Created by root on 25.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        Food salo = new Food("Salo", Country.UKRAINE, 30);
        Food kartoha = new Food("Potato", Country.BELARUS, 120);
        Food pasta = new Food("Pasta", Country.ITALY, 360);
        Food rice = new Food("Rice", Country.CHINA, 720);
        Food cheese = new Food("Cheese", Country.FRANCE, 45);
        Food tea = new Food("Tea", Country.UK, 150);
        Food oranges = new Food("Orange", Country.SPAIN, 25);
        Food salmon = new Food("Salmon", Country.NORWAY, 15);

        IManageSystem<Food> foodManageSystem = new IManageSystemFood();

        foodManageSystem.save(salo, 65.6);
        foodManageSystem.save(salmon, 250.52);
        foodManageSystem.save(pasta, 50.3);
        foodManageSystem.save(rice, 30.8);
        foodManageSystem.save(cheese, 150.5);
        foodManageSystem.save(tea, 25.4);
        foodManageSystem.save(oranges);

        System.out.println(foodManageSystem.save(kartoha, 6.6) + " was saved");
        System.out.println();

        foodManageSystem.delete(salmon);

        foodManageSystem.deleteById(tea.getId());

        System.out.println("Food with id " + salo.getId() + " = " + foodManageSystem.get(salo.getId()));
        System.out.println();

        System.out.println("Price of " + pasta + " = " + foodManageSystem.getPrice(pasta));
        System.out.println();

        System.out.println("Products:");
        for (Food food : foodManageSystem.getProducts()) {
            System.out.println(food);
        }
        System.out.println();

        System.out.println("Prices: " + foodManageSystem.getPrices());
        System.out.println();

        foodManageSystem.printProductsSortedByName();
        foodManageSystem.printProductsSortedByPrice();
    }

}
