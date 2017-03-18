package module05.DAOs;

import module05.Room;

import java.util.ArrayList;

/**
 * Created by root on 02.03.2017.
 */
public class DAOImplHard implements DAO {

    ArrayList<Room> roomDB = new ArrayList<>();

    @Override
    public Room save(Room room) {

        roomDB.add(room);

//        for (int i = 0; i < roomDB.length; i++) {
//            if (roomDB[i] == null) {
//                roomDB[i] = room;
//                break;
//            }
//        }

        return null;
    }

    @Override
    public boolean delete(Room room) {

        roomDB.remove(room);

//        for (int i = 0; i < roomDB.length; i++) {
//            if (room != null)
//                if (room.equals(roomDB[i])) {
//                    System.out.println("Room " + roomDB[i] + " was deleted");
//                    roomDB[i] = null;
//                    return true;
//            }
//        }

        return false;
    }

    @Override
    public Room update(Room room) {

        if (roomDB.contains(room))
            roomDB.set(roomDB.indexOf(room), room);
        System.out.println("Room with id: " + room.getId() + " was updated");

//        for (int i = 0; i < roomDB.length; i++) {
//            if (roomDB[i] != null)
//                if (roomDB[i].getId() == room.getId()){
//                    roomDB[i] = room;
//                    System.out.println("Room with id: " + room.getId() + " was updated");
//            }
//        }

        return null;
    }

    @Override
    public Room findById(long id) {

        for (Room room : roomDB) {
            if (room != null)
                if (room.getId() == id)
                    return room;
            System.out.println("Room with id=" + id + " is: " + room);

        }

        return null;
    }

    @Override
    public ArrayList<Room> getAll() {
        return roomDB;
    }
}
