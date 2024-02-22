package com.example.todolist;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAdapter extends ListAdapter<ToDo, ToDoViewHolder> {

    Context mContext;

    public ToDoListAdapter(@NonNull DiffUtil.ItemCallback<ToDo> diffCallback, Context applicationContext) {
        super(diffCallback);
        mContext = applicationContext;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ToDoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        ToDo current = getItem(position);
        holder.bind(current.getmDate(), current.getmToDo(), current.getmTime(), current.getmDesc());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    removeItem(position);
                }
            }
        });
    }

    private void removeItem(int position) {
        ToDo current = getItem(position);

        //Remove the item from the dataset
        List<ToDo> newList = new ArrayList<>(getCurrentList());
        newList.remove(position);
        submitList(newList);

        deleteDataFromDatabase(current);
    }

    private void deleteDataFromDatabase(ToDo toDo) {
        ToDoRoomDatabase.databaseWriteExecutor.execute(()->{
            ToDoDao dao = ToDoRoomDatabase.getDatabase(mContext).todoDao();
            dao.delete(toDo);
        });
    }

    static class NoteDiff extends DiffUtil.ItemCallback<ToDo> {

        @Override
        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getmDesc().equals(newItem.getmDesc());
        }
    }
}

