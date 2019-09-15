package com.example.testtask.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtask.R;
import com.example.testtask.repository.Person;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Person> personList;

    public MyAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        Person person = personList.get(position);

        holder.id.setText(Integer.toString(person.id));
        holder.name.setText(person.name);
        holder.age.setText(Integer.toString(person.age));
        holder.weight.setText(Double.toString(person.weight));
        holder.growth.setText(Double.toString(person.growth));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void update(List<Person> list) {
        personList = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        TextView age;
        TextView weight;
        TextView growth;
        LinearLayout linearLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.id =itemView.findViewById(R.id.textViewId);
            this.name =itemView.findViewById(R.id.textViewName);
            this.age =itemView.findViewById(R.id.textViewAge);
            this.weight =itemView.findViewById(R.id.textViewWeight);
            this.growth =itemView.findViewById(R.id.textViewGrowth);
            this.linearLayout = itemView.findViewById(R.id.linerLayout);
        }
    }
}
