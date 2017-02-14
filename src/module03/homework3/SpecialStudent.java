package module03.homework3;

/**
 * Created by root on 13.02.2017.
 */
public class SpecialStudent extends CollegeStudent {

    private long secretKey;
    private String email;

    public SpecialStudent(String firstName, String lastName, int group) {
        super(firstName, lastName, group);
    }

    public SpecialStudent(String lastName, Course[] coursesTaken) {
        super(lastName, coursesTaken);
    }

    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, int age, String collegeName, int rating, long id, long secretKey) {
        super(firstName, lastName, group, coursesTaken, age, collegeName, rating, id);
        this.secretKey = secretKey;
    }

    public SpecialStudent(long secretKey) {
        this.secretKey = secretKey;
    }

    public long getSecretKey() {
        return secretKey;
    }

    public String getEmail() {
        return email;
    }

    public void setSecretKey(long secretKey) {
        this.secretKey = secretKey;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
