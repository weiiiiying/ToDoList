package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {

    public static final String ExtraDate = "date";
    public static final String ExtraToDo = "Mad Practical";
    public static final String ExtraTime = "time";
    public static final String ExtraNote = "description";

    private EditText ETDate, ETNote, ETTodo, ETTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);



        ETDate = findViewById(R.id.ETDate);
        ETNote = findViewById(R.id.ETNote);
        ETTime = findViewById(R.id.ETTime);
        ETTodo = findViewById(R.id.ETToDo);



        final Button button = findViewById(R.id.BtnSave);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            String date = ETDate.getText().toString();
            String note = ETNote.getText().toString();
            String todo = ETTodo.getText().toString();
            String time = ETTime.getText().toString();



            if (TextUtils.isEmpty(ETDate.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            }
            else if (TextUtils.isEmpty(ETNote.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            }
            else {
                replyIntent.putExtra(ExtraDate, date);
                replyIntent.putExtra(ExtraNote, note);
                replyIntent.putExtra(ExtraTime, time);
                replyIntent.putExtra(ExtraToDo, todo);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    public void showDatePickerDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        ETDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void showTimePickerDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        ETTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

}
