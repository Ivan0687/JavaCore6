package module06.citizens;

/**
 * Created by root on 06.03.2017.
 */
public class CitizenMain {

    public static void main(String[] args) {

        Citizen[] citizens = new Citizen[]{CitizenFactory.Englishman(),
                CitizenFactory.Chinese(), CitizenFactory.Russian(), CitizenFactory.Italian()};

        for (Citizen citizen : citizens) {
            citizen.sayHello();
        }

    }

}
