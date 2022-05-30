package com.example.todo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todo.model.todo;
import com.example.todo.dao.todoDAO;

@Database(entities = {todo.class}, version = 1)
public abstract class todoDatabase extends RoomDatabase {
     public abstract todoDAO todoDAO();
     public static todoDatabase INSTANCE;

     public static todoDatabase getDatabaseInstance(Context context)
     {
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    todoDatabase.class,
                    "todo_table").allowMainThreadQueries().build();
        }
        return INSTANCE;
     }
}
