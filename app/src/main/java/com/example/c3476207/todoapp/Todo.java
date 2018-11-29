package com.example.c3476207.todoapp;

import java.util.Date;
import java.util.UUID;

// This is a new class Todo
public class Todo {
    // Typed alt + enter to resolve imports.
    // These are all standard parameters for the app.
    // What is an UUID?
    // Answer: ___
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mIsComplete;

    // This whole class will be used as an object later.
    // This method will be called... upon instantiation?
    public Todo() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    // Right clicked the attributes to create getter and setter methods.
    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismIsComplete() {
        return mIsComplete;
    }

    public void setmIsComplete(boolean mIsComplete) {
        this.mIsComplete = mIsComplete;
    }
}
