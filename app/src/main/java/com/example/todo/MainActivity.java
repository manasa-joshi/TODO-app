package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.todo.activity.InsertToDo;
import com.example.todo.adapter.todoAdapter;
import com.example.todo.viewModel.todoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btn;
    todoViewModel viewModel;
    RecyclerView todoRecycler;
    todoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.floatingActionButton);
        todoRecycler = findViewById(R.id.todoRecycler);

        viewModel= new ViewModelProvider(this).get(todoViewModel.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InsertToDo.class);
                startActivity(intent);
            }
        });

        viewModel.getalltodo.observe(this, todos -> {

            adapter= new todoAdapter(MainActivity.this,todos);
            todoRecycler.setLayoutManager( new LinearLayoutManager(this));
            todoRecycler.setAdapter(adapter);
        });
    }
}