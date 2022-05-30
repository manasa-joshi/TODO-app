package com.example.todo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.todo.R;
import com.example.todo.databinding.ActivityInsertToDoBinding;
import com.example.todo.model.todo;
import com.example.todo.viewModel.todoViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertToDo extends AppCompatActivity {

    ActivityInsertToDoBinding binding;
    String title, detail;
    todoViewModel viewModel;
    String priority = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertToDoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel= new ViewModelProvider(this).get(todoViewModel.class);

        binding.redPriority.setOnClickListener( v->{

            binding.redPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.yellowPriority.setImageResource(0);
            binding.greenPriority.setImageResource(0);
            priority = "1";
        });
        binding.yellowPriority.setOnClickListener( v->{
            binding.redPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
            binding.greenPriority.setImageResource(0);
            priority = "2";
        });
        binding.greenPriority.setOnClickListener( v->{
            binding.redPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(0);
            binding.greenPriority.setImageResource(R.drawable.ic_baseline_done_24);
            priority = "3";
        });

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = binding.title.getText().toString();
                detail = binding.detail.getText().toString();

                CreateToDo(title,detail); 
            }

            private void CreateToDo(String title, String detail) {
                Date Date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //CharSequence sequence = DateFormat.getTimeInstance().format("MMMM,d,YYYY");
                todo todo1 = new todo();
               todo1.Title = title;
               todo1.Detail = detail;
               todo1.Priority= priority;
               todo1.Date = dateFormat.format(Date);
               viewModel.insertToDos(todo1);
                Toast.makeText(InsertToDo.this, "Notes Created Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}