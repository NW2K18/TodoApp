package com.example.c3476207.todoapp;

import android.content.Context;
import java.util.ArrayList;

// This class is the model, what is a model in MVC terms?
// Answer: The attributes.
public class TodoModel {

    // Class creates an instance of itself, why?
    // Answer: ___
    private static TodoModel sTodoModel;

    // Creates an array of to-do objects, because there will be multiple
    // objects to use.
    private ArrayList<Todo> mTodoList;

    // So if the model is null, it creates one using the context
    public static TodoModel get(Context context) {
        if (sTodoModel == null) {
            sTodoModel = new TodoModel(context);
        }
        return sTodoModel;
    }

    private TodoModel (Context context) {
        // An array list with no data?
        mTodoList = new ArrayList<>();

        // Below is comments that came with the code.
        // refactor to pattern for data plugins
        // simulate some data for testing

        // This changes the data to be displayed to user.
        // In this default code, there are 3 tasks
        for (int i = 0; i < 3; i++) {
            Todo todo = new Todo();
            todo.setTitle("Todo title " + i);
            todo.setDetail("Detail for task " + todo.getId().toString());
            todo.setIsComplete(false);

            // Adds this to-do to the list.
            mTodoList.add(todo);
        }
    }
}
