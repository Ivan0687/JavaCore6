package module03.homework3;

/**
 * Created by root on 13.02.2017.
 */
public class CollegeStudent extends Student {

    private String collegeName;
    private int rating;
    private long id;

    public CollegeStudent() {
    }

    public CollegeStudent(String firstName, String lastName, int group) {
        super(firstName, lastName, group);

    }

    public CollegeStudent(String lastName, Course[] coursesTaken) {
        super(lastName, coursesTaken);

    }

    public CollegeStudent(String firstName, String lastName, int group, Course[] coursesTaken, int age,  String collegeName, int rating, long id) {
        super(firstName, lastName, group);
        setCoursesTaken(coursesTaken);
        setAge(age);
        this.collegeName = collegeName;
        this.rating = rating;
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public int getRating() {
        return rating;
    }

    public long getId() {
        return id;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(long id) {
        this.id = id;
    }
}
