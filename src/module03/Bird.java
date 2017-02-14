package module03;

/**
 * Created by root on 29.01.2017.
 */
public class Bird {

    public static void sing (String[] lyrics){

        for (String lyric : lyrics) {

            System.out.println(lyric);

        }
    }

    public static void main(String[] args) {

        String[] song = new String[]{"I am walking", "I am flying", "I am singing", "I am Bird"};

        Bird.sing(song);

    }
}
