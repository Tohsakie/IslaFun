package com.example.fontanathacquarg;
import androidx.*;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Dao;
import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    public List<User> getAll();

    @Insert
    void insert(User user);

    @Query("SELECT id, nom, prenom FROM user WHERE id = :userId LIMIT 1")
    public User findUserById(int userId);
}
