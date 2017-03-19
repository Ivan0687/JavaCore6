package module07;

/**
 * Created by root on 07.03.2017.
 */
public class User implements Comparable<User> {

    private long id;
    private String firstName;
    private String lastName;
    private String city;
    private int balance;
    private static long countUsers;


    public User(String firstName, String lastName, String city, int balance) {
        countUsers++;
        id = countUsers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.balance = balance;
    }

    @Override
    public int compareTo(User userToCompare) {

        if (balance != userToCompare.getBalance()){
            return Integer.compare(balance, userToCompare.getBalance());

        } else if (!firstName.equals(userToCompare.getFirstName())){
            return firstName.compareTo(userToCompare.getFirstName());

        } else if (!lastName.equals(userToCompare.getLastName())){
            return lastName.compareTo(userToCompare.getLastName());

        } else if (!city.equals(userToCompare.getCity())){
            return city.compareTo(userToCompare.getCity());
        }

        return Long.compare(id, userToCompare.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return true;
        if (balance != user.balance) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        return city.equals(user.city);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + balance;
        return result;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getBalance() {
        return balance;
    }

    public static long getCountUsers() {
        return countUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", balance=" + balance +
                '}';
    }


}
