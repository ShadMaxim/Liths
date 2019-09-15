package com.example.testtask.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.testtask.R;
import com.example.testtask.adapter.MyAdapter;
import com.example.testtask.repository.Person;
import com.example.testtask.repository.PersonRepository;

import java.util.List;

public class StartActivity extends AppCompatActivity implements View {

    Presenter presenter;
    MyAdapter adapter;
    Button sortButton;
    EditText searchByCharName;
    String search;

    @RequiresApi(api = Build.VERSION_CODES.N)
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

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTextChanged(CharSequence charName, int i, int i1, int i2) {

                search = charName.toString();
                presenter.searchUsers(search);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sortButton.setOnClickListener(view ->
                presenter.sortList());

    }

    @Override
    public void showList(List<Person> list) {
        adapter.update(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}