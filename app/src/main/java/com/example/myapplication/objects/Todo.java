package com.example.myapplication.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Todo implements Serializable {

    private final String title;
    private final String description;
    private final Date date;
    private boolean isDone = false;

    public Todo(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return isDone == todo.isDone && Objects.equals(title, todo.title) && Objects.equals(description, todo.description)&& Objects.equals(date, todo.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date, isDone);
    }
    public Date getDate() {
        return date;
    }
    public boolean isDone() {
        return isDone;
    }
    public void setDone() {
        isDone = true;
    }
    public void setUndone() {
        isDone = false;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
