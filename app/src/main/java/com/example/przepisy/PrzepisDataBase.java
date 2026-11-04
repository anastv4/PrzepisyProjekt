package com.example.przepisy;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Przepis.class}, version = 1)

public abstract class PrzepisDataBase extends RoomDatabase {
    public abstract PrzepisDAO zwrocPrzepisDAO();
}
