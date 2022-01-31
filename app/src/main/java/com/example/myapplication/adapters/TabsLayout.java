package com.example.myapplication.adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.views.CalendarView;
import com.example.myapplication.views.CreateTodoView;
import com.example.myapplication.views.TodoListView;

public class TabsLayout extends FragmentPagerAdapter {

    Context context;
    int tab_id;

    public TabsLayout(Context context , FragmentManager fragmentManager , int tabs) {
        super(fragmentManager);
        tab_id = tabs;
        this.context = context;

    }

    @Override
    public Fragment getItem(int tab) {
        switch (tab) {
            case 0:
                return new TodoListView();
            case 1:
                return new CreateTodoView();
            case 2:
                return new CalendarView();
            default:
                return new TodoListView();

        }
    }

    @Override
    public int getCount() {
        return tab_id;
    }
}
