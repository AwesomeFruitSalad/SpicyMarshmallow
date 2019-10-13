package edu.amrita.cleanupdrive.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Insert
    void addUsers(List<User> user);

    @Insert
    void addLocation(User location);

    @Query("DELETE FROM users")
    void nukeTable();

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT username FROM users")
    List<String> getAllUsernames();

}
