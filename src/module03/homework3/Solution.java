package module03.homework3;

import java.util.Date;

/**
 * Created by root on 13.02.2017.
 */
public class Solution {

    public static void main(String[] args) {

        Course firstCourse = new Course(new Date("20.01.2017"), "firstCourse");
        Course secondCourse = new Course("secondCourse", 500, "Second");
        Course thirdCourse = new Course(new Date("03.02.2017"), "thirdCourse");
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

        SpecialStudent thirdSpecialStudent = new SpecialStudent("Petrov", "Petr", 3,
                new Course[]{firstCourse, secondCourse, thirdCourse, fourthCourse,  fifthCourse}, 25, "GoIt", 100, 2124791, 95);

        SpecialStudent thirdSpecialStudentSecretKey = new SpecialStudent(456765);
    }

}
