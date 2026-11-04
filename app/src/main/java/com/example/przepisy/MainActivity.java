package com.example.przepisy;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    private PrzepisDataBase przepisDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        przepisDataBase = Room.databaseBuilder(
                getApplicationContext(),
                PrzepisDataBase.class,
                "przepisy_db"
        )
                .allowMainThreadQueries()
                .build();
        przepisDataBase.zwrocPrzepisDAO().wstawDoBazy(
                new Przepis("Spaghetti", "papryka, mieso mielone,makaron, cebula,sos, przprawy", 1, 4, false)
        );
    }
}