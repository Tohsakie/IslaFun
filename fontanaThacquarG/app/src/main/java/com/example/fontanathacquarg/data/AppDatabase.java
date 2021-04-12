package com.example.fontanathacquarg.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class,Culture.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
    public abstract CultureDAO cultureDAO();
}