package module05;

import module05.APIs.API;
import module05.APIs.BookingComAPI;
import module05.APIs.GoogleAPI;
import module05.APIs.TripAdvisorAPI;
import module05.DAOs.DAO;
import module05.DAOs.DAOImplHard;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by root on 25.02.2017.
 */
public class Controller {

    private ArrayList<API> apis = new ArrayList<API>(Arrays.asList(new BookingComAPI(), new TripAdvisorAPI(), new GoogleAPI()));

    public ArrayList<Room> requstRooms(int price, int persons, String city, String hotel) {

        ArrayList<Room> requstRooms = new ArrayList<>();

        for (API api : apis) {

            ArrayList<Room> foundRooms = api.findRooms(price, persons, city, hotel);

            if (foundRooms.size() > 0) {
                requstRooms = foundRooms;

                boolean checkEquality = false;

                for (Room foundRoom : foundRooms) {
                    for (Room requstRoom : requstRooms) {
                        if (foundRoom != null && foundRoom.equals(requstRoom)) {
                            checkEquality = false;
                        } else {
                            checkEquality = true;
                        }

                    }
                    if (checkEquality)
                        requstRooms.add(foundRoom);
                }
            }
        }

        if (requstRooms.size() == 0)
            System.out.println("Room with price: " + price + ", persons: " + persons + ",city: " + city + ", hotel: " + hotel + " is not found");
        
        return requstRooms;
    }

//        Room[] requstRooms = new Room[0];
//
//        for (int i = 1; i < apis.length; i++) {
//
//            Room[] foundRooms = apis[i].findRooms(price, persons, city, hotel);
//
//            if (foundRooms.length > 0) {
//                requstRooms = foundRooms;
//
//                boolean checkEquality = false;
//
//                for (Room foundRoom : foundRooms) {
//                    for (Room requstRoom : requstRooms) {
//                        if (foundRoom != null && foundRoom.equals(requstRoom)) {
//                            checkEquality = false;
//                        } else {
//                            checkEquality = true;
//                        }
//
//                    }
//                    if (checkEquality)
//                        requstRooms = addRoomsToArray(requstRooms, foundRoom);
//                }
//            }
//        }
//
//        if (requstRooms.length == 0)
//            System.out.println("Room with price: " + price + ", persons: " + persons + ",city: " + city + ", hotel: " + hotel + " is not found");
//
//        return requstRooms;
//    }

//    private Room[] addRoomsToArray(Room[] oldRooms, Room room) {
//        Room[] newRooms = Arrays.copyOf(oldRooms, oldRooms.length + 1);
//        newRooms[newRooms.length - 1] = room;
//        return newRooms;
//    }

    public ArrayList<Room> check(API api1, API api2) {

        ArrayList<Room> checkRooms = new ArrayList<>();

        for (Room api1Room : api1.getRooms()) {
            for (Room api2Room : api2.getRooms()) {
                if (api1Room.equals(api2Room))
                    checkRooms.add(api1Room);
            }
        }
        return checkRooms;
    }
}
