package ru.startandroid.p0012noteseditorsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btCreate;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCreate = (Button) findViewById(R.id.btCreate);
        etInput = findViewById(R.id.etInput);

        //Присваиваем переменной наш RecyclerView
        recyclerView = (RecyclerView)findViewById(R.id.rv);

        //Теперь нашему компоненту RecyclerView необходимо указать, отображать список вертикально или горизонтально
        //Для этого устанавливаем ему LayoutManager с нужным атрибутом
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Создаем пустой массив для хранения заметок
        final ArrayList<String> notes = new ArrayList<>();

        //Создаем объект адаптера
        final NoteAdapter <String> noteAdapter;
        noteAdapter = new NoteAdapter<String>(this, R.layout.item, notes);

        // Привяжем массив через адаптер к RecyclerView
        recyclerView.setAdapter(noteAdapter);

        // Обработка нажатия кнопки +
        View.OnClickListener oclBtCreate = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.add(0, etInput.getText().toString());
                noteAdapter.notifyDataSetChanged();

                // Очищаем поле ввода
                etInput.setText("");
            }
        };

        // Присваиваем обработчик кнопке
        btCreate.setOnClickListener(oclBtCreate);

    }
}
