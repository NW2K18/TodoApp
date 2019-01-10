package com.example.c3476207.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TodoListActivity extends AppCompatActivity {

    @Override
    // OnCreate method is neccessary for android programs
    // Uses saved instance state to handle rotation problem
    // Sets content view to to-do list
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
    }
}
