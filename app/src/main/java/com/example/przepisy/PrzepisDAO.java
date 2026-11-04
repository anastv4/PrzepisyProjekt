package com.example.przepisy;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PrzepisDAO {
    @Insert
    public void wstawDoBazy(Przepis przepis);

    @Insert
    public void wstawWiecejPrzepisow(Przepis ... przepiss);

    @Delete
    public void  usunZBazy(Przepis przepis);

    @Update
    public void aktualizuj(Przepis przepis);

    @Query("SELECT * FROM przepisy")
    public List<Przepis> zwrocWszystkiePrzepisy();
}
