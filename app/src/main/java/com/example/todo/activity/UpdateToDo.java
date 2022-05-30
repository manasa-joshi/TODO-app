package com.example.todo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todo.R;
import com.example.todo.databinding.ActivityUpdateToDoBinding;
import com.example.todo.model.todo;
import com.example.todo.viewModel.todoViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateToDo extends AppCompatActivity {
    String stitle, sdetail,spriority;
    int iid;
    ActivityUpdateToDoBinding binding;
    todoViewModel viewModel;
    String priority = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityUpdateToDoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel= new ViewModelProvider(this).get(todoViewModel.class);

        iid= getIntent().getIntExtra("id",0);
        stitle = getIntent().getStringExtra("title");
        sdetail= getIntent().getStringExtra("detail" );
        spriority=getIntent().getStringExtra("priority");

        binding.uptitle.setText(stitle);
        binding.updetail.setText(sdetail);
        if (spriority.equals("1")) {
            binding.redPriority.setImageResource(R.drawable.ic_baseline_done_24);
        } else if (spriority.equals("2")) {
            binding.yellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
        } else if (spriority.equals("3")) {
            binding.greenPriority.setImageResource(R.drawable.ic_baseline_done_24);
        }

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

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String title = binding.uptitle.getText().toString();
                String detail = binding.updetail.getText().toString();

                UpdateToDo(title,detail);
            }


            private void UpdateToDo(String title, String detail) {
                Date Date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //CharSequence sequence = DateFormat.getTimeInstance().format("MMMM,d,YYYY");
                todo uptodo = new todo();
                uptodo.id= iid;
                uptodo.Title = title;
                uptodo.Detail = detail;
                uptodo.Priority= priority;
                uptodo.Date = dateFormat.format(Date);
                viewModel.updateToDos(uptodo);
                Toast.makeText(UpdateToDo.this, "Notes Created Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.delete){
            BottomSheetDialog sheetDialog= new BottomSheetDialog(UpdateToDo.this);
            View view= LayoutInflater.from(UpdateToDo.this).inflate(R.layout.delete_popup,(LinearLayout)findViewById(R.id.bottomSheet));
            sheetDialog.setContentView(view);
            TextView yes,no;
            yes=view.findViewById(R.id.delete_yes);
            no= view.findViewById(R.id.delete_no);

            yes.setOnClickListener(v-> {
                viewModel.deleteToDos(iid);
                finish();
            });

            no.setOnClickListener(v-> {
                sheetDialog.dismiss();
            });
            sheetDialog.show();
        }
        return true;
    }
}