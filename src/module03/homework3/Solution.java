package module03.homework3;

import java.util.Date;

/**
 * Created by root on 13.02.2017.
 */
public class Solution {

    public static void main(String[] args) {

        Course firstCourse = new Course(new Date(2017, 02, 20), "firstCourse");
        Course secondCourse = new Course("secondCourse", 500, "Second");
        Course thirdCourse = new Course(new Date(2016, 12, 24), "thirdCourse");
        Course fourthCourse = new Course("fourthCourse", 400, "Fourth");
        Course fifthCourse = new Course("fifthCourse", 600, "Fifth");

        Student firstStudent = new Student("Vasia", "Pupkin", 1);
        Student secondStudent = new Student("Pupkina", new Course[]{firstCourse, secondCourse, fourthCourse});

        CollegeStudent firstCollegeStudent = new CollegeStudent("John", "Doe", 2);
        CollegeStudent secondCollegeStudent = new CollegeStudent("Roe", new Course[]{thirdCourse, fifthCourse});

        CollegeStudent thirdCollegeStudent = new CollegeStudent("Ivanov", "Ivan", 2,
                new Course[]{firstCourse, fifthCourse}, 25, "GoIt", 10, 65446564);

        SpecialStudent firstSpecialStudent = new SpecialStudent("John", "Doe", 3);
        SpecialStudent secondSpecialStudent = new SpecialStudent("Roe", new Course[]{thirdCourse, fifthCourse});
        SpecialStudent thirdSpecialStudent = new SpecialStudent("John", "Doe", 3, 561684);

    }

}
