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
    private String mDetail;
    private Date mDate;
    private boolean mIsComplete;

    // This whole class will be used as an object later.
    // This method will be called... upon instantiation?
    public Todo() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    // Right clicked the attributes to create getter and setter methods.
    // But removed the m for the automatically generated methods
    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    // Missed the detail attribute the first time through, woops!
    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String mDetail) {
        this.mDetail = mDetail;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isIsComplete() {
        return mIsComplete;
    }

    public void setIsComplete(boolean mIsComplete) {
        this.mIsComplete = mIsComplete;
    }
}
