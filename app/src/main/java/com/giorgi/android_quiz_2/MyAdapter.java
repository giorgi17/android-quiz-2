package com.giorgi.android_quiz_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;


import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Post> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView userId, id, title, completed;
        public MyViewHolder(View v) {
            super(v);
            userId = (TextView) v.findViewById(R.id.userId);
            id = (TextView) v.findViewById(R.id.id);
            title = (TextView) v.findViewById(R.id.title);
            completed = (TextView) v.findViewById(R.id.completed);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Post> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
//        TextView tv = (TextView)v.findViewById(R.id.userId);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.userId.setText("userId - " + mDataset.get(position).userId);
        holder.id.setText("id - " + mDataset.get(position).id);
        holder.title.setText("title - " + mDataset.get(position).title);
        holder.completed.setText("completed - " + mDataset.get(position).completed + "\n -----------" +
                "---------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------------------------------");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}