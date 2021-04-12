package com.example.fontanathacquarg.data;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Dao;
import java.util.List;

@Dao
public interface CultureDAO {
    @Query("SELECT * FROM user")
    public List<Culture> getAll();

    @Insert
    void insert(Culture culture);

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    public Culture findCultureById(int id);
}
