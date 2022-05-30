package com.example.todo.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Insert;

import com.example.todo.MainActivity;
import com.example.todo.R;
import com.example.todo.activity.UpdateToDo;
import com.example.todo.model.todo;

import java.util.List;

public class todoAdapter extends RecyclerView.Adapter<todoAdapter.todoViewholder> {
    MainActivity mainActivity;
    List<todo> todos;

    public todoAdapter(MainActivity mainActivity, List<todo> todos) {
        this.mainActivity = mainActivity;
        this.todos = todos;
    }

    @Override
    public todoViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new todoViewholder(LayoutInflater.from(mainActivity).inflate(R.layout.item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(todoViewholder holder, int position) {
        if (todos.get(position).Priority.equals("1")) {
            holder.Priority.setBackgroundResource(R.drawable.red_shape);
        } else if (todos.get(position).Priority.equals("2")) {
            holder.Priority.setBackgroundResource(R.drawable.yellow_shape);
        } else if (todos.get(position).Priority.equals("3")) {
            holder.Priority.setBackgroundResource(R.drawable.green_shape);
        }
        holder.title.setText(todos.get(position).Title);
        holder.date.setText(todos.get(position).Date);

        holder.itemView.setOnClickListener(v -> {
            Intent intent= new Intent(mainActivity,UpdateToDo.class);
            intent.putExtra("id",todos.get(position).id);
            intent.putExtra("title",todos.get(position).Title);
            intent.putExtra("detail",todos.get(position).Detail);
            intent.putExtra("priority",todos.get(position).Priority);

            mainActivity.startActivity(intent);

        });


    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    static class todoViewholder extends RecyclerView.ViewHolder {

        TextView title, date;
        View Priority;

        public todoViewholder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.todoTitle);
            date = itemView.findViewById(R.id.todoDate);
            Priority = itemView.findViewById(R.id.Priority);
        }
    }

}
