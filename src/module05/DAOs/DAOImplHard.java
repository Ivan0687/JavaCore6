package module05.DAOs;

import module05.Room;

/**
 * Created by root on 02.03.2017.
 */
public class DAOImplHard implements DAO{

    Room[] roomDB = new Room[10];

    @Override
    public Room save(Room room) {

        for (int i = 0; i < roomDB.length; i++) {
            if (roomDB[i] == null) {
                roomDB[i] = room;
                break;
            }
        }

        return null;
    }

    @Override
    public boolean delete(Room room) {

        for (int i = 0; i < roomDB.length; i++) {
            if (room != null)
                if (room.equals(roomDB[i])) {
                    System.out.println("Room " + roomDB[i] + " was deleted");
                    roomDB[i] = null;
                    return true;
            }
        }

        return false;
    }

    @Override
    public Room update(Room room) {

        for (int i = 0; i < roomDB.length; i++) {
            if (roomDB[i] != null)
                if (roomDB[i].getId() == room.getId()){
                    roomDB[i] = room;
                    System.out.println("Room with id: " + room.getId() + " was updated");
            }
        }

        return null;
    }

    @Override
    public Room findById(long id) {

        for (Room room : roomDB) {
            if (room != null)
            if (room.getId() == id)
                return room;
        }

        return null;
    }

    @Override
    public Room[] getAll() {
        return roomDB;
    }
}
