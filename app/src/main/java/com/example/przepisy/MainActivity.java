package com.example.przepisy;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PrzepisDataBase przepisDataBase;
    private EditText editTextNazwa, editTextSkladniki, editTextCzasgotowania;
    private Spinner spinnerIlosc;
    private CheckBox checkBoxCzyGluteinowy;
    private Button button;
    private ListView listView;
    private ArrayAdapter<Przepis> arrayAdapter;
    private List<Przepis> przepisy;

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
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Przepis przepis = new Przepis(
                                editTextNazwa.getText().toString(),
                                editTextSkladniki.getText().toString(),
                                Integer.parseInt(editTextCzasgotowania.getText().toString()),
                                Integer.parseInt(spinnerIlosc.getSelectedItem().toString()),
                                checkBoxCzyGluteinowy.isChecked()
                        );
                        przepisDataBase.zwrocPrzepisDAO().wstawDoBazy(przepis);
                        przepisy.add(przepis);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
        listView = findViewById(R.id.listview);
        przepisy = przepisDataBase.zwrocPrzepisDAO().zwrocWszystkiePrzepisy();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, przepisy);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        przepisDataBase.zwrocPrzepisDAO().usunZBazy(przepisy.get(i));
                        przepisy.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        return false;

                    }
                }
        );
    }
}