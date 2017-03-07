package module06.users;

/**
 * Created by root on 04.03.2017.
 */
public final class User {

    private long id;
    private String firstName;
    private String lastName;
    private int salary;
    private int balance;

    private static long count;

    public User(long id, String firstName, String lastName, int salary, int balance) {

//    можно id вообще убрать из конструктора и делать так
//        count++;
//        id = count;

//    но так как в задании все поля нужны то делаем так
        count++;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.balance = balance;
    }

    public static long getCount() {
        return count;
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

    public int getSalary() {
        return salary;
    }

    public void paySalary() {
        balance+= salary;
    }

    public int getBalance() {
        return balance;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        // У меня у каждого юзера свой уникальный айДи, так что проверка на id не имеет смысла.
        //if (id != user.id) return false;

        if (salary != user.salary) return false;
        if (balance != user.balance) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        return lastName != null ? lastName.equals(user.lastName) : user.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + balance;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", balance=" + balance +
                '}';
    }
}
