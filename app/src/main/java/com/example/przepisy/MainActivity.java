package com.example.przepisy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
    private PrzepisDataBase przepisDataBase;
    private EditText editTextNazwa, editTextSkladniki, editTextCzasgotowania;
    private Spinner spinnerIlosc;
    private CheckBox checkBoxCzyGluteinowy;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editTextNazwa = findViewById(R.id.editTextNazwa);
        editTextSkladniki = findViewById(R.id.editTextSkladnik);
        editTextCzasgotowania = findViewById(R.id.editTextText3);
        spinnerIlosc = findViewById(R.id.spinner);
        checkBoxCzyGluteinowy = findViewById(R.id.checkBox);

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