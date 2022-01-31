package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.objects.Todo;
import com.example.myapplication.objects.TodoList;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final TextView date;
        private final CheckBox checkBox;
        private final Button btnDelete;
        private Todo todo = null;

        public ViewHolder(View view, TodoList model) {
            super(view);

            title = (TextView) view.findViewById(R.id.todoTitle);
            description = (TextView) view.findViewById(R.id.todoDescription);
            date = (TextView) view.findViewById(R.id.todoDate);
            checkBox = (CheckBox) view.findViewById(R.id.todoCheckBox);
            btnDelete = (Button) view.findViewById(R.id.btnDelete);

            checkBox.setOnClickListener(new View.OnClickListener() {
                private TodoList model;

                @Override
                public void onClick(View view) {
                    boolean checked = ((CheckBox) view).isChecked();

                    if (todo != null)
                        this.model.setTodoDone(todo, checked);
                }

                public View.OnClickListener init(TodoList model) {
                    this.model = model;

                    return this;
                }
            }.init(model));


            btnDelete.setOnClickListener(new View.OnClickListener() {
                private TodoList model;

                @Override
                public void onClick(View view) {
                    if (todo != null)
                        this.model.removeTodo(todo);
                }

                public View.OnClickListener init(TodoList model) {
                    this.model = model;

                    return this;
                }
            }.init(model));
        }

        public TextView getTitleTextView() { return title; }
        public TextView getDescriptionTextView() {
            return description;
        }
        public TextView getDateTextView() {
            return date;
        }
        public CheckBox getCheckBox() {
            return checkBox;
        }
        public void setTask(Todo todo) {
            this.todo = todo;
        }
    }

    private final List<Todo> todoList;

    public AdapterView(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_list, viewGroup, false);

        return new ViewHolder(view, new TodoList().setAdapter(this));
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTitleTextView().setText(todoList.get(position).getTitle());
        viewHolder.getDescriptionTextView().setText(todoList.get(position).getDescription());

        SimpleDateFormat formater =  new SimpleDateFormat("EEE, MMM d, ''yy");
        String dateformater = formater.format(todoList.get(position).getDate().getTime());

        viewHolder.getDateTextView().setText(dateformater);
        viewHolder.getCheckBox().setChecked(todoList.get(position).isDone());
        viewHolder.setTask(todoList.get(position));
    }
}
