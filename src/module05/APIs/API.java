package module05.APIs;

import module05.Room;

import java.util.ArrayList;

/**
 * Created by root on 17.02.2017.
 */
public interface API {

    ArrayList<Room> findRooms(int price, int persons, String city, String hotel);

    ArrayList<Room> getRooms();

}
