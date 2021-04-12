package com.example.fontanathacquarg.data;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Dao;
import java.util.List;

@Dao
public interface CultureDAO {
    @Query("SELECT * FROM culture")
    public List<Culture> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Culture culture);

    @Query("SELECT * FROM culture WHERE id = :id LIMIT 1")
    public Culture findCultureById(int id);


    @Query("DELETE FROM Culture")
    void delete();
}