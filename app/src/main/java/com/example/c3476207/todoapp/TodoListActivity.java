package com.example.c3476207.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class TodoListActivity extends AppCompatActivity {

    @Override
    // OnCreate method is neccessary for android programs
    // Uses saved instance state to handle rotation problem
    // Sets content view to activity fragment, which contains recyclerview
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // Create a fragment manager to handle fragments
        // And grabs a fragment from the container
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // If no fragment was acquired, then creates a new fragment
        if (fragment == null) {
            TodoListFragment todoListFragment = new TodoListFragment ();
            fm.beginTransaction()
                    .add(R.id.fragment_container, todoListFragment)
                    .commit();
        }
    }
}
