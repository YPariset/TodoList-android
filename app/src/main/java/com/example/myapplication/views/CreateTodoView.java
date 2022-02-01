package com.example.myapplication.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.objects.Todo;
import com.example.myapplication.objects.TodoList;

import java.util.Calendar;
import java.util.Date;

public class CreateTodoView extends Fragment {
    private DatePicker datePicker;
    private EditText editTitle;
    private EditText editDescription;
    private final TodoList todoList;

    public CreateTodoView() {
        // Required empty public constructor
        todoList = new TodoList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_create, container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.datePicker = (DatePicker) getView().findViewById(R.id.datePicker);
        this.editTitle = (EditText) getView().findViewById(R.id.editTextTitle);
        this.editDescription = (EditText) getView().findViewById(R.id.editTextDescription);
        Button btnSubmit = (Button) getView().findViewById(R.id.btnAdd);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            private CreateTodoView createTodoView;

            @Override
            public void onClick(View view) {
                createTodoView.createTask();
                Toast.makeText(getContext(), "Todo '" + editTitle.getText().toString() + "' added to list !", Toast.LENGTH_LONG).show();
            }

            public View.OnClickListener init(CreateTodoView createTodoView) {
                this.createTodoView = createTodoView;

                return this;
            }
        }.init(this));

    }


    public void createTask() {
        Date date = CalendarDatePicker().getTime();
        String title = this.editTitle.getText().toString();
        String description = this.editDescription.getText().toString();


        this.todoList.addTodo(new Todo(title, description, date));
        editTitle.setText("");
        editDescription.setText("");
    }

    private Calendar CalendarDatePicker() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar;
    }
}
