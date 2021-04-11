package com.example.fontanathacquarg;
import androidx.*;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Dao;
import java.util.List;

@Dao
public abstract class UserDAO {
    @Query("SELECT * FROM User")
    List<User> getAll() {
        return null;
    }

    @Insert
    void insert(User user) {}

}
