package com.example.c3476207.todoapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class TodoListFragment extends Fragment{

    // Create recycler view and adapter objects
    // What is an Adapter? Used for populating the view
    // Kind of like the bridge between view and model
    private RecyclerView mTodoRecyclerView;

    // OnCreate method
    public void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // This is the adapter which has been referred to earlier
    // It uses the functions that come with the recycler view adapter
    // Allows the view to be inflated into the holder
    public class TodoAdapter extends RecyclerView.Adapter<TodoListFragment.TodoHolder> {

        // This is a list of To-do objects
        private List<Todo> mTodos;

        // Populates the mTodos with todos
        public TodoAdapter(List<Todo> todos) {
            mTodos = todos;
        }

        // This is a ViewHolder, which is applied on create
        @Override
        public TodoListFragment.TodoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new TodoHolder(layoutInflater, parent);
        }

        // position is the index, holder is the holder
        // This binds the to-do object to the list of to-do objects
        @Override
        public void onBindViewHolder(TodoHolder holder, int position) {
            Todo todo = mTodos.get(position);
            holder.bind(todo);
        }

        // Simply returns the size of array
        @Override
        public int getItemCount() {
            return mTodos.size();
        }

    }

    TodoAdapter mTodoAdapter;

    // OnCreateView, this is the view that is being created
    // When is this called?
    // This one has an inflater with a container, as it inflates a fragment inside a container
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        // This sets the recycler view for ListFragment
        mTodoRecyclerView = (RecyclerView) view.findViewById(R.id.todo_recycler_view);
        mTodoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        UpdateUI();

        return view;
    }

    // This method does not return anything
    // It updates UI by updating the arraylist and adapter
    private void UpdateUI() {
        ArrayList todos = new ArrayList<>();
        TodoModel todoModel = TodoModel.get(getContext());
        todos = todoModel.getTodos();

        if (mTodoAdapter == null) {
            mTodoAdapter = new TodoAdapter(todos);
            // Sets our adapter as this recyclerview's adapter
            mTodoRecyclerView.setAdapter(mTodoAdapter);
        }
        else {
            mTodoAdapter.notifyDataSetChanged();
        }
    }

    // This method holds the view.
    public class TodoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // These are view objects
        // They are set to appear with an interaction of an OnClickListener
        private Todo mTodo;
        private TextView mTextViewTitle;
        private TextView mTextViewDate;

        // Creates an instance of itself as an object
        // Passes in the inflater, which inflates the view
        // from list_item_todo, using strings from the title and date
        // OnClickListener is set
        // Why do clicks need to be listened for? To make a "Toast"
        public TodoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_todo, parent, false));

            itemView.setOnClickListener(this);

            mTextViewTitle = (TextView) itemView.findViewById(R.id.todo_title);
            mTextViewDate = (TextView) itemView.findViewById(R.id.todo_date);
        }

        // Toasts are views that contain quick little messages for a period of time
        @Override
        public void onClick(View view) {
            // Making text to say that it has been clicked
            Toast.makeText(
                    getActivity(),
                    mTodo.getTitle() + " clicked",
                    Toast.LENGTH_SHORT)
                    .show();

            // Intent to acquire the activity from To-doActivity
            Intent intent = TodoActivity.newIntent(getActivity(), mTodo.getId());
            startActivity(intent);

        }

        // Purpose of this method is to bind the current values of title and date to the array
        public void bind(Todo todo){
            mTodo = todo;
            mTextViewTitle.setText(mTodo.getTitle());
            mTextViewDate.setText(mTodo.getDate().toString());
        }

    }
}
