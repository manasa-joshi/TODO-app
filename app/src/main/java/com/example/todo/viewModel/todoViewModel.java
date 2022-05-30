package com.example.todo.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo.model.todo;
import com.example.todo.repository.todoRepository;

import java.util.List;

public class todoViewModel extends AndroidViewModel {

    public  todoRepository repository;
    public LiveData<List<todo>> getalltodo;

    public todoViewModel(Application application) {
        super(application);
        repository= new todoRepository(application);
       getalltodo= repository.getalltodo;
    }

    public void insertToDos(todo todos ){
        repository.insertToDo(todos);
        
    }
    public void updateToDos(todo todos ){
        repository.updateToDo(todos);

    }
    public void deleteToDos(int id){
        repository.deleteToDo(id);

    }
}
