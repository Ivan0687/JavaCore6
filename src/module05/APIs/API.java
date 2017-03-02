package module05.APIs;

import module05.Room;

/**
 * Created by root on 17.02.2017.
 */
public interface API {

    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getRooms();

}
