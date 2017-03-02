package module05.DAOs;

import module05.Room;

/**
 * Created by root on 25.02.2017.
 */
public interface DAO {

    Room save(Room room);
    boolean delete(Room room);
    Room update(Room room);
    Room findById(long id);
}
