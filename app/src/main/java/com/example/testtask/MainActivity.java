package com.example.testtask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.testtask.adapter.MyAdapter;
import com.example.testtask.repository.Person;
import com.example.testtask.repository.PersonRepository;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View {

    Presenter presenter;
    MyAdapter adapter;
    Button sortButton;
    EditText searchByCharName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_layout);

        presenter = new Presenter();
        presenter.setView(this);

        sortButton = findViewById(R.id.sortButton);
        searchByCharName = findViewById(R.id.searchByCharName);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(PersonRepository.listPerson());

        DividerItemDecoration decor = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        recyclerView.addItemDecoration(decor);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        searchByCharName.addTextChangedListener(new TextWatcher() {

            //Handler timer;
            String search;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charName, int i, int i1, int i2) {

                /*timer = new Handler();
                timer.postDelayed(search = charName.toString(), 500);*/
                search = charName.toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sortButton.setOnClickListener(new android.view.View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(android.view.View view) {
                //presenter.createNewList();
                presenter.sortList();
            }
        });

    }

    @Override
    public void createList() {

    }

    @Override
    public void showNewList(ArrayList<Person> list) {
        adapter.update(list);
    }

    @Override
    public void showSortList(ArrayList<Person> list) {
        adapter.update(list);
    }
}