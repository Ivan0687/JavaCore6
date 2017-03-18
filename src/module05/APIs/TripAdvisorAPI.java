package module05.APIs;

import module05.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by root on 25.02.2017.
 */
public class TripAdvisorAPI implements API {

    private ArrayList<Room> rooms;

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    @Override
    public ArrayList<Room> findRooms(int price, int persons, String city, String hotel) {

        ArrayList<Room> foundRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (city.equals(room.getCityName()))
                if (room.getPrice() < price * 1.5)
                    if (room.getPrice() > price / 1.5)
                        if (room.getPersons() + 1 <= persons)
                            if (room.getPersons() - 1 >= persons)
                                foundRooms.add(room);
        }

//        Room[] foundRooms = new Room[0];
//
//        for (int i = 0; i < rooms.length; i++) {
//            if (city.equals(rooms[i].getCityName())){
//
//                if (rooms[i].getPrice() < price * 1.5 ){
//                    if (rooms[i].getPrice() > price / 1.5)
//                    foundRooms = addRoomsToArray(foundRooms, rooms[i]);
//                }
//
//                if (rooms[i].getPersons() + 1 <= persons){
//                    if (rooms[i].getPersons() - 1 >= persons)
//                    foundRooms = addRoomsToArray(foundRooms, rooms[i]);
//                }
//            }
//        }

        return foundRooms;
    }

//    private Room[] addRoomsToArray(Room[] oldRooms, Room room) {
//        Room[] newRooms = Arrays.copyOf(oldRooms, oldRooms.length + 1);
//        newRooms[newRooms.length - 1] = room;
//        return newRooms;
//    }


    public TripAdvisorAPI() {
        for (int i = 0; i < 5; i++) {
            rooms.add(new Room(i, 100 * i + 1, i + 1, new Date(), "Hotel № " + (i + 1), "City № " + (i + 1)));
        }
    }
}
