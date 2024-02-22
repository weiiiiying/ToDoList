package com.example.todolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

//2. Create the DAO to access to MoodNote database
@Dao
public interface ToDoDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    // the convenience method - insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ToDo todo);

    // the query method
    @Query("DELETE FROM ToDo")
    void deleteAll();

    @Delete
    void delete(ToDo todo);

    // LiveData works with Room database to get instant update whenever there is any changes
    @Query("SELECT * FROM ToDo ORDER BY mDate ASC")
    LiveData<List<ToDo>> getAscendingNote();
}

