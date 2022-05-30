package com.example.todo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todo.model.todo;

import java.util.List;

@Dao
public interface todoDAO {
    @Query("SELECT * FROM todo_table")
    LiveData<List<todo>> getalltodo();

    @Insert
    void insertToDo(todo... todos);

    @Query("DELETE FROM todo_table WHERE id=:id")
    void deleteToDo(int id);

    @Update
    void updateToDo(todo todos);

}
