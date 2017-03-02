package module05.APIs;

import module05.Room;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by root on 25.02.2017.
 */
public class GoogleAPI implements API {

    public Room[] rooms;

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        Room[] foundRooms = new Room[0];
        Room neededRoom = new Room(0, price, persons, null, hotel, city);

        for (Room room : rooms) {
            if (room.equals(neededRoom) && room.getHotelName().equals(hotel))
            foundRooms = addRoomsToArray(foundRooms, room);
        }

        return foundRooms;
    }

    private Room[] addRoomsToArray(Room[] oldRooms, Room room) {
        Room[] newRooms = Arrays.copyOf(oldRooms, oldRooms.length + 1);
        newRooms[newRooms.length - 1] = room;
        return newRooms;
    }


    public GoogleAPI() {
        rooms = new Room[5];

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(i, 100*i+1, i+1, new Date(), "Hotel № " + (i+1), "City № "+ (i+1));
        }
    }
}
