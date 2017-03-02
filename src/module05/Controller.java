package module05;

import module05.APIs.API;
import module05.APIs.BookingComAPI;
import module05.APIs.GoogleAPI;
import module05.APIs.TripAdvisorAPI;
import module05.DAOs.DAO;
import module05.DAOs.DAOImplHard;

import java.util.Arrays;

/**
 * Created by root on 25.02.2017.
 */
public class Controller {

    private API apis[] = new API[]{new BookingComAPI(), new TripAdvisorAPI(), new GoogleAPI()};

    public DAO roomDAO = new DAOImplHard();

    public Room[] requstRooms(int price, int persons, String city, String hotel){

        Room[] requstRooms = new Room[0];


        for (int i = 1; i < apis.length; i++) {

            Room[] foundRooms = apis[i].findRooms(price, persons, city, hotel);

            if (foundRooms.length > 0) {
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
                        requstRooms = addRoomsToArray(requstRooms, foundRoom);
                }
            }
        }

        if (requstRooms.length == 0)
            System.out.println("Room with price: " + price + ", persons: " + persons + ",city: " + city + ", hotel: " + hotel + " is not found");

        return requstRooms;
    }

    private Room[] addRoomsToArray(Room[] oldRooms, Room room) {
        Room[] newRooms = Arrays.copyOf(oldRooms, oldRooms.length + 1);
        newRooms[newRooms.length - 1] = room;
        return newRooms;
    }

    public Room[] check(API api1, API api2){

        Room[] api1Rooms = api1.getRooms();
        Room[] api2Rooms = api2.getRooms();
        Room[] checkRooms = new Room[0];

        for (Room api1Room : api1Rooms) {
            for (Room api2Room : api2Rooms) {
                if (api1Room.equals(api2Room))
                    checkRooms = addRoomsToArray(checkRooms, api1Room);
            }
        }
        return checkRooms;
    }


    Room save(Room room){

        roomDAO.save(room);

        return null;
    }

    boolean delete(Room room){

        return roomDAO.delete(room);
    }

    Room update(Room room){
        roomDAO.update(room);
        return null;
    }

    Room findById(long id){

        System.out.println("Room with id=" + id + " is: " + roomDAO.findById(id));

        return roomDAO.findById(id);
    }

}
