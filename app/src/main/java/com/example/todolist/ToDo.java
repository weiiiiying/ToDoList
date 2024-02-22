package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ToDo {
    @PrimaryKey(autoGenerate = true)
    public int mToDoID;

    @NonNull
    public String mToDo;
    @NonNull
    public String mDate;
    @NonNull
    public String mDesc;
    @NonNull
    public String mTime;


    public ToDo(@NonNull String date, @NonNull String mToDo, @NonNull String time, @NonNull String desc) {
        this.mDate = date;
        this.mToDo = mToDo;
        this.mTime = time;
        this.mDesc = desc;
    }
    public String getmToDo(){return this.mToDo;}
    public String getmDate(){return this.mDate;}
    public String getmTime(){return this.mTime;}
    public String getmDesc(){return this.mDesc;}

}

