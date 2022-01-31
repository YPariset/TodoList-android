package com.example.myapplication.objects;

import com.example.myapplication.adapters.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private static final List<Todo> TASK_ENTITIES_LIST = new ArrayList<Todo>();
    private static AdapterView adapter;

    public TodoList() {
        super();
    }

    public void addTodo(Todo todo) {
        TASK_ENTITIES_LIST.add(todo);

        if (adapter != null)
            adapter.notifyItemInserted(TASK_ENTITIES_LIST.size()-1);
    }

    public void removeTodo(Todo todo) {
        int index = TASK_ENTITIES_LIST.indexOf(todo);
        TASK_ENTITIES_LIST.remove(todo);

        if (adapter != null)
            adapter.notifyItemRemoved(index);
    }

    public void setTodoDone(Todo todo, boolean isDone)
    {
        int index = TASK_ENTITIES_LIST.indexOf(todo);

        if (isDone)
        {
            TASK_ENTITIES_LIST.get(index).setDone();
        } else
        {
            TASK_ENTITIES_LIST.get(index).setUndone();
        }

        if (adapter != null)
            adapter.notifyItemChanged(index);
    }

    public List<Todo> getTodoList() {
        return TASK_ENTITIES_LIST;
    }

    public TodoList setAdapter(AdapterView adapter)
    {
        this.adapter = adapter;

        return this;
    }
}
