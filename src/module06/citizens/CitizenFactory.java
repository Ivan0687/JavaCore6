package module06.citizens;

/**
 * Created by root on 06.03.2017.
 */
public class CitizenFactory {

    private static class Englishman implements Citizen {
        @Override
        public void sayHello() {
            System.out.println("Hello");
        }
    }

    private static class Chinese implements Citizen {
        @Override
        public void sayHello() {
            System.out.println("你好");
        }
    }

    private static class Russian implements Citizen {
        @Override
        public void sayHello() {
            System.out.println("Привет");
        }
    }

    private static class Italian implements Citizen {
        @Override
        public void sayHello() {
            System.out.println("Ciao!");
        }
    }

    public static Citizen Englishman() {
        return new Englishman();
    }

    public static Citizen Chinese() {
        return new Chinese();
    }

    public static Citizen Russian() {
        return new Russian();
    }

    public static Citizen Italian() {
        return new Italian();
    }

}
