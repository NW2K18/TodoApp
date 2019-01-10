package com.example.c3476207.todoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import java.util.UUID;

public class TodoActivity extends AppCompatActivity {

    // This is an Extra
    public static final String EXTRA_TODO_ID = "todo_id";

    // This is an intent
    // What is a context? Answer: ___
    // Puts an extra which is a key-value pair
    // Creates an intent within the intent to return it
    public static Intent newIntent (Context packageContext, UUID todoId) {
        Intent intent = new Intent (packageContext, TodoActivity.class);
        intent.putExtra(EXTRA_TODO_ID, todoId);
        return intent;
    }

    // The newInstance method decouples the fragment returns the fragment
    // by grabbing the ID of the to-do
    protected Fragment createFragment() {
        UUID todoId = (UUID) getIntent().getSerializableExtra(EXTRA_TODO_ID);
        return TodoFragment.newInstance(todoID);
    }

    // This is the onCreate method that sets layout.
    // Very similar to onCreate for To-doListActivity except for fragment creation
    // Because the fragments are different
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        // Create a fragment manager to handle fragments
        // And grabs a fragment from the container
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // If no fragment was acquired, then creates a new fragment
        if (fragment == null) {
            Fragment todoFragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, todoFragment)
                    .commit();
        }
    }
}
