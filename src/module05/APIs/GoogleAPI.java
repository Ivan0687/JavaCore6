package module05.APIs;

import module05.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by root on 25.02.2017.
 */
public class GoogleAPI implements API {

    public ArrayList<Room> rooms;

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    @Override
    public ArrayList<Room> findRooms(int price, int persons, String city, String hotel) {

        ArrayList<Room> foundRooms = new ArrayList<>();
        Room neededRoom = new Room(0, price, persons, null, hotel, city);

        for (Room room : rooms) {
            if (room.equals(neededRoom) && room.getHotelName().equals(hotel))
            foundRooms.add(room);
        }

        return foundRooms;
    }

//    private Room[] addRoomsToArray(Room[] oldRooms, Room room) {
//        Room[] newRooms = Arrays.copyOf(oldRooms, oldRooms.length + 1);
//        newRooms[newRooms.length - 1] = room;
//        return newRooms;
//    }


    public GoogleAPI() {

        for (int i = 0; i < 5; i++) {
            rooms.add(new Room(i, 100*i+1, i+1, new Date(), "Hotel № " + (i+1), "City № "+ (i+1)));
        }
    }
}
