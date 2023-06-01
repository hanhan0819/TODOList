package sg.edu.rp.c346.id21007466.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etNewTodo;
    Button btnAdd, btnClearAll;
    ListView lvTodo;
    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNewTodo = findViewById(R.id.editTextText);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnClearAll = findViewById(R.id.buttonClearItem);
        lvTodo = findViewById(R.id.listviewTodo);

        alTodo = new ArrayList<>();
        aaTodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTodo);
        lvTodo.setAdapter(aaTodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = etNewTodo.getText().toString();
                alTodo.add(newTodo);
                aaTodo.notifyDataSetChanged();
                etNewTodo.setText("");
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTodo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });
    }
}