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

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Person> personList;

    public MyAdapter(ArrayList<Person> personList) {
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

        holder.id.setText("" + person.id);
        holder.name.setText(person.name);
        holder.age.setText("" + person.age);
        holder.weight.setText(Double.toString(person.weight));
        holder.growth.setText("" + person.growth);

//        holder.id.setText(personList.get(position).id);
//        holder.name.setText(personList.get(position).name);
//        holder.age.setText(personList.get(position).age);
//        holder.weight.setText(personList.get(position).weight);
//        holder.growth.setText(personList.get(position).growth);

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void update(ArrayList<Person> list) {
        personList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        TextView age;
        TextView weight;
        TextView growth;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
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
