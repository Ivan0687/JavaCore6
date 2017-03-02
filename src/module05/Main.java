package module05;

import module05.APIs.BookingComAPI;
import module05.APIs.GoogleAPI;
import module05.APIs.TripAdvisorAPI;
import module05.DAOs.DAO;
import module05.DAOs.DAOImplHard;

/**
 * Created by root on 27.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();


        Room[] rooms0 = controller.requstRooms(401, 5, "City № 5", "Hotel № 5");

        for (Room room : rooms0) {
            System.out.println(room);
        }
        System.out.println();

        Room[] rooms1 = controller.requstRooms(275, 4, "City № 4", "Hotel № 5");

        for (Room room : rooms1) {
            System.out.println(room);
        }
        System.out.println();

        Room[] rooms2 = controller.requstRooms(1000, 4, "City № 4", "Hotel № 4");

        for (Room room : rooms2) {
            System.out.println(room);
        }
        System.out.println();


        Room[] rooms = controller.check(new BookingComAPI(), new TripAdvisorAPI());

        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println();

        rooms = controller.check(new TripAdvisorAPI(), new GoogleAPI());

        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println();

        rooms = controller.check(new GoogleAPI(), new BookingComAPI());

        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println();



        for (Room room : rooms) {
            controller.save(room);
        }

        for (Room room : controller.roomDAO.getAll()) {
            System.out.println(room);
        }
        System.out.println();




        controller.findById(0);
        controller.update(new Room(0, 600, 4, null, "Dnipro", "Kyiv"));
        controller.findById(0);
        controller.delete(rooms[3]);
        controller.findById(2);
        System.out.println();

        for (Room room : controller.roomDAO.getAll()) {
            System.out.println(room);
        }


    }

}
