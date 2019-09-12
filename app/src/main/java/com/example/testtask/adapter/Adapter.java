package com.example.testtask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtask.R;
import com.example.testtask.repository.Person;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Person> personList;

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id =itemView.findViewById(R.id.textViewId);
        TextView name =itemView.findViewById(R.id.textViewName);
        TextView age =itemView.findViewById(R.id.textViewAge);
        TextView weight =itemView.findViewById(R.id.textViewWeight);
        TextView growth =itemView.findViewById(R.id.textViewGrowth);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
