package com.example.c3476207.todoapp;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

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

    public Todo getTodo (UUID todoID) {

        // This is a getter method to return the section of the To-do list
        // that corresponds to the ID: the index for the to-do array
        // This loop goes along the array
        // For each index of to-do, checks if the current ID corresponds to the index
        // When it does, it returns the to-do
        for (Todo todo : mTodoList) {
            if (todo.getId().equals(todoID)) {
                return todo;
            }
        }

        // Returns null at the end, because it already returned the to-do earlier
        return null;
    }

    // This method just returns the list, which is the array
    public ArrayList<Todo> getTodos() {
        return mTodoList;
    }

    // Method used for adding a new to-do onto the list
    public void addTodo (Todo todo) {
        mTodoList.add(todo);
    }
}
