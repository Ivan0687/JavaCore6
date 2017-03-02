package module05.DAOs;

import module05.Room;

/**
 * Created by root on 25.02.2017.
 */
public class RoomDAO implements DAO {

    @Override
    public Room save(Room room) {

        System.out.println(room.toString() + " was saved");

        return room;
    }

    @Override
    public boolean delete(Room room) {

        System.out.println(room.toString() + "was deleted");

        return true;
    }

    @Override
    public Room update(Room room) {

        System.out.println(room.toString() + " was updated");

        return room;
    }

    @Override
    public Room findById(long id) {

        System.out.println("Room with id=" + id + " is: ");

        return null;
    }
}
