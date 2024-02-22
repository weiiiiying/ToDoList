package com.example.todolist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// 5. Created a class called MoodNoteViewModel that gets the Application as a parameter and
// extends AndroidViewModel.
public class ToDoViewModel extends AndroidViewModel {

    //Added a private member variable to hold a reference to the repository.
    private MoodNoteRepository mRepository;
    private final LiveData<List<ToDo>> mAllTodo;

    //Implemented a constructor that creates the MoodNoteRepository.
    //In the constructor, initialized the allNotes LiveData using the repository.
    public ToDoViewModel (Application application) {
        super(application);
        mRepository = new MoodNoteRepository(application);
        mAllTodo = mRepository.getAllToDo();
    }
    //Added a getAllNotes() method to return a cached list of words.
    LiveData<List<ToDo>> getAllToDo() { return mAllTodo; }

    // Created a wrapper insert() method that calls the Repository's insert() method.
    // In this way, the implementation of insert() is encapsulated from the UI.
    public void insert(ToDo note) { mRepository.insert(note); }
}

