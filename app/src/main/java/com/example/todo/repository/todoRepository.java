package com.example.todo.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.todo.dao.todoDAO;
import com.example.todo.database.todoDatabase;
import com.example.todo.model.todo;

import java.util.List;

public class todoRepository {
    public todoDAO todoDAO;
    public LiveData<List<todo>> getalltodo;

    public  todoRepository(Application application){
        todoDatabase database = todoDatabase.getDatabaseInstance(application);
        todoDAO = database.todoDAO();
        getalltodo = todoDAO.getalltodo();
    }

    public void insertToDo(todo todos){
        todoDAO.insertToDo(todos);
    }
    public void deleteToDo(int id ){
        todoDAO.deleteToDo(id);
    }
    public void updateToDo(todo todos){
        todoDAO.updateToDo(todos);
    }
}
