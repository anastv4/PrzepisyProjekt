package com.example.przepisy;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "przepisy")
public class Przepis {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nazwa;

    public String skladnik;
    @ColumnInfo(name = "czas")
    public int czasPrzygotowania;

    public int iloscGosci;
    public boolean czyGlutenne;

    public Przepis(String nazwa, String skladnik, int czasPrzygotowania, int iloscGosci, boolean czyGlutenne) {
        this.nazwa = nazwa;
        this.skladnik = skladnik;
        this.czasPrzygotowania = czasPrzygotowania;
        this.iloscGosci = iloscGosci;
        this.czyGlutenne = czyGlutenne;
    }
    public Przepis(){

    }
}
