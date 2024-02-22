package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class ToDoViewHolder extends RecyclerView.ViewHolder {
    private final TextView noteDate;
    private final TextView noteContent;
    private final TextView noteToDo;
    private final TextView noteTime;
    public final CheckBox checkBox;

    private ToDoViewHolder(View itemView) {
        super(itemView);

        noteDate = itemView.findViewById(R.id.TVDateContent);
        noteContent = itemView.findViewById(R.id.TVNoteContent);
        noteToDo = itemView.findViewById(R.id.TVToDoContent);
        noteTime = itemView.findViewById(R.id.TVTimeContent);
        checkBox = itemView.findViewById(R.id.CBToDo);
    }

    public void bind(String date, String todo, String time, String note) {
        noteDate.setText(date);
        noteContent.setText(note);
        noteTime.setText(time);
        noteToDo.setText(todo);
//        if (mood == 1)
//            noteMood.setImageResource(R.drawable.ic_baseline_sentiment_very_satisfied_24);
//        else if (mood == 2)
//            noteMood.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24);
//        else
//            noteMood.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
//
//        if (daynight == true)
//            noteDayNight.setImageResource(R.drawable.ic_baseline_wb_sunny_24);
//        else
//            noteDayNight.setImageResource(R.drawable.ic_baseline_shield_moon_24);
    }

    static ToDoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.individual_item_view, parent, false);
        return new ToDoViewHolder(view);
    }
}

